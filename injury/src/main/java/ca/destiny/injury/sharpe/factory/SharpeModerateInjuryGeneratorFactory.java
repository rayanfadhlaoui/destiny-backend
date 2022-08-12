package ca.destiny.injury.sharpe.factory;

import ca.destiny.fighter.bodypart.BodyPartDto;
import ca.destiny.injury.injury.AbstractInjuryGenerator;

public class SharpeModerateInjuryGeneratorFactory extends AbstractSharpeInjuryGeneratorFactory {
    @Override
    protected AbstractInjuryGenerator getFeetOrHandInjuryGenerator(BodyPartDto bodyPart) {
        return null;
    }

    @Override
    protected AbstractInjuryGenerator getLegOrArmInjuryGenerator(BodyPartDto bodyPart) {
        return null;
    }

    @Override
    protected AbstractInjuryGenerator getHeadInjuryGenerator(BodyPartDto bodyPart) {
        return null;
    }

    @Override
    protected AbstractInjuryGenerator getBodyInjuryGenerator(BodyPartDto bodyPart) {
        return null;
    }
}