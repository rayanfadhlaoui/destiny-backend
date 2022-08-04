package ca.destiny.battle.integration;

import ca.destiny.ApplicationTest;
import ca.destiny.battle.factory.BattleBuilder;
import ca.destiny.battle.factory.BattleType;
import ca.destiny.battle.model.BattleDto;
import ca.destiny.battle.simulation.SimulationBattleExecutor;
import ca.destiny.fighter.BattleFighterDto;
import ca.destiny.fighter.BattleInformation;
import ca.destiny.fighter.CharacteristicsDto;
import com.fasterxml.jackson.core.type.TypeReference;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import ca.destiny.destinytest.AbstractIntegrationTest;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

@ExtendWith(SpringExtension.class)
@Import(BattleConfiguration.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK, classes = ApplicationTest.class)
public class Battle extends AbstractIntegrationTest {

    public static final long GAME_ID = 1L;
    @Autowired
    private SimulationBattleExecutor simulationBattleExecutor;

    @Test
    @Disabled
    void createBig100() throws IOException, URISyntaxException {
        List<BattleFighterDto> list = loadListFromFile("winners.json", new TypeReference<>() {
        });
        List<BattleFighterDto> winners = new ArrayList<>();

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
        System.out.println(winners.size());
        writeData(winners, "winners.json");
    }

    @Test
    void size() throws IOException, URISyntaxException {
        List<BattleFighterDto> list = loadListFromFile("winners.json", new TypeReference<>() {
        });
        System.out.println(list.size());
    }


    private void refresh(BattleFighterDto battleFighterDto) {
        CharacteristicsDto characteristics = battleFighterDto.getCharacteristics();
        Integer speed = characteristics.getSpeed();
        Integer vitality = characteristics.getVitality();
        BattleInformation battleInformation = battleFighterDto.getBattleInformation();
        battleInformation.setSpeed(speed);
        battleFighterDto.getBattleInformation().setVitality(vitality);
    }


    private BattleDto createBattleDto(BattleFighterDto battleFighterDto,
                                      BattleFighterDto battleFighterDto2) {
        return BattleBuilder.initWith(BattleType.DUEL_SINGLE_CELL)
                .addFighters(battleFighterDto, battleFighterDto2)
                .build();
    }

}
