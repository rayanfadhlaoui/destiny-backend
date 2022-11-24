package ca.destiny.battle2;

import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class SquadBattleExecutor {

    private final InitiativeService initiativeService;
    private final SquadFighterActionProvider squadFighterActionProvider;

    public SquadBattleExecutor(InitiativeService initiativeService, SquadFighterActionProvider squadFighterActionProvider) {
        this.initiativeService = initiativeService;
        this.squadFighterActionProvider = squadFighterActionProvider;
    }

    public void execute(SquadBattle squadBattle) {
        List<SquadFighter> fighters = getSortedFighters(squadBattle);
        for (SquadFighter fighter : fighters) {
            execute(fighter, squadBattle);
        }
    }

    private List<SquadFighter> getSortedFighters(SquadBattle squadBattle) {
        return squadBattle.getSquadFighters()
                .stream()
                .sorted((o1, o2) -> initiativeService.compare(getInitiative(o1), getInitiative(o2)))
                .collect(Collectors.toList());
    }

    private static int getInitiative(SquadFighter squadFighter) {
        return squadFighter.getFighter().getCharacteristics().getInitiative();
    }

    private void execute(SquadFighter fighter, SquadBattle squadBattle) {
        Action action = squadFighterActionProvider.getAction(fighter, squadBattle);
        action.execute();
    }
}
