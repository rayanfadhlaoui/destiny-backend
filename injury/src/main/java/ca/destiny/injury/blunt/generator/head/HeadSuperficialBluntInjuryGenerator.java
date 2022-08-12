package ca.destiny.injury.blunt.generator.head;

import ca.destiny.fighter.bodypart.BodyPartDto;
import ca.destiny.injury.blunt.generator.AbstractHeadBluntInjuryGenerator;
import ca.destiny.injury.injury.blunt.type.BluntHeadInjuryType;

public class HeadSuperficialBluntInjuryGenerator extends AbstractHeadBluntInjuryGenerator {

    public HeadSuperficialBluntInjuryGenerator(BodyPartDto bodyPart) {
        super(bodyPart);
    }

    @Override
    protected int getProbability(BluntHeadInjuryType bluntInjuryType) {
        switch (bluntInjuryType) {
            case SUPERFICIAL_BRUISE:
                return 75;
            case MINOR_BRUISE:
                return 100;
            case SEVERE_BRUISE:
            case MINOR_FRACTURE:
            case SEVERE_FRACTURE:
                return 150;
        }
        return 150;
    }


    @Override
    protected int getPenalty() {
        return 4;
    }
}
