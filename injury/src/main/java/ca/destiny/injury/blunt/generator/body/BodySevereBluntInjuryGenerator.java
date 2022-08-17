package ca.destiny.injury.blunt.generator.body;

import ca.destiny.fighter.bodypart.BodyPartDto;
import ca.destiny.fighter.injury.type.BluntBodyInjuryType;
import ca.destiny.injury.blunt.generator.AbstractBodyBluntInjuryGenerator;

public class BodySevereBluntInjuryGenerator extends AbstractBodyBluntInjuryGenerator {
    public BodySevereBluntInjuryGenerator(BodyPartDto bodyPart) {
        super(bodyPart);
    }

    @Override
    protected int getProbability(BluntBodyInjuryType bluntInjuryType) {
        switch (bluntInjuryType) {
            case SUPERFICIAL_BRUISE:
                return 1;
            case MINOR_BRUISE:
                return 5;
            case SEVERE_BRUISE:
                return 25;
            case MINOR_FRACTURE:
                return 50;
            case SEVERE_FRACTURE:
                return 75;
        }
        return 81;
    }

    @Override
    protected int getPenalty() {
        return 40;
    }
}
