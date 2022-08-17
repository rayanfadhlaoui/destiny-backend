package ca.destiny.injury.blunt.generator.head;

import ca.destiny.fighter.bodypart.BodyPartDto;
import ca.destiny.fighter.injury.type.BluntHeadInjuryType;
import ca.destiny.injury.blunt.generator.AbstractHeadBluntInjuryGenerator;

public class HeadSeriousBluntInjuryGenerator extends AbstractHeadBluntInjuryGenerator {

    public HeadSeriousBluntInjuryGenerator(BodyPartDto bodyPart) {
        super(bodyPart);
    }

    @Override
    protected int getProbability(BluntHeadInjuryType bluntInjuryType) {
        switch (bluntInjuryType) {
            case SUPERFICIAL_BRUISE:
                return 5;
            case MINOR_BRUISE:
                return 25;
            case SEVERE_BRUISE:
                return 50;
            case MINOR_FRACTURE:
                return 75;
            case SEVERE_FRACTURE:
                return 109;
        }
        return 150;
    }

    @Override
    protected int getPenalty() {
        return 30;
    }
}
