package ca.destiny.injury.blunt.factory;

import ca.destiny.fighter.bodypart.BodyPartDto;
import ca.destiny.injury.blunt.generator.body.BodySevereBluntInjuryGenerator;
import ca.destiny.injury.blunt.generator.head.HeadSevereBluntInjuryGenerator;
import ca.destiny.injury.blunt.generator.legorarm.LegOrArmSevereBluntInjuryGenerator;
import ca.destiny.injury.injury.InjuryGenerator;

public class BluntSevereInjuryGeneratorFactory extends AbstractBluntInjuryGeneratorFactory {
    @Override
    protected InjuryGenerator getOtherInjuryGenerator(BodyPartDto bodyPart) {
        return new LegOrArmSevereBluntInjuryGenerator(bodyPart);
    }

    @Override
    protected InjuryGenerator getHeadInjuryGenerator(BodyPartDto bodyPart) {
        return new HeadSevereBluntInjuryGenerator(bodyPart);
    }

    @Override
    protected InjuryGenerator getBodyInjuryGenerator(BodyPartDto bodyPart) {
        return new BodySevereBluntInjuryGenerator(bodyPart);
    }
}
