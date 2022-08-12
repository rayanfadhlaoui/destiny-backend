package ca.destiny.injury.blunt.generator.serious;

import ca.destiny.fighter.bodypart.BodyPartDto;
import ca.destiny.injury.blunt.generator.AbstractHeadBluntInjuryGenerator;
import ca.destiny.injury.injury.blunt.type.BluntArmOrLegInjuryType;

public class HeadSeriousBluntAbstractInjuryGenerator extends AbstractHeadBluntInjuryGenerator {

    public HeadSeriousBluntAbstractInjuryGenerator(BodyPartDto bodyPart) {
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
