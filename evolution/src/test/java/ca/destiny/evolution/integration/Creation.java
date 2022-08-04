package ca.destiny.evolution.integration;

import ca.destiny.ApplicationTest;
import ca.destiny.evolution.creation.FighterFactory;
import ca.destiny.evolution.creation.PersonFactory;
import ca.destiny.fighter.BattleFighterDto;
import ca.destiny.game.GameInformationService;
import ca.destiny.person.PersonDto;
import ca.destiny.person.common.DestinyDate;
import ca.destiny.person.common.RaceEnum;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.BDDMockito.given;

@ExtendWith(SpringExtension.class)
@Import(EvolutionConfiguration.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK, classes = ApplicationTest.class)
public class Creation {

    public static final long GAME_ID = 1L;
    @Autowired
    private PersonFactory personFactory;
    @Autowired
    private FighterFactory fighterFactory;

    @Autowired
    private GameInformationService gameInformationServiceMock;
    private final ObjectMapper objectMapper = new ObjectMapper();

    @Test
    @Disabled
    void createBig100() throws IOException {
        var destinyDate = createDestinyDate();
        given(gameInformationServiceMock.getCurrentDate(GAME_ID)).willReturn(destinyDate);
        List<BattleFighterDto> fighters = new ArrayList<>();
        for (int i = 0; i < 500; i++) {
            var personDto = personFactory.create(RaceEnum.HUMAN, 1L);
            var fighter = fighterFactory.create(personDto, 1L);
            fighters.add(fighter);
        }
        String json = objectMapper.writeValueAsString(fighters);
        Path filePath = Path.of("fighters.json");

        Files.writeString(filePath, json);
    }

    private DestinyDate createDestinyDate() {
        var destinyDate = new DestinyDate();
        destinyDate.setDay(1);
        destinyDate.setMonth(1);
        destinyDate.setYear(12);
        return destinyDate;
    }

}
