package ca.destiny.fighter.injury;

public class SevereFractureInjury implements Injury {
    @Override
    public String getName() {
        return "Severe fracture";
    }

    @Override
    public int getPain() {
        return 20;
    }
}
