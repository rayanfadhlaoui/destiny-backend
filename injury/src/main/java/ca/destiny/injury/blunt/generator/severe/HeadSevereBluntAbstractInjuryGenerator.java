package ca.destiny.injury.blunt.generator.severe;

import ca.destiny.fighter.bodypart.BodyPartDto;
import ca.destiny.injury.blunt.generator.AbstractHeadBluntInjuryGenerator;
import ca.destiny.injury.injury.blunt.type.BluntArmOrLegInjuryType;

public class HeadSevereBluntAbstractInjuryGenerator extends AbstractHeadBluntInjuryGenerator {

    public HeadSevereBluntAbstractInjuryGenerator(BodyPartDto bodyPart) {
        super(bodyPart);
    }

    @Override
    protected int getProbability(BluntArmOrLegInjuryType bluntInjuryType) {
        return 0;
    }

    @Override
    protected int getPenalty() {
        return 0;
    }
}
