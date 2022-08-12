package ca.destiny.injury.injury;

import ca.destiny.fighter.bodypart.BodyPartDto;
import ca.destiny.fighter.bodypart.Injury;
import ca.destiny.other.RandomNumberGeneratorService;

import java.util.Optional;

public abstract class AbstractInjuryGenerator implements InjuryGenerator {

    private final BodyPartDto bodyPart;
    protected final RandomNumberGeneratorService randomNumberGeneratorService;

    public AbstractInjuryGenerator(BodyPartDto bodyPart) {
        this.bodyPart = bodyPart;
        randomNumberGeneratorService = new RandomNumberGeneratorService();
    }

    @Override
    public void inflict(boolean knockout) {
        int penalty = knockout ? getPenalty() : 0;
        Optional<Injury> optionalInjury = getOptionalInjury(penalty);
        optionalInjury.ifPresent(injury -> {
            if (bodyPart != null) {
                bodyPart.addInjury(injury);
            }
        });
    }

    protected abstract int getPenalty();

    protected abstract Optional<Injury> getOptionalInjury(int penalty);
}
