package ca.destiny.evolution.levelup;

import ca.destiny.fighter.BattleFighterDto;
import ca.destiny.other.RandomNumberGeneratorService;
import org.springframework.stereotype.Component;

@Component
public class ExperienceService {

    private final RandomNumberGeneratorService randomNumberGeneratorService;
    private final LevelUpExecutor levelUpExecutor;

    public ExperienceService(RandomNumberGeneratorService randomNumberGeneratorService,
                             LevelUpExecutor levelUpExecutor) {
        this.randomNumberGeneratorService = randomNumberGeneratorService;
        this.levelUpExecutor = levelUpExecutor;
    }

    public void explore(BattleFighterDto battleFighterDto) {
        var experience = battleFighterDto.getExperience();
        int currentExperience = experience.getCurrentExperience();
        int nextLevel = experience.getNextLevel();
        int levelUp = 0;
        int worth = experience.getWorth();
        while (currentExperience >= nextLevel) {
            currentExperience -= nextLevel;
            int delta = nextLevel / 10;
            nextLevel = randomNumberGeneratorService.getRandomNumberInts(nextLevel + delta, nextLevel * 2);
            worth += nextLevel / 10;
            levelUp++;
        }

        while (levelUp != 0) {
            levelUpExecutor.execute(battleFighterDto);
            levelUp--;
        }

        experience.setNextLevel(nextLevel);
        experience.setCurrentExperience(currentExperience);
        experience.setWorth(worth);
    }
}
