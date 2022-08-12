package ca.destiny.injury.blunt.generator;

import ca.destiny.fighter.bodypart.BodyPartDto;
import ca.destiny.fighter.bodypart.Injury;
import ca.destiny.injury.injury.AbstractInjuryGenerator;
import ca.destiny.injury.injury.blunt.*;
import ca.destiny.injury.injury.blunt.type.BluntArmOrLegInjuryType;

import java.util.Optional;

public abstract class AbstractHeadBluntInjuryGenerator extends AbstractInjuryGenerator {

    protected AbstractHeadBluntInjuryGenerator(BodyPartDto bodyPart) {
        super(bodyPart);
    }

    @Override
    protected Optional<Injury> getOptionalInjury(int penalty) {
        Injury injury;
        int severity = randomNumberGeneratorService.getRandomNumberInts(0, 100) + penalty;
        if (severity <= getProbability(BluntArmOrLegInjuryType.SUPERFICIAL_BRUISE)) {
            injury = new SuperficialBruiseInjury();
        } else if (severity <= getProbability(BluntArmOrLegInjuryType.MINOR_BRUISE)) {
            injury = new MinorBruiseInjury();
        } else if (severity <= getProbability(BluntArmOrLegInjuryType.SEVERE_BRUISE)) {
            injury = new SevereBruiseInjury();
        } else if (severity <= getProbability(BluntArmOrLegInjuryType.MINOR_FRACTURE)) {
            injury = new MinorFractureInjury();
        } else if (severity <= getProbability(BluntArmOrLegInjuryType.SEVERE_FRACTURE)) {
            injury = new SevereFractureInjury();
        } else {
            injury = new BrokenBoneInjury();
        }
        return Optional.of(injury);
    }

    protected abstract int getProbability(BluntArmOrLegInjuryType bluntInjuryType);
}
