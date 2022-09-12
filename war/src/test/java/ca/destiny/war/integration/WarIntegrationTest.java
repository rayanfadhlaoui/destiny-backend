package ca.destiny.war.integration;

import ca.destiny.ApplicationTest;
import ca.destiny.destinytest.AbstractIntegration;
import ca.destiny.evolution.refresh.BattleFighterRefresher;
import ca.destiny.fighter.BattleFighterDto;
import ca.destiny.fighter.BattleInformation;
import ca.destiny.fighter.ClassEnum;
import ca.destiny.fighter.equipment.weapon.WeaponDto;
import ca.destiny.person.PersonDto;
import ca.destiny.person.common.OriginTown;
import ca.destiny.war.WarService;
import com.fasterxml.jackson.core.type.TypeReference;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.groupingBy;

@ExtendWith(SpringExtension.class)
@Import(BattleConfiguration.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK, classes = ApplicationTest.class)
public class WarIntegrationTest extends AbstractIntegration {

    @Autowired
    private WarService warService;

    @Autowired
    private BattleFighterRefresher battleFighterRefresher;

    public WarIntegrationTest() {
        super(WarIntegrationTest.class);
    }

    @Test
    void cascadeExamExecutor() throws IOException, URISyntaxException {
        List<BattleFighterDto> allFighters = loadListFromFile("allFighters.json", new TypeReference<>() {
        });
        List<BattleFighterDto> fighters1 = groupByTown(allFighters, "Genesis Freak").stream().filter(f -> f.getClassEnum() == ClassEnum.ADMIRAL || f.getClassEnum() == ClassEnum.GRAND_ADMIRAL).collect(Collectors.toList());
        List<BattleFighterDto> fighters2 = groupByTown(allFighters, "Root Strain").stream().filter(f -> f.getClassEnum() == ClassEnum.ADMIRAL || f.getClassEnum() == ClassEnum.GRAND_ADMIRAL).collect(Collectors.toList());

        Stream.of(fighters1, fighters2)
                .flatMap(Collection::stream)
                .forEach(battleFighterDto -> {
                    battleFighterRefresher.refresh(battleFighterDto);
                    tmpAddStaminaToWeapon(battleFighterDto);
                    PersonDto person = battleFighterDto.getPerson();
                    person.setAge(person.getAge() + 1);
                });

        warService.execute(removeDead(fighters1), removeDead(fighters2));

        List<BattleFighterDto> dead = Stream.of(allFighters)
                .flatMap(Collection::stream)
                .filter(f -> !f.getBattleInformation().getFightingStatus().isAlive())
                .collect(Collectors.toList());
        writeListData(dead, "dead.json");
        writeData(removeDead(allFighters), "allFighters.json");
    }

    private List<BattleFighterDto> groupByTown(List<BattleFighterDto> allFighters, String town) {
        return allFighters.stream()
                .filter(f -> f.getPerson()
                        .getOriginTown()
                        .getName()
                        .equals(town))
                .collect(Collectors.toList());
    }


    @Test
    void dead() throws IOException, URISyntaxException {
        List<BattleFighterDto> fighters1 = loadListFromFile("dead.json", new TypeReference<>() {
        });
        List<BattleFighterDto> fighters2 = loadListFromFile("GenesisFreak.json", new TypeReference<>() {
        });
        List<BattleFighterDto> fighters3 = loadListFromFile("LongHall.json", new TypeReference<>() {
        });

        System.out.println(fighters1.size());
        System.out.println(fighters2.size());
        System.out.println(fighters3.size());
    }

    @Test
    void displayAllTown() throws IOException, URISyntaxException {
        List<BattleFighterDto> fighters1 = loadListFromFile("allFighters.json", new TypeReference<>() {
        });
        fighters1.stream()
                .map(BattleFighterDto::getPerson)
                .map(PersonDto::getOriginTown)
                .map(OriginTown::getName)
                .distinct()
                .forEach(System.out::println);
    }

    @Test
    void displayMaxAndMinimumDexByWeapon() throws IOException, URISyntaxException {
        List<BattleFighterDto> fighters1 = loadListFromFile("allFighters.json", new TypeReference<>() {
        });
        fighters1.forEach(battleFighterRefresher::refresh);
        Map<String, List<BattleFighterDto>> collect = fighters1.stream()
                .collect(groupingBy(f -> f.getEquipmentDto().getRightWeapon().getName().replaceAll("dagger|axe|fist|sword", "")));

        collect.forEach((k, v) -> {
            AtomicInteger moy = new AtomicInteger();
            v.stream().map(BattleFighterDto::getBattleInformation)
                    .map(BattleInformation::getDexterity)
                    .forEach(moy::addAndGet);
            System.out.println(k + " " + moy.get() / v.size());
        });
    }

    @Test
    void refresh() throws IOException, URISyntaxException {

        List<BattleFighterDto> fighters2 = loadListFromFile("GenesisFreak.json", new TypeReference<>() {
        });
        List<BattleFighterDto> fighters3 = loadListFromFile("LongHall.json", new TypeReference<>() {
        });
        Stream.of(fighters2, fighters3)
                .flatMap(Collection::stream)
                .map(BattleFighterDto::getPerson)
                .map(PersonDto::getAvailableBodyParts)
                .flatMap(Collection::stream)
                .forEach(bodyPartDtos -> {
                    bodyPartDtos.setPenalty(0);
                    bodyPartDtos.setInjuries(new ArrayList<>());
                });
        writeData(removeDead(fighters2), "GenesisFreak.json");
        writeData(removeDead(fighters3), "LongHall.json");
    }

