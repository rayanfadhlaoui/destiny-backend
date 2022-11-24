package ca.destiny.battle2;

public class MoveAction implements Action {
    private final SquadFighter fighter;
    private final Position newPosition;
    private final SquadBattle squadBattle;

    public MoveAction(SquadFighter fighter, Position newPosition, SquadBattle squadBattle) {
        this.fighter = fighter;
        this.newPosition = newPosition;
        this.squadBattle = squadBattle;
    }

    @Override
    public void execute() {
        Position previousPosition = fighter.getPosition();
        fighter.setPosition(newPosition);
        squadBattle.moveFighter(previousPosition, fighter);
    }
}
