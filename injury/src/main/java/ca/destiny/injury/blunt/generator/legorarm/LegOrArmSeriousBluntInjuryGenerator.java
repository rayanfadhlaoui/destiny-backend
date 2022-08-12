package ca.destiny.injury.blunt.generator.legorarm;

import ca.destiny.fighter.bodypart.BodyPartDto;
import ca.destiny.injury.blunt.generator.AbstractLegOrArmsBluntInjuryGenerator;
import ca.destiny.injury.injury.blunt.type.BluntArmOrLegInjuryType;

public class LegOrArmSeriousBluntInjuryGenerator extends AbstractLegOrArmsBluntInjuryGenerator {
    public LegOrArmSeriousBluntInjuryGenerator(BodyPartDto bodyPart) {
        super(bodyPart);
    }

    @Override
    protected int getProbability(BluntArmOrLegInjuryType bluntInjuryType) {
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
            case DISLOCATION:
                return 150;
        }
        return 150;
    }

    @Override
    protected int getPenalty() {
        return 10;
    }
}
