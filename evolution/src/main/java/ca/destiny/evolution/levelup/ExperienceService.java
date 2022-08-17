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
            int delta = (nextLevel / 10) + 100;
            worth += (nextLevel / 100);
            nextLevel = randomNumberGeneratorService.getRandomNumberInts(nextLevel + 100, nextLevel + delta);
            levelUp++;
        }

        while (levelUp != 0) {
            int level = experience.getLevel();
            experience.setLevel(level + 1);
            levelUpExecutor.execute(battleFighterDto);
            levelUp--;
        }

        experience.setNextLevel(nextLevel);
        experience.setCurrentExperience(currentExperience);
        experience.setWorth(worth);
    }
}
