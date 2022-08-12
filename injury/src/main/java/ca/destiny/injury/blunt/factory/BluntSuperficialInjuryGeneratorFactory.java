package ca.destiny.injury.blunt.factory;

import ca.destiny.fighter.bodypart.BodyPartDto;
import ca.destiny.injury.blunt.generator.body.BodySuperficialBluntInjuryGenerator;
import ca.destiny.injury.blunt.generator.head.HeadSuperficialBluntInjuryGenerator;
import ca.destiny.injury.blunt.generator.legorarm.LegOrArmSuperficialBluntInjuryGenerator;
import ca.destiny.injury.injury.InjuryGenerator;

public class BluntSuperficialInjuryGeneratorFactory extends AbstractBluntInjuryGeneratorFactory {

    @Override
    protected InjuryGenerator getOtherInjuryGenerator(BodyPartDto bodyPart) {
        return new LegOrArmSuperficialBluntInjuryGenerator(bodyPart);
    }

    @Override
    protected InjuryGenerator getHeadInjuryGenerator(BodyPartDto bodyPart) {
        return new HeadSuperficialBluntInjuryGenerator(bodyPart);
    }

    @Override
    protected InjuryGenerator getBodyInjuryGenerator(BodyPartDto bodyPart) {
        return new BodySuperficialBluntInjuryGenerator(bodyPart);
    }
}
