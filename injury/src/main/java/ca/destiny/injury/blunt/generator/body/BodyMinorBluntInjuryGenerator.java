package ca.destiny.injury.blunt.generator.body;

import ca.destiny.fighter.bodypart.BodyPartDto;
import ca.destiny.fighter.injury.type.BluntBodyInjuryType;
import ca.destiny.injury.FightStatusUpdater;
import ca.destiny.injury.blunt.generator.AbstractBodyBluntInjuryGenerator;

public class BodyMinorBluntInjuryGenerator extends AbstractBodyBluntInjuryGenerator {
    public BodyMinorBluntInjuryGenerator(BodyPartDto bodyPart) {
        super(bodyPart);
    }

    @Override
    protected int getProbability(BluntBodyInjuryType bluntInjuryType) {
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
                return 150;
        }
        return 150;
    }

    @Override
    protected int getPenalty() {
        return 6;
    }
}
