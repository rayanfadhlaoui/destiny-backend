package ca.destiny.injury.injury.blunt;

import ca.destiny.fighter.bodypart.Injury;

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
