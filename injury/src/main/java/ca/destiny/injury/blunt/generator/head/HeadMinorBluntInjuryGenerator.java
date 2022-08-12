package ca.destiny.injury.blunt.generator.head;

import ca.destiny.fighter.bodypart.BodyPartDto;
import ca.destiny.injury.blunt.generator.AbstractHeadBluntInjuryGenerator;
import ca.destiny.injury.injury.blunt.type.BluntHeadInjuryType;

public class HeadMinorBluntInjuryGenerator extends AbstractHeadBluntInjuryGenerator {

    public HeadMinorBluntInjuryGenerator(BodyPartDto bodyPart) {
        super(bodyPart);
    }

    @Override
    protected int getProbability(BluntHeadInjuryType bluntInjuryType) {
        switch (bluntInjuryType) {
            case SUPERFICIAL_BRUISE:
                return 25;
            case MINOR_BRUISE:
                return 75;
            case SEVERE_BRUISE:
                return 100;
            case MINOR_FRACTURE:
                return 103;
            case SEVERE_FRACTURE:
                return 150;
        }
        return 150;
    }

    @Override
    protected int getPenalty() {
        return 12;
    }
}
