package ca.destiny.battle.visitor.action;

import ca.destiny.battle.action.Action;
import ca.destiny.battle.action.HitService;
import ca.destiny.battle.model.DuelSingleCellBattleDto;
import ca.destiny.battle.visitor.BattleVisitor;
import ca.destiny.fighter.BattleFighterDto;
import ca.destiny.fighter.equipment.EquipmentDto;
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
        this.hitService = new HitService(randomNumberGeneratorService);
    }

    public Action getAction() {
        return action;
    }

    @Override
    public void visit(DuelSingleCellBattleDto duelSingleCellBattleDto) {
        BattleFighterDto activeFighter = duelSingleCellBattleDto.getActiveFighter();
        EquipmentDto equipmentDto = activeFighter.getEquipmentDto();
        int dexterity = activeFighter.getBattleInformation().getDexterity();
        int dodge = duelSingleCellBattleDto.getInactiveFighter().getBattleInformation().getDodge();
        if (activeFighter.getBattleInformation().getStamina() < equipmentDto.getRightWeapon().getStaminaNeeded()) {
            action = new RestAction(randomNumberGeneratorService, activeFighter);
        } else if (hitService.hitPercentage(dexterity, dodge, activeFighter.getEquipmentDto().getRightWeapon()) <= 350 && randomNumberGeneratorService.getRandomNumberInts(0, 1) == 1) {
            action = new AccurateAttackAction(randomNumberGeneratorService, injuryService, activeFighter, duelSingleCellBattleDto.getInactiveFighter());
        } else {
            action = new NormalAttackAction(randomNumberGeneratorService, injuryService, activeFighter, duelSingleCellBattleDto.getInactiveFighter());
        }
    }
}
