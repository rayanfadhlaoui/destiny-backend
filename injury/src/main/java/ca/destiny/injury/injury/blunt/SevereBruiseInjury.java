package ca.destiny.injury.injury.blunt;

import ca.destiny.fighter.bodypart.Injury;

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
