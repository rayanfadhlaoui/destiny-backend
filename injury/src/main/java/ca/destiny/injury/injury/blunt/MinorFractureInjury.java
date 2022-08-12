package ca.destiny.injury.injury.blunt;

import ca.destiny.fighter.bodypart.Injury;

public class MinorFractureInjury implements Injury {
    @Override
    public String getName() {
        return "Minor fracture";
    }

    @Override
    public int getPain() {
        return 10;
    }
}
