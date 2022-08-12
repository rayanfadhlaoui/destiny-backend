package ca.destiny.injury.blunt.generator.superficial;

import ca.destiny.fighter.bodypart.BodyPartDto;
import ca.destiny.injury.blunt.generator.AbstractBodyBluntInjuryGenerator;
import ca.destiny.injury.injury.blunt.type.BluntBodyInjuryType;

public class BodySuperficialBluntInjuryGenerator extends AbstractBodyBluntInjuryGenerator {

    public BodySuperficialBluntInjuryGenerator(BodyPartDto bodyPart) {
        super(bodyPart);
    }

    @Override
    protected int getProbability(BluntBodyInjuryType bluntInjuryType) {
        return 0;
    }

    @Override
    protected int getPenalty() {
        return 0;
    }
}
