package ca.destiny.battle.visitor.action;

import ca.destiny.battle.action.Action;
import ca.destiny.battle.action.AttackAction;
import ca.destiny.battle.model.DuelSingleCellBattleDto;
import ca.destiny.battle.visitor.BattleVisitor;
import ca.destiny.injury.InjuryService;
import ca.destiny.other.RandomNumberGeneratorService;

public class ActionBattleVisitor implements BattleVisitor {

    private final RandomNumberGeneratorService randomNumberGeneratorService;
    private final InjuryService injuryService;
    private Action action;

    public ActionBattleVisitor(RandomNumberGeneratorService randomNumberGeneratorService,
                               InjuryService injuryService) {
        this.randomNumberGeneratorService = randomNumberGeneratorService;
        this.injuryService = injuryService;
    }

    public Action getAction() {
        return action;
    }

    @Override
    public void visit(DuelSingleCellBattleDto duelSingleCellBattleDto) {
        action = new AttackAction(randomNumberGeneratorService, injuryService, duelSingleCellBattleDto.getActiveFighter(), duelSingleCellBattleDto.getInactiveFighter());
    }
}
