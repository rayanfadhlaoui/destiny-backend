package ca.destiny.injury.blunt.factory;

import ca.destiny.fighter.bodypart.BodyPartDto;
import ca.destiny.injury.blunt.InjuryGenerator;
import ca.destiny.injury.blunt.generator.body.BodyModerateBluntInjuryGenerator;
import ca.destiny.injury.blunt.generator.head.HeadModerateBluntInjuryGenerator;
import ca.destiny.injury.blunt.generator.legorarm.LegOrArmModerateBluntInjuryGenerator;

public class BluntModerateInjuryGeneratorFactory extends AbstractBluntInjuryGeneratorFactory {
    @Override
    protected InjuryGenerator getOtherInjuryGenerator(BodyPartDto bodyPart) {
        return new LegOrArmModerateBluntInjuryGenerator(bodyPart);
    }

    @Override
    protected InjuryGenerator getHeadInjuryGenerator(BodyPartDto bodyPart) {
        return new HeadModerateBluntInjuryGenerator(bodyPart);
    }

    @Override
    protected InjuryGenerator getBodyInjuryGenerator(BodyPartDto bodyPart) {
        return new BodyModerateBluntInjuryGenerator(bodyPart);
    }
}
