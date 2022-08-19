package ca.destiny.injury.blunt.generator;

import ca.destiny.fighter.bodypart.BodyPartDto;
import ca.destiny.fighter.injury.*;
import ca.destiny.fighter.injury.type.BluntArmOrLegInjuryType;
import ca.destiny.injury.AbstractInjuryGenerator;

import java.util.Optional;

public abstract class AbstractLegOrArmsBluntInjuryGenerator extends AbstractInjuryGenerator {


    protected AbstractLegOrArmsBluntInjuryGenerator(BodyPartDto bodyPart) {
        super(bodyPart);
    }

    @Override
    protected Optional<Injury> getOptionalInjury(int penalty) {
        Injury injury;
        int severity = randomNumberGeneratorService.getRandomNumberInts(0, 100) + penalty;
        if (severity <= getProbability(BluntArmOrLegInjuryType.SUPERFICIAL_BRUISE)) {
            injury = new SuperficialBruiseInjury(0, 1);
        } else if (severity <= getProbability(BluntArmOrLegInjuryType.MINOR_BRUISE)) {
            injury = new MinorBruiseInjury(0, 2);
        } else if (severity <= getProbability(BluntArmOrLegInjuryType.SEVERE_BRUISE)) {
            injury = new SevereBruiseInjury(0, 5);
        } else if (severity <= getProbability(BluntArmOrLegInjuryType.MINOR_FRACTURE)) {
            injury = new MinorFractureInjury(0, 15);
        } else if (severity <= getProbability(BluntArmOrLegInjuryType.SEVERE_FRACTURE)) {
            injury = new SevereFractureInjury(0, 30);
        } else if (severity <= getProbability(BluntArmOrLegInjuryType.DISLOCATION)) {
            injury = new DislocationInjury(0, 30);
        } else {
            injury = new BrokenBoneInjury(0, 60);
        }
        return Optional.of(injury);
    }

    protected abstract int getProbability(BluntArmOrLegInjuryType bluntInjuryType);
}
