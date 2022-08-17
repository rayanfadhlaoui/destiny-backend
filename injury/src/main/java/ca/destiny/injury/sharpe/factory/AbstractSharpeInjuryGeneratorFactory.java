package ca.destiny.injury.sharpe.factory;

import ca.destiny.fighter.bodypart.BodyPartDto;
import ca.destiny.injury.AbstractInjuryGenerator;
import ca.destiny.injury.InjuryGeneratorFactory;

import java.util.function.Supplier;

public abstract class AbstractSharpeInjuryGeneratorFactory implements InjuryGeneratorFactory {

    @Override
    public AbstractInjuryGenerator create(Supplier<BodyPartDto> bodyPartSupplier) {
        var bodyPart = bodyPartSupplier.get();
        switch (bodyPart.getType()) {
            case BODY:
                return getBodyInjuryGenerator(bodyPart);
            case HEAD:
                return getHeadInjuryGenerator(bodyPart);
            case LEFT_ARM:
            case LEFT_LEG:
            case RIGHT_ARM:
            case RIGHT_LEG:
                return getLegOrArmInjuryGenerator(bodyPart);
            default:
                return getFeetOrHandInjuryGenerator(bodyPart);
        }
    }

    protected abstract AbstractInjuryGenerator getFeetOrHandInjuryGenerator(BodyPartDto bodyPart);

    protected abstract AbstractInjuryGenerator getLegOrArmInjuryGenerator(BodyPartDto bodyPart);

    protected abstract AbstractInjuryGenerator getHeadInjuryGenerator(BodyPartDto bodyPart);

    protected abstract AbstractInjuryGenerator getBodyInjuryGenerator(BodyPartDto bodyPart);
}
