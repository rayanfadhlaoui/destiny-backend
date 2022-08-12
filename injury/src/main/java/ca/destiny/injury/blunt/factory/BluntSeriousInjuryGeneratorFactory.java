package ca.destiny.injury.blunt.factory;

import ca.destiny.fighter.bodypart.BodyPartDto;
import ca.destiny.injury.blunt.generator.serious.BodySeriousBluntAbstractInjuryGenerator;
import ca.destiny.injury.blunt.generator.serious.HeadSeriousBluntAbstractInjuryGenerator;
import ca.destiny.injury.blunt.generator.legorarm.LegOrArmSeriousBluntInjuryGenerator;
import ca.destiny.injury.injury.InjuryGenerator;

public class BluntSeriousInjuryGeneratorFactory extends AbstractBluntInjuryGeneratorFactory {

    @Override
    protected InjuryGenerator getOtherInjuryGenerator(BodyPartDto bodyPart) {
        return new LegOrArmSeriousBluntInjuryGenerator(bodyPart);
    }

    @Override
    protected InjuryGenerator getHeadInjuryGenerator(BodyPartDto bodyPart) {
        return new HeadSeriousBluntAbstractInjuryGenerator(bodyPart);
    }

    @Override
    protected InjuryGenerator getBodyInjuryGenerator(BodyPartDto bodyPart) {
        return new BodySeriousBluntAbstractInjuryGenerator(bodyPart);
    }
}
