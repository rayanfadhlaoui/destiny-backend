package ca.destiny.injury.blunt.factory;

import ca.destiny.fighter.bodypart.BodyPartDto;
import ca.destiny.injury.blunt.InjuryGenerator;
import ca.destiny.injury.blunt.generator.body.BodySeriousBluntInjuryGenerator;
import ca.destiny.injury.blunt.generator.head.HeadSeriousBluntInjuryGenerator;
import ca.destiny.injury.blunt.generator.legorarm.LegOrArmSeriousBluntInjuryGenerator;

public class BluntSeriousInjuryGeneratorFactory extends AbstractBluntInjuryGeneratorFactory {

    @Override
    protected InjuryGenerator getOtherInjuryGenerator(BodyPartDto bodyPart) {
        return new LegOrArmSeriousBluntInjuryGenerator(bodyPart);
    }

    @Override
    protected InjuryGenerator getHeadInjuryGenerator(BodyPartDto bodyPart) {
        return new HeadSeriousBluntInjuryGenerator(bodyPart);
    }

    @Override
    protected InjuryGenerator getBodyInjuryGenerator(BodyPartDto bodyPart) {
        return new BodySeriousBluntInjuryGenerator(bodyPart);
    }
}
