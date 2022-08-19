package ca.destiny.injury;

import ca.destiny.fighter.BattleInformation;
import ca.destiny.fighter.FightingStatus;
import ca.destiny.fighter.injury.Injury;
import ca.destiny.other.RandomNumberGeneratorService;
import org.springframework.stereotype.Component;

@Component
public class FightStatusUpdater {

    private final RandomNumberGeneratorService randomNumberGeneratorService;

    public FightStatusUpdater(RandomNumberGeneratorService randomNumberGeneratorService) {
        this.randomNumberGeneratorService = randomNumberGeneratorService;
    }

    public void update(Injury injury, BattleInformation battleInformation) {
        FightingStatus fightingStatus = battleInformation.getFightingStatus();
        if (randomNumberGeneratorService.getRandomNumberInts(0, 100) < injury.getDeathProbability()) {
            fightingStatus.setAlive(false);
        } else {
            updateConsciousness(injury.getPain(), battleInformation);
        }
    }

    private void updateConsciousness(int pain, BattleInformation battleInformation) {
        int painValue = randomNumberGeneratorService.getRandomNumberInts(0, 400);
        if (painValue <= pain) {
            int courage = battleInformation.getCourage();
            if ((courage + painValue) - (pain) >= 0) {
                battleInformation.setCourage(courage - painValue);
            } else {
                battleInformation.getFightingStatus().setConscience(false);
            }
        }
    }
}
