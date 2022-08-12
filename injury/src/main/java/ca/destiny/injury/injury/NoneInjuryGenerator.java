package ca.destiny.injury.injury;

import ca.destiny.fighter.bodypart.BodyPartDto;
import ca.destiny.fighter.bodypart.Injury;

import java.util.Optional;

public class NoneInjuryGenerator extends AbstractInjuryGenerator {

    public NoneInjuryGenerator(BodyPartDto bodyPart) {
        super(bodyPart);
    }

    @Override
    protected int getPenalty() {
        return 0;
    }

    @Override
    protected Optional<Injury> getOptionalInjury(int penalty) {
        return Optional.empty();
    }
}
