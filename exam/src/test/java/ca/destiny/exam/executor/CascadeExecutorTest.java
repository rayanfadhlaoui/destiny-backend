package ca.destiny.exam.executor;

import ca.destiny.ApplicationTest;
import ca.destiny.destinytest.AbstractIntegration;
import ca.destiny.exam.BattleConfiguration;
import ca.destiny.exam.executor.admiral.GrandAdmiralExamExecutor;
import ca.destiny.fighter.BattleFighterDto;
import ca.destiny.fighter.BattleInformation;
import ca.destiny.fighter.ClassEnum;
import ca.destiny.person.common.GenderEnum;
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
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

@ExtendWith(SpringExtension.class)
@Import(BattleConfiguration.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK, classes = ApplicationTest.class)
public class CascadeExecutorTest extends AbstractIntegration {

    @Autowired
    private GrandAdmiralExamExecutor grandAdmiralExamExecutor;

    public CascadeExecutorTest() {
        super(CascadeExecutorTest.class);
    }

    @Test
    void cascadeExamExecutor() throws IOException {
        long t1 = System.currentTimeMillis();
        List<BattleFighterDto> fighters = new ArrayList<>();
        grandAdmiralExamExecutor.execute(fighters, 0, new ArrayList<>());
        t1 = System.currentTimeMillis() - t1;
        System.out.println(t1 + " ms for all execution");

        fighters = fighters.stream()
                .filter(p -> p.getBattleInformation().getFightingStatus().isAlive())
                .collect(Collectors.toList());

        writeData(fighters, "LogTown.json");
    }

    @Test
    void cascadeExamExecutorFromExisting() throws IOException, URISyntaxException {
        List<BattleFighterDto> fighters = loadListFromFile("LogTown.json", new TypeReference<>() {
        });
        long t1 = System.currentTimeMillis();
        grandAdmiralExamExecutor.execute(fighters, 0, new ArrayList<>());
        t1 = System.currentTimeMillis() - t1;
        System.out.println(t1 + " ms for all execution");

        List<BattleFighterDto> alive = fighters.stream()
                .filter(p -> p.getBattleInformation().getFightingStatus().isAlive())
                .collect(Collectors.toList());
        List<BattleFighterDto> dead = fighters.stream()
                .filter(p -> !p.getBattleInformation().getFightingStatus().isAlive())
                .collect(Collectors.toList());

        writeListData(alive, "LogTown.json");
        writeListData(dead, "dead.json", true);
    }


    @Test
    void tmp() throws IOException, URISyntaxException {
        List<BattleFighterDto> fighters = loadListFromFile("LogTown.json", new TypeReference<>() {
        });
        List<BattleFighterDto> collect = fighters.stream()
//                .filter(p -> p.getPerson().getFirstName().equals("Johnny"))
//                .filter(p -> p.getPerson().getLastName().equals("MacDermott"))
                .sorted((o1, o2) -> Integer.compare(o2.getExperience().getNextLevel(), o1.getExperience().getNextLevel()))
                .collect(Collectors.toList());


        long admiralFemalCount = fighters.stream()
                .filter(p -> p.getPerson().getGender() == GenderEnum.FEMALE)
                .map(BattleFighterDto::getClassEnum)
                .filter(c -> c == ClassEnum.VICE_ADMIRAL || c == ClassEnum.ADMIRAL || c == ClassEnum.REAR_ADMIRAL || c == ClassEnum.SUB_ADMIRAL)
                .count();

        long admiralMalCount = fighters.stream()
                .filter(p -> p.getPerson().getGender() == GenderEnum.MALE)
                .map(BattleFighterDto::getClassEnum)
                .filter(c -> c == ClassEnum.VICE_ADMIRAL || c == ClassEnum.ADMIRAL || c == ClassEnum.REAR_ADMIRAL || c == ClassEnum.SUB_ADMIRAL)
                .count();

        System.out.println("af -> " + admiralFemalCount);
        System.out.println("am -> " + admiralMalCount);

        long eliteFemalCount = fighters.stream()
                .filter(p -> p.getPerson().getGender() == GenderEnum.FEMALE)
                .map(BattleFighterDto::getClassEnum)
                .filter(c -> c == ClassEnum.VICE_ADMIRAL || c == ClassEnum.ADMIRAL || c == ClassEnum.REAR_ADMIRAL || c == ClassEnum.SUB_ADMIRAL)
                .count();

        long eliteMalCount = fighters.stream()
                .filter(p -> p.getPerson().getGender() == GenderEnum.MALE)
                .map(BattleFighterDto::getClassEnum)
                .filter(c -> c == ClassEnum.COLONEL || c == ClassEnum.FIRST_LIEUTENANT || c == ClassEnum.JUNIOR_LIEUTENANT || c == ClassEnum.LIEUTENANT || c == ClassEnum.MAYOR)
                .count();

        System.out.println("ef -> " + eliteFemalCount);
        System.out.println("ef -> " + eliteFemalCount);
        System.out.println("em -> " + eliteMalCount);


        System.out.println("getVitality:" + getMaxCourage(fighters, BattleInformation::getVitality));
        System.out.println("getDefense:" + getMaxCourage(fighters, BattleInformation::getDefense));
        System.out.println("getDexterity:" + getMaxCourage(fighters, BattleInformation::getDexterity));
        System.out.println("getStamina:" + getMaxCourage(fighters, BattleInformation::getStamina));
        System.out.println("getSpeed:" + getMaxCourage(fighters, BattleInformation::getSpeed));
        System.out.println("getStrength:" + getMaxCourage(fighters, BattleInformation::getStrength));
        System.out.println("getDodge:" + getMaxCourage(fighters, BattleInformation::getDodge));
        System.out.println("getResistance:" + getMaxCourage(fighters, BattleInformation::getResistance));

    }

    private Integer getMaxCourage(List<BattleFighterDto> fighters, Function<BattleInformation, Integer> value) {
        return fighters.stream()
                .map(BattleFighterDto::getBattleInformation)
                .map(value)
                .max(Comparator.naturalOrder())
                .orElse(0);
    }
}
