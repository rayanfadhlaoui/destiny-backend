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
            injury = new SuperficialBruiseInjury(0,5);
        } else if (severity <= getProbability(BluntHeadInjuryType.MINOR_BRUISE)) {
            injury = new MinorBruiseInjury(2,10);
        } else if (severity <= getProbability(BluntHeadInjuryType.SEVERE_BRUISE)) {
            injury = new SevereBruiseInjury(4,15);
        } else if (severity <= getProbability(BluntHeadInjuryType.MINOR_FRACTURE)) {
            injury = new MinorFractureInjury(8,30);
        } else if (severity <= getProbability(BluntHeadInjuryType.SEVERE_FRACTURE)) {
            injury = new SevereFractureInjury(10,90);
        } else {
            injury = new BrokenBoneInjury(15,120);
        }
        return Optional.of(injury);
    }

    protected abstract int getProbability(BluntHeadInjuryType bluntInjuryType);
}
