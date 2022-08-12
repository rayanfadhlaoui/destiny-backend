package ca.destiny.injury.blunt.generator.minor;

import ca.destiny.fighter.bodypart.BodyPartDto;
import ca.destiny.injury.blunt.generator.AbstractBodyBluntInjuryGenerator;
import ca.destiny.injury.injury.blunt.type.BluntBodyInjuryType;

public class BodyMinorBluntAbstractInjuryGenerator extends AbstractBodyBluntInjuryGenerator {
    public BodyMinorBluntAbstractInjuryGenerator(BodyPartDto bodyPart) {
        super(bodyPart);
    }

    @Override
    protected int getProbability(BluntBodyInjuryType bluntInjuryType) {
        return 0;
    }

    @Override
    public void inflict(boolean knockout) {

    }

    @Override
    protected int getPenalty() {
        return 0;
    }
}
