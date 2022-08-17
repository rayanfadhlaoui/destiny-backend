package ca.destiny.fighter.injury;

public class BrokenBoneInjury implements Injury {
    @Override
    public String getName() {
        return "Broken";
    }

    @Override
    public int getPain() {
        return 50;
    }
}
