package ca.destiny.battle.duel;

import ca.destiny.battle.BattleExecutor;
import ca.destiny.battle.action.Action;
import ca.destiny.battle.model.BattleDto;
import ca.destiny.battle.simulation.StatusBattleVisitor;
import ca.destiny.battle.visitor.BattleVisitor;
import ca.destiny.battle.visitor.action.ActionBattleVisitor;
import ca.destiny.evolution.levelup.ExperienceService;
import ca.destiny.injury.InjuryService;
import ca.destiny.other.RandomNumberGeneratorService;
import org.springframework.stereotype.Component;

@Component
public class TurnBasedBattleExecutor extends BattleExecutor {

    private final RandomNumberGeneratorService randomNumberGeneratorService;
    private final InjuryService injuryService;

    public TurnBasedBattleExecutor(ExperienceService experienceService,
                                   RandomNumberGeneratorService randomNumberGeneratorService,
                                   InjuryService injuryService) {
        super(experienceService);
        this.randomNumberGeneratorService = randomNumberGeneratorService;
        this.injuryService = injuryService;
    }

    @Override
    public BattleDto customExecute(BattleDto battleDto) {
        int nbTurn = 0;
        boolean isOver = isFightOver(battleDto);
        while (!isOver && nbTurn != 2) {
            executeAction(battleDto);
            isOver = isFightOver(battleDto);
            battleDto.incrementTurn();
            nbTurn++;
        }
        return battleDto;
    }

    private void executeAction(BattleDto battleDto) {
        Action action = getAction(battleDto);
        if (action.execute()) {
            executeAction(battleDto);
        }
    }

    private boolean isFightOver(BattleDto battleDto) {
        BattleVisitor actionBattleVisitor = new StatusBattleVisitor();
        battleDto.visit(actionBattleVisitor);
        return battleDto.getSummary().isOver();
    }

    private Action getAction(BattleDto battleDto) {
        ActionBattleVisitor actionBattleVisitor = new ActionBattleVisitor(randomNumberGeneratorService, injuryService);
        battleDto.visit(actionBattleVisitor);
        return actionBattleVisitor.getAction();
    }
}
