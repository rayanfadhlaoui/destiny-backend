package ca.destiny.injury.blunt.generator.body;

import ca.destiny.fighter.bodypart.BodyPartDto;
import ca.destiny.injury.blunt.generator.AbstractBodyBluntInjuryGenerator;
import ca.destiny.injury.injury.blunt.type.BluntBodyInjuryType;

public class BodySeriousBluntInjuryGenerator extends AbstractBodyBluntInjuryGenerator {
    public BodySeriousBluntInjuryGenerator(BodyPartDto bodyPart) {
        super(bodyPart);
    }

    @Override
    protected int getPenalty() {
        return 20;
    }

    @Override
    protected int getProbability(BluntBodyInjuryType bluntInjuryType) {
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


}
