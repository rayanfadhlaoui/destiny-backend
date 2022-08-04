package ca.destiny.battle.simulation;

import ca.destiny.battle.model.BattleDto;
import ca.destiny.battle.model.DuelSingleCellBattleDto;
import ca.destiny.battle.model.Summary;
import ca.destiny.fighter.BattleFighterDto;
import ca.destiny.fighter.BattleInformation;
import ca.destiny.other.RandomNumberGeneratorService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.assertj.core.api.Java6Assertions.assertThat;
import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
class SimulationBattleExecutorTest {

    @InjectMocks
    private SimulationBattleExecutor simulationBattleExecutor;

    @Mock
    private RandomNumberGeneratorService randomNumberGeneratorService;

    @Test
    public void oneRoundBattle() {
        BattleFighterDto battleFighterDto = createFighterDto(1);
        DuelSingleCellBattleDto battle = createBattle(battleFighterDto);
        given(randomNumberGeneratorService.getRandomNumberInts(0, 100)).willReturn(100);
        BattleDto actual = simulationBattleExecutor.execute(battle);

        Summary summary = actual.getSummary();
        assertThat(summary.isOver()).isTrue();
        List<BattleFighterDto> winners = summary.getWinners();
        assertThat(winners).isNotEmpty();
        assertThat(winners.get(0)).isEqualTo(battleFighterDto);
    }

    private DuelSingleCellBattleDto createBattle(BattleFighterDto battleFighterDto) {
        DuelSingleCellBattleDto duelSingleCellBattleDto = new DuelSingleCellBattleDto();
        duelSingleCellBattleDto.setActiveFighter(battleFighterDto);
        duelSingleCellBattleDto.setInactiveFighter(createFighterDto(2));
        return duelSingleCellBattleDto;
    }

    private BattleFighterDto createFighterDto(int id) {
        BattleFighterDto battleFighterDto = new BattleFighterDto();
        BattleInformation battleInformation = createBattleInformation();
        battleFighterDto.setBattleInformation(battleInformation);
        battleFighterDto.setId(id);
        return battleFighterDto;
    }

    private BattleInformation createBattleInformation() {
        BattleInformation battleInformation = new BattleInformation();
        battleInformation.setDexterity(200);
        battleInformation.setDodge(1);
        battleInformation.setMinimumDamage(100);
        battleInformation.setMaximumDamage(100);
        battleInformation.setVitality(1);
        battleInformation.setDefense(1);
        return battleInformation;
    }
}