package ca.destiny.injury.blunt.generator.legorarm;

import ca.destiny.fighter.bodypart.BodyPartDto;
import ca.destiny.injury.blunt.generator.AbstractLegOrArmsBluntInjuryGenerator;
import ca.destiny.injury.injury.blunt.type.BluntArmOrLegInjuryType;

public class LegOrArmMinorBluntInjuryGenerator extends AbstractLegOrArmsBluntInjuryGenerator {

    public LegOrArmMinorBluntInjuryGenerator(BodyPartDto bodyPart) {
        super(bodyPart);
    }

    @Override
    protected int getPenalty() {
        return 3;
    }

    @Override
    protected int getProbability(BluntArmOrLegInjuryType bluntInjuryType) {
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
            case DISLOCATION:
                return 150;
        }
        return 150;
    }
}
