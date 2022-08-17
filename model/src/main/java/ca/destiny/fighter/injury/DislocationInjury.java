package ca.destiny.fighter.injury;

public class DislocationInjury implements Injury {
    @Override
    public String getName() {
        return "Dislocation";
    }

    @Override
    public int getPain() {
        return 21;
    }
}
