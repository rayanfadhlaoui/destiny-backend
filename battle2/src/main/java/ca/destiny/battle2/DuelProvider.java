package ca.destiny.battle2;

import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class DuelProvider {

    public Optional<Duel> get(SquadFighter squadFighter, SquadBattle squadBattle) {
        Optional<SquadFighter> optionalOpponent = findOptionalOpponent(squadFighter.getPosition(), squadFighter.getTeamNumber(), squadBattle);

        return optionalOpponent.map(SquadFighter::getFighter)
                .map(f -> new Duel(squadFighter.getFighter(), f));
    }

    private Optional<SquadFighter> findOptionalOpponent(Position position, int teamNumber, SquadBattle squadBattle) {
        List<Position> surroundingPositions = position.getSurrounding();
        return surroundingPositions.stream()
                .map(squadBattle::getSquadFighterForPosition)
                .filter(Optional::isPresent)
                .map(Optional::get)
                .filter(f -> f.getTeamNumber() != teamNumber)
                .findFirst();
    }
}
