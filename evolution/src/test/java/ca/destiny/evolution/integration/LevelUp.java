package ca.destiny.evolution.integration;

import ca.destiny.ApplicationTest;
import ca.destiny.destinytest.AbstractIntegration;
import ca.destiny.evolution.levelup.ExperienceService;
import ca.destiny.fighter.BattleFighterDto;
import com.fasterxml.jackson.core.type.TypeReference;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

@ExtendWith(SpringExtension.class)
@Import(EvolutionConfiguration.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK, classes = ApplicationTest.class)
@Disabled
public class LevelUp extends AbstractIntegration {

    public static final long GAME_ID = 1L;
    @Autowired
    private ExperienceService experienceService;

    public LevelUp() {
        super(LevelUp.class);
    }

    @Test
    void levelUp() throws IOException, URISyntaxException {

        List<BattleFighterDto> battleFighters = loadListFromFile("weapon.json", new TypeReference<>() {
        });
        for (BattleFighterDto battleFighter : battleFighters) {
            experienceService.explore(battleFighter);
        }

        writeData(battleFighters, "apprenticeUpdated.json");
    }

}
