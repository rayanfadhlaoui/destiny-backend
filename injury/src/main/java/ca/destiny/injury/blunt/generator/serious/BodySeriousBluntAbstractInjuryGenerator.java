package ca.destiny.injury.blunt.generator.serious;

import ca.destiny.fighter.bodypart.BodyPartDto;
import ca.destiny.injury.blunt.generator.AbstractBodyBluntInjuryGenerator;
import ca.destiny.injury.injury.blunt.type.BluntBodyInjuryType;

public class BodySeriousBluntAbstractInjuryGenerator extends AbstractBodyBluntInjuryGenerator {
    public BodySeriousBluntAbstractInjuryGenerator(BodyPartDto bodyPart) {
        super(bodyPart);
    }

    @Override
    protected int getPenalty() {
        return 0;
    }

    @Override
    protected int getProbability(BluntBodyInjuryType bluntInjuryType) {
        return 0;
    }


}
