package ca.destiny.battle.visitor.action;

import ca.destiny.battle.action.Action;
import ca.destiny.battle.action.AttackAction;
import ca.destiny.battle.action.HitService;
import ca.destiny.battle.model.DuelSingleCellBattleDto;
import ca.destiny.battle.visitor.BattleVisitor;
import ca.destiny.injury.InjuryService;
import ca.destiny.other.RandomNumberGeneratorService;

public class ActionBattleVisitor implements BattleVisitor {

    private final RandomNumberGeneratorService randomNumberGeneratorService;
    private final InjuryService injuryService;
    private final HitService hitService;
    private Action action;

    public ActionBattleVisitor(RandomNumberGeneratorService randomNumberGeneratorService,
                               InjuryService injuryService) {
        this.randomNumberGeneratorService = randomNumberGeneratorService;
        this.injuryService = injuryService;
        this.hitService = new HitService();
    }

    public Action getAction() {
        return action;
    }

    @Override
    public void visit(DuelSingleCellBattleDto duelSingleCellBattleDto) {
        int dexterity = duelSingleCellBattleDto.getActiveFighter().getBattleInformation().getDexterity();
        int dodge = duelSingleCellBattleDto.getInactiveFighter().getBattleInformation().getDodge();
        if (hitService.hitPercentage(dexterity, dodge) <= 350 && randomNumberGeneratorService.getRandomNumberInts(0, 1) == 1) {
            action = new AccurateAttackAction(randomNumberGeneratorService, injuryService, duelSingleCellBattleDto.getActiveFighter(), duelSingleCellBattleDto.getInactiveFighter());
        } else {
            action = new NormalAttackAction(randomNumberGeneratorService, injuryService, duelSingleCellBattleDto.getActiveFighter(), duelSingleCellBattleDto.getInactiveFighter());
        }
    }
}
