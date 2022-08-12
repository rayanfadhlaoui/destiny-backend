package ca.destiny.battle.integration;

import ca.destiny.ApplicationTest;
import ca.destiny.battle.factory.BattleBuilder;
import ca.destiny.battle.factory.BattleType;
import ca.destiny.battle.model.BattleDto;
import ca.destiny.battle.simulation.SimulationBattleExecutor;
import ca.destiny.evolution.creation.FighterFactory;
import ca.destiny.evolution.creation.PersonFactory;
import ca.destiny.evolution.levelup.ExperienceService;
import ca.destiny.fighter.BattleFighterDto;
import ca.destiny.fighter.BattleInformation;
import ca.destiny.fighter.CharacteristicsDto;
import ca.destiny.game.GameInformationService;
import ca.destiny.fighter.ClassEnum;
import ca.destiny.person.common.DestinyDate;
import ca.destiny.person.common.RaceEnum;
import com.fasterxml.jackson.core.type.TypeReference;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import ca.destiny.destinytest.AbstractIntegrationTest;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

import static org.mockito.BDDMockito.given;

@ExtendWith(SpringExtension.class)
@Import(BattleConfiguration.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK, classes = ApplicationTest.class)
public class Battle extends AbstractIntegrationTest {

    public static final long GAME_ID = 1L;
    @Autowired
    private SimulationBattleExecutor simulationBattleExecutor;

    @Autowired
    private ExperienceService experienceService;

    @Autowired
    private PersonFactory personFactory;
    @Autowired
    private FighterFactory fighterFactory;

    @Autowired
    private GameInformationService gameInformationServiceMock;

    void battle() throws IOException, URISyntaxException {
        List<BattleFighterDto> list = loadListFromFile("fighter.json", new TypeReference<>() {
        });
        List<BattleFighterDto> winners = list;

        while (winners.size() != 4) {
            list = winners;
            winners = new ArrayList<>();
            executeBattles(list, winners);
        }
        System.out.println(winners.size());

        winners.forEach(w -> {
            int currentExperience = w.getExperience().getCurrentExperience();
            w.getExperience().setCurrentExperience(currentExperience + 200);
            w.setClassEnum(ClassEnum.APPRENTICE);
            experienceService.explore(w);
        });

        writeData(winners, "winners.json");
    }

    @Test
    void apprenticeExam() throws IOException, URISyntaxException {
        List<BattleFighterDto> apprentices = create(5000);

        Map<Long, Integer> score = new HashMap<>();

        for (int i = 0; i < 200; i++) {
            Collections.shuffle(Arrays.asList(apprentices));
            round(apprentices, score);
        }

        List<BattleFighterDto> thirdClass = score.entrySet()
                .stream()
                .sorted((o1, o2) -> o2.getValue().compareTo(o1.getValue()))
                .limit(512)
                .map(Map.Entry::getKey)
                .map(id -> apprentices.stream().filter(a -> a.getId() == id).findFirst().orElseThrow(() -> new RuntimeException("")))
                .collect(Collectors.toList());

        thirdClass.forEach(w -> {
            int currentExperience = w.getExperience().getCurrentExperience();
            w.getExperience().setCurrentExperience(currentExperience + 200);
            w.setClassEnum(ClassEnum.APPRENTICE);
            experienceService.explore(w);
        });
        writeData(thirdClass, "apprentice.json");
    }

    @Test
    void thirdClassExam() throws IOException, URISyntaxException {
        List<BattleFighterDto> apprentices = loadListFromFile("fighters.json", new TypeReference<>() {
        });

        Map<Long, Integer> score = new HashMap<>();

        for (int i = 0; i < 20; i++) {
            Collections.shuffle(apprentices);
            round(apprentices, score);
        }

        List<BattleFighterDto> thirdClass = score.entrySet()
                .stream()
                .sorted((o1, o2) -> o2.getValue().compareTo(o1.getValue()))
                .limit(512)
                .map(Map.Entry::getKey)
                .map(id -> apprentices.stream().filter(a -> a.getId() == id).findFirst().orElseThrow(() -> new RuntimeException("")))
                .collect(Collectors.toList());

        thirdClass.forEach(w -> {
            int currentExperience = w.getExperience().getCurrentExperience();
            w.getExperience().setCurrentExperience(currentExperience + 500);
            w.setClassEnum(ClassEnum.THIRD_CLASS);
            experienceService.explore(w);
        });
        writeData(thirdClass, "winners.json");
    }

