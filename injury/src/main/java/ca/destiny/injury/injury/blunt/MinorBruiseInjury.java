package ca.destiny.injury.injury.blunt;

import ca.destiny.fighter.bodypart.Injury;

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
