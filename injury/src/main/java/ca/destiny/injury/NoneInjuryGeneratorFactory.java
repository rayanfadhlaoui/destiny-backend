package ca.destiny.injury;

import ca.destiny.fighter.bodypart.BodyPartDto;
import ca.destiny.injury.injury.InjuryGenerator;

import java.util.function.Supplier;

public class NoneInjuryGeneratorFactory implements InjuryGeneratorFactory {
    @Override
    public InjuryGenerator create(Supplier<BodyPartDto> bodyPartSupplier) {
        return InjuryGenerator.EMPTY;
    }
}
