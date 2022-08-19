package ca.destiny.injury.blunt.generator;

import ca.destiny.fighter.bodypart.BodyPartDto;
import ca.destiny.fighter.injury.*;
import ca.destiny.fighter.injury.type.BluntBodyInjuryType;
import ca.destiny.injury.AbstractInjuryGenerator;

import java.util.Optional;

public abstract class AbstractBodyBluntInjuryGenerator extends AbstractInjuryGenerator {

    protected AbstractBodyBluntInjuryGenerator(BodyPartDto bodyPart) {
        super(bodyPart);
    }

    @Override
    protected Optional<Injury> getOptionalInjury(int penalty) {
        Injury injury;
        int severity = randomNumberGeneratorService.getRandomNumberInts(0, 100) + penalty;
        if (severity <= getProbability(BluntBodyInjuryType.SUPERFICIAL_BRUISE)) {
            injury = new SuperficialBruiseInjury(0, 2);
        } else if (severity <= getProbability(BluntBodyInjuryType.MINOR_BRUISE)) {
            injury = new MinorBruiseInjury(1, 3);
        } else if (severity <= getProbability(BluntBodyInjuryType.SEVERE_BRUISE)) {
            injury = new SevereBruiseInjury(2, 6);
        } else if (severity <= getProbability(BluntBodyInjuryType.MINOR_FRACTURE)) {
            injury = new MinorFractureInjury(3, 15);
        } else if (severity <= getProbability(BluntBodyInjuryType.SEVERE_FRACTURE)) {
            injury = new SevereFractureInjury(4, 30);
        } else {
            injury = new BrokenBoneInjury(5, 60);
        }
        return Optional.of(injury);
    }

    protected abstract int getProbability(BluntBodyInjuryType bluntInjuryType);
}
