package ca.destiny.fighter.injury;

public class SevereBruiseInjury implements Injury {
    @Override
    public String getName() {
        return "Severe bruise";
    }

    @Override
    public int getPain() {
        return 4;
    }
}
