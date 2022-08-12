package ca.destiny.injury.injury.blunt;

import ca.destiny.fighter.bodypart.Injury;

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
