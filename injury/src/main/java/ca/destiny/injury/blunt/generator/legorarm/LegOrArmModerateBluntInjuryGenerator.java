package ca.destiny.injury.blunt.generator.legorarm;

import ca.destiny.fighter.bodypart.BodyPartDto;
import ca.destiny.fighter.injury.type.BluntArmOrLegInjuryType;
import ca.destiny.injury.blunt.generator.AbstractLegOrArmsBluntInjuryGenerator;

public class LegOrArmModerateBluntInjuryGenerator extends AbstractLegOrArmsBluntInjuryGenerator {

    public LegOrArmModerateBluntInjuryGenerator(BodyPartDto bodyPart) {
        super(bodyPart);
    }

    @Override
    protected int getPenalty() {
        return 5;
    }

    @Override
    protected int getProbability(BluntArmOrLegInjuryType bluntInjuryType) {
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
            case DISLOCATION:
                return 150;
        }
        return 150;
    }


}
