package ca.destiny.injury.blunt.generator.head;

import ca.destiny.fighter.bodypart.BodyPartDto;
import ca.destiny.injury.blunt.generator.AbstractHeadBluntInjuryGenerator;
import ca.destiny.injury.injury.blunt.type.BluntArmOrLegInjuryType;
import ca.destiny.injury.injury.blunt.type.BluntHeadInjuryType;

public class HeadModerateBluntInjuryGenerator extends AbstractHeadBluntInjuryGenerator {

    public HeadModerateBluntInjuryGenerator(BodyPartDto bodyPart) {
        super(bodyPart);
    }

    @Override
    protected int getProbability(BluntHeadInjuryType bluntInjuryType) {
        switch (bluntInjuryType) {
            case SUPERFICIAL_BRUISE:
                return 20;
            case MINOR_BRUISE:
                return 45;
            case SEVERE_BRUISE:
                return 95;
            case MINOR_FRACTURE:
                return 104;
            case SEVERE_FRACTURE:
                return 150;
        }
        return 150;
    }

    @Override
    protected int getPenalty() {
        return 20;
    }
}
