package ca.destiny.fighter.injury;

public class MinorBruiseInjury implements Injury {
    @Override
    public String getName() {
        return "Minor bruise";
    }

    @Override
    public int getPain() {
        return 2;
    }
}
