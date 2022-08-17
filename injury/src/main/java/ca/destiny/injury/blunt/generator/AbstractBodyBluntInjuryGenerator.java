package ca.destiny.injury.blunt.generator;

import ca.destiny.fighter.bodypart.BodyPartDto;
import ca.destiny.fighter.injury.Injury;
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
            injury = new SuperficialBruiseInjury();
        } else if (severity <= getProbability(BluntBodyInjuryType.MINOR_BRUISE)) {
            injury = new MinorBruiseInjury();
        } else if (severity <= getProbability(BluntBodyInjuryType.SEVERE_BRUISE)) {
            injury = new SevereBruiseInjury();
        } else if (severity <= getProbability(BluntBodyInjuryType.MINOR_FRACTURE)) {
            injury = new MinorFractureInjury();
        } else if (severity <= getProbability(BluntBodyInjuryType.SEVERE_FRACTURE)) {
            injury = new SevereFractureInjury();
        } else {
            injury = new BrokenBoneInjury();
        }
        return Optional.of(injury);
    }

    protected abstract int getProbability(BluntBodyInjuryType bluntInjuryType);
}
