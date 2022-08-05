package ca.destiny.battle;

import ca.destiny.battle.model.BattleDto;
import ca.destiny.evolution.levelup.ExperienceService;

public abstract class BattleExecutor {

    private final ExperienceService experienceService;

    protected BattleExecutor(ExperienceService experienceService) {
        this.experienceService = experienceService;
    }

    protected abstract BattleDto customExecute(BattleDto battleDto);

    public BattleDto execute(BattleDto battleDto) {
        battleDto = customExecute(battleDto);
        battleDto.getSummary()
                .getWinners()
                .forEach(experienceService::explore);
        return battleDto;
    }
}
