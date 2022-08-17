package ca.destiny.injury.blunt.generator;

import ca.destiny.fighter.bodypart.BodyPartDto;
import ca.destiny.fighter.injury.Injury;
import ca.destiny.fighter.injury.*;
import ca.destiny.fighter.injury.type.BluntHeadInjuryType;
import ca.destiny.injury.AbstractInjuryGenerator;

import java.util.Optional;

public abstract class AbstractHeadBluntInjuryGenerator extends AbstractInjuryGenerator {

    protected AbstractHeadBluntInjuryGenerator(BodyPartDto bodyPart) {
        super(bodyPart);
    }

    @Override
    protected Optional<Injury> getOptionalInjury(int penalty) {
        Injury injury;
        int severity = randomNumberGeneratorService.getRandomNumberInts(0, 100) + penalty;
        if (severity <= getProbability(BluntHeadInjuryType.SUPERFICIAL_BRUISE)) {
            injury = new SuperficialBruiseInjury();
        } else if (severity <= getProbability(BluntHeadInjuryType.MINOR_BRUISE)) {
            injury = new MinorBruiseInjury();
        } else if (severity <= getProbability(BluntHeadInjuryType.SEVERE_BRUISE)) {
            injury = new SevereBruiseInjury();
        } else if (severity <= getProbability(BluntHeadInjuryType.MINOR_FRACTURE)) {
            injury = new MinorFractureInjury();
        } else if (severity <= getProbability(BluntHeadInjuryType.SEVERE_FRACTURE)) {
            injury = new SevereFractureInjury();
        } else {
            injury = new BrokenBoneInjury();
        }
        return Optional.of(injury);
    }

    protected abstract int getProbability(BluntHeadInjuryType bluntInjuryType);
}
