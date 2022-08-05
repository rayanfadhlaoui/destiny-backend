package ca.destiny.evolution.integration;

import ca.destiny.ApplicationTest;
import ca.destiny.destinytest.AbstractIntegrationTest;
import ca.destiny.evolution.creation.FighterFactory;
import ca.destiny.evolution.creation.PersonFactory;
import ca.destiny.fighter.BattleFighterDto;
import ca.destiny.fighter.equipment.EquipmentDto;
import ca.destiny.fighter.equipment.weapon.WeaponDto;
import ca.destiny.game.GameInformationService;
import ca.destiny.person.common.DestinyDate;
import ca.destiny.person.common.RaceEnum;
import com.fasterxml.jackson.core.type.TypeReference;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.BDDMockito.given;

@ExtendWith(SpringExtension.class)
@Import(EvolutionConfiguration.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK, classes = ApplicationTest.class)
public class Creation extends AbstractIntegrationTest {

    public static final long GAME_ID = 1L;
    @Autowired
    private PersonFactory personFactory;
    @Autowired
    private FighterFactory fighterFactory;

    @Autowired
    private GameInformationService gameInformationServiceMock;

    @Test
    @Disabled
    void create() throws IOException, URISyntaxException {
        var destinyDate = createDestinyDate();
        given(gameInformationServiceMock.getCurrentDate(GAME_ID)).willReturn(destinyDate);
        List<BattleFighterDto> fighters = new ArrayList<>();
        for (int i = 0; i < 4096; i++) {
            var personDto = personFactory.create(RaceEnum.HUMAN, 1L);
            var fighter = fighterFactory.create(personDto, 1L);
            fighters.add(fighter);
        }

        writeData(fighters, "fighters.json");
    }

    @Test
    @Disabled
    void updateAddSword() throws IOException, URISyntaxException {
        List<WeaponDto> weapons = loadListFromFile("weapon.json", new TypeReference<>() {
        });
        List<BattleFighterDto> fighters = loadListFromFile("winners.json", new TypeReference<>() {
        });
        List<BattleFighterDto> fighters2 = loadListFromFile("apprenticeUpdated.json", new TypeReference<>() {
        });
        WeaponDto weaponDto = weapons.get(0);

        fighters.forEach(f -> {
            EquipmentDto equipmentDto = new EquipmentDto();
            equipmentDto.setRightWeapon(weaponDto);
            f.setEquipmentDto(equipmentDto);
        });

        System.out.println(fighters.size());
        fighters.addAll(fighters2);
        writeData(fighters, "fighters.json");
    }


    private DestinyDate createDestinyDate() {
        var destinyDate = new DestinyDate();
        destinyDate.setDay(1);
        destinyDate.setMonth(1);
        destinyDate.setYear(1);
        return destinyDate;
    }

}
