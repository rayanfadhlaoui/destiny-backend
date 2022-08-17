package ca.destiny.fighter.injury;

public class MinorFractureInjury implements Injury {
    @Override
    public String getName() {
        return "Minor fracture";
    }

    @Override
    public int getPain() {
        return 10;
    }
}
