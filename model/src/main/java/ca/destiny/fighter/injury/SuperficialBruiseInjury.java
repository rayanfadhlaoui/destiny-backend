package ca.destiny.fighter.injury;

public class SuperficialBruiseInjury implements Injury {

    @Override
    public String getName() {
        return "Superficial Bruise";
    }

    @Override
    public int getPain() {
        return 1;
    }
}
