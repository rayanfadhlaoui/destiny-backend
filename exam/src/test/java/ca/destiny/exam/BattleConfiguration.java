package ca.destiny.exam;

import ca.destiny.game.GameInformationService;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;

import static org.mockito.Mockito.mock;

@TestConfiguration
public class BattleConfiguration {

    @Bean
    @Primary
    public GameInformationService gameInformationServiceMock() {
        return mock(GameInformationService.class);
    }
}
