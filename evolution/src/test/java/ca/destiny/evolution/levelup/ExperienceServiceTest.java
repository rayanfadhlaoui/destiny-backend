package ca.destiny.evolution.levelup;

import ca.destiny.fighter.BattleFighterDto;
import ca.destiny.fighter.experience.ExperienceDto;
import ca.destiny.other.RandomNumberGeneratorService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.stubbing.Answer;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;


@ExtendWith(MockitoExtension.class)
class ExperienceServiceTest {

    @InjectMocks
    private ExperienceService experienceService;

    @Mock
    private LevelUpExecutor levelUpExecutor;
    @Mock
    private RandomNumberGeneratorService randomNumberGeneratorService;

    @Test
    void NoCurrentExperience() {
        var battleFighterDto = createFighter(0);
        experienceService.explore(battleFighterDto);
        verify(levelUpExecutor, never()).execute(battleFighterDto);
    }

    @Test
    void OneLevel() {
        var battleFighterDto = createFighter(11);
        ExperienceDto experience = battleFighterDto.getExperience();
        given(randomNumberGeneratorService.getRandomNumberInts(11, 20)).willReturn(20);

        experienceService.explore(battleFighterDto);

        assertExperience(experience, 12, 1, 20);
        verify(levelUpExecutor, times(1)).execute(battleFighterDto);
    }

    @Test
    void TwoLevel() {
        var battleFighterDto = createFighter(60);
        ExperienceDto experience = battleFighterDto.getExperience();
        givenTwoCallToRandomNumber();

        experienceService.explore(battleFighterDto);

        assertExperience(experience, 16, 30, 40);
        verify(levelUpExecutor, times(2)).execute(battleFighterDto);
    }

    private void givenTwoCallToRandomNumber() {
        given(randomNumberGeneratorService.getRandomNumberInts(anyInt(), anyInt()))
                .willAnswer((Answer<Integer>) invocationOnMock -> {
                    Integer arg1 = (Integer) invocationOnMock.getArguments()[0];
                    Integer arg2 = (Integer) invocationOnMock.getArguments()[1];
                    if (arg1 == 11 && arg2 == 20) {
                        return 20;
                    } else if (arg1 == 22 && arg2 == 40) {
                        return 40;
                    }
                    throw new IllegalArgumentException("");
                });
    }

    private BattleFighterDto createFighter(int currentExperience) {
        var battleFighterDto = new BattleFighterDto();
        var experience = new ExperienceDto();
        experience.setWorth(10);
        experience.setCurrentExperience(currentExperience);
        experience.setNextLevel(10);
        battleFighterDto.setExperience(experience);
        return battleFighterDto;
    }

    private void assertExperience(ExperienceDto experience,
                                  int worth,
                                  int currentExperience,
                                  int nextLevel) {
        assertThat(experience.getWorth()).isEqualTo(worth);
        assertThat(experience.getCurrentExperience()).isEqualTo(currentExperience);
        assertThat(experience.getNextLevel()).isEqualTo(nextLevel);
    }

}