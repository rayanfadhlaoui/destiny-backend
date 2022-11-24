package ca.destiny.battle2;

import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class SquadFighterActionProvider {

    private final DuelProvider duelProvider;
    private final MovementProvider movementProvider;
    private final DuelExecutor duelExecutor;

    public SquadFighterActionProvider(DuelProvider duelProvider,
                                      MovementProvider movementProvider,
                                      DuelExecutor duelExecutor) {
        this.duelProvider = duelProvider;
        this.movementProvider = movementProvider;
        this.duelExecutor = duelExecutor;
    }

    public Action getAction(SquadFighter fighter, SquadBattle squadBattle) {
        Action action;
        Optional<Duel> optionalDuel = duelProvider.get(fighter, squadBattle);
        if (optionalDuel.isPresent()) {
            action = new DuelAction(duelExecutor, optionalDuel.get());
        } else {
            Position newPosition = movementProvider.getNextPosition(fighter, squadBattle);
            action = new MoveAction(fighter, newPosition, squadBattle);
        }
        return action;
    }
}
