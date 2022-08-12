package ca.destiny.injury.blunt.generator.superficial;

import ca.destiny.fighter.bodypart.BodyPartDto;
import ca.destiny.injury.blunt.generator.AbstractHeadBluntInjuryGenerator;
import ca.destiny.injury.injury.blunt.type.BluntArmOrLegInjuryType;

public class HeadSuperficialBluntInjuryGenerator extends AbstractHeadBluntInjuryGenerator {

    public HeadSuperficialBluntInjuryGenerator(BodyPartDto bodyPart) {
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
