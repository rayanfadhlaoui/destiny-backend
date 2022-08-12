package ca.destiny.injury.injury.blunt;

import ca.destiny.fighter.bodypart.Injury;

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