    private List<BattleFighterDto> removeDead(List<BattleFighterDto> fighters) {
        return fighters.stream().filter(f -> f.getBattleInformation().getFightingStatus().isAlive()).collect(Collectors.toList());
    }

    private void tmpAddStaminaToWeapon(BattleFighterDto battleFighterDto) {
        WeaponDto rightWeapon = battleFighterDto.getEquipmentDto().getRightWeapon();
        rightWeapon.setBlunt(1);
        rightWeapon.setPenetration(0);
        if (rightWeapon.getMinimumDexterity() == -1) {
            if (rightWeapon.getName().startsWith("Wood")) {
                rightWeapon.setMinimumDexterity(5);
                rightWeapon.setOptimalDexterity(14);
            } else if (rightWeapon.getName().startsWith("Quality Wood")) {
                rightWeapon.setStaminaNeeded(3);
                rightWeapon.setMinimumDexterity(10);
                rightWeapon.setOptimalDexterity(20);
            } else if (rightWeapon.getName().startsWith("Iron")) {
                rightWeapon.setStaminaNeeded(5);
                rightWeapon.setMinimumDexterity(15);
                rightWeapon.setOptimalDexterity(30);
            } else if (rightWeapon.getName().startsWith("Quality Iron")) {
                rightWeapon.setStaminaNeeded(7);
                rightWeapon.setMinimumDexterity(20);
                rightWeapon.setOptimalDexterity(39);
            } else if (rightWeapon.getName().startsWith("Steel")) {
                rightWeapon.setStaminaNeeded(10);
                rightWeapon.setMinimumDexterity(25);
                rightWeapon.setOptimalDexterity(45);
            } else if (rightWeapon.getName().startsWith("Quality Steel")) {
                rightWeapon.setStaminaNeeded(15);
                rightWeapon.setMinimumDexterity(30);
                rightWeapon.setOptimalDexterity(55);
            } else if (rightWeapon.getName().startsWith("Cooper")) {
                rightWeapon.setStaminaNeeded(20);
                rightWeapon.setMinimumDexterity(40);
                rightWeapon.setOptimalDexterity(65);
            } else if (rightWeapon.getName().startsWith("Quality Cooper")) {
                rightWeapon.setStaminaNeeded(25);
                rightWeapon.setMinimumDexterity(50);
                rightWeapon.setOptimalDexterity(80);
            } else if (rightWeapon.getName().startsWith("Silver")) {
                rightWeapon.setStaminaNeeded(30);
                rightWeapon.setMinimumDexterity(60);
                rightWeapon.setOptimalDexterity(90);
            } else if (rightWeapon.getName().startsWith("Quality Silver")) {
                rightWeapon.setStaminaNeeded(35);
                rightWeapon.setMinimumDexterity(65);
                rightWeapon.setOptimalDexterity(95);
            } else if (rightWeapon.getName().startsWith("Golden")) {
                rightWeapon.setStaminaNeeded(40);
                rightWeapon.setMinimumDexterity(70);
                rightWeapon.setOptimalDexterity(116);
            } else if (rightWeapon.getName().startsWith("Quality Golden")) {
                rightWeapon.setStaminaNeeded(45);
                rightWeapon.setMinimumDexterity(80);
                rightWeapon.setOptimalDexterity(125);
            } else if (rightWeapon.getName().startsWith("Rubis")) {
                rightWeapon.setStaminaNeeded(50);
                rightWeapon.setMinimumDexterity(85);
                rightWeapon.setOptimalDexterity(140);
            } else if (rightWeapon.getName().startsWith("Quality Rubis")) {
                rightWeapon.setStaminaNeeded(55);
                rightWeapon.setMinimumDexterity(90);
                rightWeapon.setOptimalDexterity(155);
            } else if (rightWeapon.getName().startsWith("Diamond")) {
                rightWeapon.setStaminaNeeded(60);
                rightWeapon.setMinimumDexterity(100);
                rightWeapon.setOptimalDexterity(177);
            } else if (rightWeapon.getName().startsWith("Quality Diamond")) {
                rightWeapon.setStaminaNeeded(65);
                rightWeapon.setMinimumDexterity(110);
                rightWeapon.setOptimalDexterity(203);
            } else if (rightWeapon.getName().startsWith("Dragon")) {
                rightWeapon.setStaminaNeeded(70);
                rightWeapon.setMinimumDexterity(130);
                rightWeapon.setOptimalDexterity(220);
            } else if (rightWeapon.getName().startsWith("Hera") || rightWeapon.getName().startsWith("Shiva") || rightWeapon.getName().startsWith("Ramuh")) {
                rightWeapon.setStaminaNeeded(80);
                rightWeapon.setMinimumDexterity(300);
                rightWeapon.setOptimalDexterity(400);
            } else if (rightWeapon.getName().startsWith("Celestial Dragon")) {
                rightWeapon.setName("Celestial Dragon");
                rightWeapon.setStaminaNeeded(75);
                rightWeapon.setMinimumDexterity(150);
                rightWeapon.setOptimalDexterity(260);
            } else if (rightWeapon.getName().startsWith("Bare hand")) {
                rightWeapon.setStaminaNeeded(1);
                rightWeapon.setMinimumDexterity(1);
                rightWeapon.setOptimalDexterity(1);
            } else {
                throw new IllegalArgumentException(rightWeapon.getName());
            }
        }
    }
}
