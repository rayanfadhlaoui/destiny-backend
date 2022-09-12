package ca.destiny.injury;

import ca.destiny.fighter.BattleInformation;
import ca.destiny.fighter.bodypart.BodyPartDto;
import ca.destiny.fighter.injury.Injury;
import ca.destiny.injury.blunt.InjuryGenerator;
import ca.destiny.other.RandomNumberGeneratorService;

import java.util.Optional;

public abstract class AbstractInjuryGenerator implements InjuryGenerator {

    private final BodyPartDto bodyPart;
    protected final RandomNumberGeneratorService randomNumberGeneratorService;

    public AbstractInjuryGenerator(BodyPartDto bodyPart) {
        this.bodyPart = bodyPart == null ? new BodyPartDto() : bodyPart;
        randomNumberGeneratorService = new RandomNumberGeneratorService();
    }

    @Override
    public void inflict(boolean knockout, BattleInformation battleInformation, FightStatusUpdater fightStatusUpdater) {
        int penalty = knockout ? getPenalty() : 0;
        penalty += bodyPart.getPenalty();
        Optional<Injury> optionalInjury = getOptionalInjury(penalty);
        optionalInjury.ifPresent(injury -> {
            bodyPart.addInjury(injury);
            fightStatusUpdater.update(injury, battleInformation);
        });
    }

    protected abstract int getPenalty();

    protected abstract Optional<Injury> getOptionalInjury(int penalty);
}
