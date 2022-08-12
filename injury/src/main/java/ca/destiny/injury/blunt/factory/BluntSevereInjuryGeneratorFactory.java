package ca.destiny.injury.blunt.factory;

import ca.destiny.fighter.bodypart.BodyPartDto;
import ca.destiny.injury.blunt.generator.severe.BodySevereBluntAbstractInjuryGenerator;
import ca.destiny.injury.blunt.generator.severe.HeadSevereBluntAbstractInjuryGenerator;
import ca.destiny.injury.blunt.generator.legorarm.LegOrArmSevereBluntInjuryGenerator;
import ca.destiny.injury.injury.InjuryGenerator;

public class BluntSevereInjuryGeneratorFactory extends AbstractBluntInjuryGeneratorFactory {
    @Override
    protected InjuryGenerator getOtherInjuryGenerator(BodyPartDto bodyPart) {
        return new LegOrArmSevereBluntInjuryGenerator(bodyPart);
    }

    @Override
    protected InjuryGenerator getHeadInjuryGenerator(BodyPartDto bodyPart) {
        return new HeadSevereBluntAbstractInjuryGenerator(bodyPart);
    }

    @Override
    protected InjuryGenerator getBodyInjuryGenerator(BodyPartDto bodyPart) {
        return new BodySevereBluntAbstractInjuryGenerator(bodyPart);
    }
}