    @Test
    void extreme() throws IOException, URISyntaxException {
        List<BattleFighterDto> list = loadListFromFile("thirdClass.json", new TypeReference<>() {
        });
        Map<Integer, Integer> vitalityMap = new HashMap<>();
        Map<Integer, Integer> strengthMap = new HashMap<>();
        Map<Integer, Integer> dodgeMap = new HashMap<>();
        Map<Integer, Integer> dexterityMap = new HashMap<>();
        Map<Integer, Integer> defenseMap = new HashMap<>();
        Map<Integer, Integer> speedMap = new HashMap<>();
        list.stream()
                .map(BattleFighterDto::getCharacteristics)
                .forEach(c -> {
                    aggregate(vitalityMap, c.getVitality());
                    aggregate(strengthMap, c.getStrength());
                    aggregate(dodgeMap, c.getDodge());
                    aggregate(dexterityMap, c.getDexterity());
                    aggregate(defenseMap, c.getDefense());
                    aggregate(speedMap, c.getSpeed());
                });

        print("vitalityMap", vitalityMap);
        print("strengthMap", strengthMap);
        print("dodgeMap", dodgeMap);
        print("dexterityMap", dexterityMap);
        print("defenseMap", defenseMap);
        print("speedMap", speedMap);
    }

    @Test
    void reassignIds() throws IOException, URISyntaxException {
        List<BattleFighterDto> list = loadListFromFile("fighters.json", new TypeReference<>() {
        });

        AtomicInteger atomicInteger = new AtomicInteger(1);

        list.stream()
                .forEach(c -> {
                    c.setId(atomicInteger.getAndIncrement());
                });
        writeData(list, "apprentices.json");

    }

    private void print(String mapName, Map<Integer, Integer> map) {
        System.out.println("");
        System.out.println("");
        System.out.println("-----------------------------------------------------");
        System.out.println(mapName);
        map.forEach((key, value) -> System.out.println(key + ": " + value));
        System.out.println("-----------------------------------------------------");
    }

    private void aggregate(Map<Integer, Integer> vitalityMap, Integer value) {
        vitalityMap.computeIfPresent(value, (k, v) -> v + 1);
        vitalityMap.putIfAbsent(value, 1);
    }

    private List<BattleFighterDto> battleFull() {
        List<BattleFighterDto> list = create(4096);
        List<BattleFighterDto> winners = list;

        while (winners.size() != 2) {
            list = winners;
            winners = new ArrayList<>();
            executeBattles(list, winners);
        }

        winners.forEach(w -> {
            int currentExperience = w.getExperience().getCurrentExperience();
            w.getExperience().setCurrentExperience(currentExperience + 200);
            w.setClassEnum(ClassEnum.APPRENTICE);
            experienceService.explore(w);
        });
        return winners;
    }

    private void round(List<BattleFighterDto> list, Map<Long, Integer> score) {
        for (int i = 0; i < list.size(); i += 2) {
            BattleFighterDto battleFighterDto = list.get(i);
            refresh(battleFighterDto);
            BattleFighterDto battleFighterDto2 = list.get(i + 1);
            refresh(battleFighterDto2);

            var battleDto = createBattleDto(battleFighterDto, battleFighterDto2);
            BattleDto res = simulationBattleExecutor.execute(battleDto);
            var winner = res.getSummary().getWinners().get(0);
            refresh(battleFighterDto);
            refresh(battleFighterDto2);
            score.putIfAbsent(winner.getId(), 0);
            score.computeIfPresent(winner.getId(), (k, v) -> v + 1);
        }
    }

    List<BattleFighterDto> create(int size) {
        var destinyDate = createDestinyDate();
        given(gameInformationServiceMock.getCurrentDate(GAME_ID)).willReturn(destinyDate);
        List<BattleFighterDto> fighters = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            var personDto = personFactory.create(RaceEnum.HUMAN, 1L);
            var fighter = fighterFactory.create(personDto, 1L);
            fighters.add(fighter);
        }

        return fighters;
    }

    private void executeBattles(List<BattleFighterDto> list, List<BattleFighterDto> winners) {
        for (int i = 0; i < list.size(); i += 2) {
            BattleFighterDto battleFighterDto = list.get(i);
            refresh(battleFighterDto);
            BattleFighterDto battleFighterDto2 = list.get(i + 1);
            refresh(battleFighterDto2);

            var battleDto = createBattleDto(battleFighterDto, battleFighterDto2);
            BattleDto res = simulationBattleExecutor.execute(battleDto);
            var winner = res.getSummary().getWinners().get(0);
            refresh(winner);
            winners.add(winner);
            refresh(battleFighterDto2);
        }
    }

    private void refresh(BattleFighterDto battleFighterDto) {
        CharacteristicsDto characteristics = battleFighterDto.getCharacteristics();
        int speed = characteristics.getSpeed();
        int vitality = characteristics.getVitality();
        int resistance = characteristics.getResistance();
        BattleInformation battleInformation = battleFighterDto.getBattleInformation();
        battleInformation.setSpeed(speed);
        battleInformation.setResistance(resistance);
        battleInformation.setVitality(vitality);
    }

    private BattleDto createBattleDto(BattleFighterDto battleFighterDto,
                                      BattleFighterDto battleFighterDto2) {
        return BattleBuilder.initWith(BattleType.DUEL_SINGLE_CELL)
                .addFighters(battleFighterDto, battleFighterDto2)
                .build();
    }

    private DestinyDate createDestinyDate() {
        var destinyDate = new DestinyDate();
        destinyDate.setDay(1);
        destinyDate.setMonth(1);
        destinyDate.setYear(1);
        return destinyDate;
    }
}
