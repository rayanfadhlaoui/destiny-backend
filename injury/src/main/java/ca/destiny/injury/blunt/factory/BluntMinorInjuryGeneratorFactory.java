package ca.destiny.injury.blunt.factory;

import ca.destiny.fighter.bodypart.BodyPartDto;
import ca.destiny.injury.blunt.generator.minor.BodyMinorBluntAbstractInjuryGenerator;
import ca.destiny.injury.blunt.generator.minor.HeadMinorBluntAbstractInjuryGenerator;
import ca.destiny.injury.blunt.generator.legorarm.LegOrArmMinorBluntInjuryGenerator;
import ca.destiny.injury.injury.InjuryGenerator;

public class BluntMinorInjuryGeneratorFactory extends AbstractBluntInjuryGeneratorFactory {
    @Override
    protected InjuryGenerator getOtherInjuryGenerator(BodyPartDto bodyPart) {
        return new LegOrArmMinorBluntInjuryGenerator(bodyPart);
    }

    @Override
    protected InjuryGenerator getHeadInjuryGenerator(BodyPartDto bodyPart) {
        return new HeadMinorBluntAbstractInjuryGenerator(bodyPart);
    }

    @Override
    protected InjuryGenerator getBodyInjuryGenerator(BodyPartDto bodyPart) {
        return new BodyMinorBluntAbstractInjuryGenerator(bodyPart);
    }
}
