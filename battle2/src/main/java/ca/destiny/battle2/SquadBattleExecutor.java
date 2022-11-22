package ca.destiny.battle2;

import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class SquadBattleExecutor {

    private final InitiativeService initiativeService;

    public SquadBattleExecutor(InitiativeService initiativeService) {
        this.initiativeService = initiativeService;
    }

    public void execute(SquadBattle squadBattle) {
        List<SquadFighter> fighters = getSortedFighters(squadBattle);
        executeLocal(fighters);
    }

    private List<SquadFighter> getSortedFighters(SquadBattle squadBattle) {
        return squadBattle.getSquadFighters()
                .stream()
                .sorted((o1, o2) -> initiativeService.compare(o1.getFighter(), o2.getFighter()))
                .collect(Collectors.toList());
    }

    private void executeLocal(List<SquadFighter> fighters) {

    }
}
