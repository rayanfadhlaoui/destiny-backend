package ca.destiny.injury.blunt.generator.legorarm;

import ca.destiny.fighter.bodypart.BodyPartDto;
import ca.destiny.injury.blunt.generator.AbstractLegOrArmsBluntInjuryGenerator;
import ca.destiny.injury.injury.blunt.type.BluntArmOrLegInjuryType;

public class LegOrArmSevereBluntInjuryGenerator extends AbstractLegOrArmsBluntInjuryGenerator {
    public LegOrArmSevereBluntInjuryGenerator(BodyPartDto bodyPart) {
        super(bodyPart);
    }

    @Override
    protected int getProbability(BluntArmOrLegInjuryType bluntInjuryType) {
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
            case DISLOCATION:
                return 80;
        }
        return 81;
    }

    @Override
    protected int getPenalty() {
        return 20;
    }
}
