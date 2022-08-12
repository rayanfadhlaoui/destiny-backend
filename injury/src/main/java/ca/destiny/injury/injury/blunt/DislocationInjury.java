package ca.destiny.injury.injury.blunt;

import ca.destiny.fighter.bodypart.Injury;

public class DislocationInjury implements Injury {
    @Override
    public String getName() {
        return "Dislocation";
    }

    @Override
    public int getPain() {
        return 21;
    }
}
