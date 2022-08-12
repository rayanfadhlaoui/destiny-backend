package ca.destiny.injury.blunt.factory;

import ca.destiny.fighter.bodypart.BodyPartDto;
import ca.destiny.injury.blunt.generator.moderate.BodyModerateBluntAbstractInjuryGenerator;
import ca.destiny.injury.blunt.generator.moderate.HeadModerateBluntAbstractInjuryGenerator;
import ca.destiny.injury.blunt.generator.legorarm.LegOrArmModerateBluntInjuryGenerator;
import ca.destiny.injury.injury.InjuryGenerator;

public class BluntModerateInjuryGeneratorFactory extends AbstractBluntInjuryGeneratorFactory {
    @Override
    protected InjuryGenerator getOtherInjuryGenerator(BodyPartDto bodyPart) {
        return new LegOrArmModerateBluntInjuryGenerator(bodyPart);
    }

    @Override
    protected InjuryGenerator getHeadInjuryGenerator(BodyPartDto bodyPart) {
        return new HeadModerateBluntAbstractInjuryGenerator(bodyPart);
    }

    @Override
    protected InjuryGenerator getBodyInjuryGenerator(BodyPartDto bodyPart) {
        return new BodyModerateBluntAbstractInjuryGenerator(bodyPart);
    }
}