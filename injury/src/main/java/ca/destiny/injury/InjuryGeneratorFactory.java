package ca.destiny.injury;

import ca.destiny.fighter.bodypart.BodyPartDto;
import ca.destiny.injury.injury.InjuryGenerator;

import java.util.function.Supplier;

public interface InjuryGeneratorFactory {
    InjuryGeneratorFactory EMPTY = new NoneInjuryGeneratorFactory();

    InjuryGenerator create(Supplier<BodyPartDto> bodyPartSupplier);
}
