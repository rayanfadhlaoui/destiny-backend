package ca.destiny.injury.blunt.generator.head;

import ca.destiny.fighter.bodypart.BodyPartDto;
import ca.destiny.injury.blunt.generator.AbstractHeadBluntInjuryGenerator;
import ca.destiny.injury.injury.blunt.type.BluntHeadInjuryType;

public class HeadSevereBluntInjuryGenerator extends AbstractHeadBluntInjuryGenerator {

    public HeadSevereBluntInjuryGenerator(BodyPartDto bodyPart) {
        super(bodyPart);
    }

    @Override
    protected int getProbability(BluntHeadInjuryType bluntInjuryType) {
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
        return 50;
    }
}
