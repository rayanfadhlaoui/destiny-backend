package ca.destiny.injury.blunt.factory;

import ca.destiny.fighter.bodypart.BodyPartDto;
import ca.destiny.injury.InjuryGeneratorFactory;
import ca.destiny.injury.injury.InjuryGenerator;

import java.util.function.Supplier;

public abstract class AbstractBluntInjuryGeneratorFactory implements InjuryGeneratorFactory {

    @Override
    public InjuryGenerator create(Supplier<BodyPartDto> bodyPartSupplier) {
        var bodyPart = bodyPartSupplier.get();
        switch (bodyPart.getType()) {
            case BODY:
                return getBodyInjuryGenerator(bodyPart);
            case HEAD:
                return getHeadInjuryGenerator(bodyPart);
            default:
                return getOtherInjuryGenerator(bodyPart);
        }
    }

    protected abstract InjuryGenerator getOtherInjuryGenerator(BodyPartDto bodyPart);

    protected abstract InjuryGenerator getHeadInjuryGenerator(BodyPartDto bodyPart);

    protected abstract InjuryGenerator getBodyInjuryGenerator(BodyPartDto bodyPart);
}
