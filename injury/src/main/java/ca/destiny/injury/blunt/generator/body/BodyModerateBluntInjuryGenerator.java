package ca.destiny.injury.blunt.generator.body;

import ca.destiny.fighter.bodypart.BodyPartDto;
import ca.destiny.injury.blunt.generator.AbstractBodyBluntInjuryGenerator;
import ca.destiny.injury.injury.blunt.type.BluntBodyInjuryType;

public class BodyModerateBluntInjuryGenerator extends AbstractBodyBluntInjuryGenerator {

    public BodyModerateBluntInjuryGenerator(BodyPartDto bodyPart) {
        super(bodyPart);
    }

    @Override
    protected int getProbability(BluntBodyInjuryType bluntInjuryType) {
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
        return 10;
    }
}
