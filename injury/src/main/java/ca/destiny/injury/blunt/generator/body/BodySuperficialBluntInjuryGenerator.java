package ca.destiny.injury.blunt.generator.body;

import ca.destiny.fighter.bodypart.BodyPartDto;
import ca.destiny.fighter.injury.type.BluntBodyInjuryType;
import ca.destiny.injury.blunt.generator.AbstractBodyBluntInjuryGenerator;

public class BodySuperficialBluntInjuryGenerator extends AbstractBodyBluntInjuryGenerator {

    public BodySuperficialBluntInjuryGenerator(BodyPartDto bodyPart) {
        super(bodyPart);
    }


    @Override
    protected int getPenalty() {
        return 2;
    }

    @Override
    protected int getProbability(BluntBodyInjuryType bluntInjuryType) {
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

}
