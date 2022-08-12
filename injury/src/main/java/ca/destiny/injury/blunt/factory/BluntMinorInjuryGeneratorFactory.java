package ca.destiny.injury.blunt.factory;

import ca.destiny.fighter.bodypart.BodyPartDto;
import ca.destiny.injury.blunt.generator.body.BodyMinorBluntInjuryGenerator;
import ca.destiny.injury.blunt.generator.head.HeadMinorBluntInjuryGenerator;
import ca.destiny.injury.blunt.generator.legorarm.LegOrArmMinorBluntInjuryGenerator;
import ca.destiny.injury.injury.InjuryGenerator;

public class BluntMinorInjuryGeneratorFactory extends AbstractBluntInjuryGeneratorFactory {
    @Override
    protected InjuryGenerator getOtherInjuryGenerator(BodyPartDto bodyPart) {
        return new LegOrArmMinorBluntInjuryGenerator(bodyPart);
    }

    @Override
    protected InjuryGenerator getHeadInjuryGenerator(BodyPartDto bodyPart) {
        return new HeadMinorBluntInjuryGenerator(bodyPart);
    }

    @Override
    protected InjuryGenerator getBodyInjuryGenerator(BodyPartDto bodyPart) {
        return new BodyMinorBluntInjuryGenerator(bodyPart);
    }
}
