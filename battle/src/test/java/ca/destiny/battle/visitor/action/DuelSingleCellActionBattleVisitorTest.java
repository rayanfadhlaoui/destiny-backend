package ca.destiny.battle.visitor.action;

import ca.destiny.battle.action.Action;
import ca.destiny.battle.action.AttackAction;
import ca.destiny.battle.model.DuelSingleCellBattleDto;
import ca.destiny.fighter.BattleFighterDto;
import ca.destiny.injury.InjuryService;
import ca.destiny.other.RandomNumberGeneratorService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
class DuelSingleCellActionBattleVisitorTest {

    @Mock
    private RandomNumberGeneratorService randomNumberGeneratorService;
    @Mock
    private InjuryService injuryService;

    @Test
    void givenTwoFighterCac_ThenActionIsAttack() {
        BattleFighterDto activeFighter = createFighterDto(1);
        BattleFighterDto inactiveFighter = createFighterDto(2);
        DuelSingleCellBattleDto battleDto = createBattleDto(activeFighter, inactiveFighter);
        ActionBattleVisitor actionBattleVisitor = new ActionBattleVisitor(randomNumberGeneratorService, injuryService);
        battleDto.visit(actionBattleVisitor);
        Action action = actionBattleVisitor.getAction();
        assertThat(action).isInstanceOf(AttackAction.class);
        AttackAction attackAction = (AttackAction) action;
        assertThat(attackAction).isEqualToComparingFieldByFieldRecursively(new AttackAction(randomNumberGeneratorService, injuryService, activeFighter, inactiveFighter));
    }

    private BattleFighterDto createFighterDto(int id) {
        BattleFighterDto activeFighter = new BattleFighterDto();
        activeFighter.setId(id);
        return activeFighter;
    }

    private DuelSingleCellBattleDto createBattleDto(BattleFighterDto activeFighter, BattleFighterDto inactiveFighter) {
        DuelSingleCellBattleDto duelSingleCellBattleDto = new DuelSingleCellBattleDto();
        duelSingleCellBattleDto.setActiveFighter(activeFighter);
        duelSingleCellBattleDto.setInactiveFighter(inactiveFighter);
        return duelSingleCellBattleDto;
    }
}