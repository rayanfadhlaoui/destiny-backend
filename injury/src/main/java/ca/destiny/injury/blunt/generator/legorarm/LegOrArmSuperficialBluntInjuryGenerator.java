package ca.destiny.injury.blunt.generator.legorarm;

import ca.destiny.fighter.bodypart.BodyPartDto;
import ca.destiny.fighter.injury.type.BluntArmOrLegInjuryType;
import ca.destiny.injury.blunt.generator.AbstractLegOrArmsBluntInjuryGenerator;

public class LegOrArmSuperficialBluntInjuryGenerator extends AbstractLegOrArmsBluntInjuryGenerator {

    public LegOrArmSuperficialBluntInjuryGenerator(BodyPartDto bodyPart) {
        super(bodyPart);
    }

    @Override
    protected int getPenalty() {
        return 1;
    }

    @Override
    protected int getProbability(BluntArmOrLegInjuryType bluntInjuryType) {
        switch (bluntInjuryType) {
            case SUPERFICIAL_BRUISE:
                return 75;
            case MINOR_BRUISE:
                return 100;
            case SEVERE_BRUISE:
            case MINOR_FRACTURE:
            case SEVERE_FRACTURE:
            case DISLOCATION:
                return 150;
        }
        return 150;
    }
}
