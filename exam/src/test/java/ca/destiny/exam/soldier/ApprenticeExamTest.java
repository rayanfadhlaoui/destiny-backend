package ca.destiny.exam.soldier;

import ca.destiny.ApplicationTest;
import ca.destiny.evolution.creation.FighterFactory;
import ca.destiny.evolution.creation.PersonFactory;
import ca.destiny.exam.AbstractExamTest;
import ca.destiny.exam.BattleConfiguration;
import ca.destiny.fighter.BattleFighterDto;
import ca.destiny.game.GameInformationService;
import ca.destiny.person.common.DestinyDate;
import ca.destiny.person.common.RaceEnum;
import com.fasterxml.jackson.core.type.TypeReference;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.BDDMockito.given;

@ExtendWith(SpringExtension.class)
@Import(BattleConfiguration.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK, classes = ApplicationTest.class)
public class ApprenticeExamTest extends AbstractExamTest {

    public static final long GAME_ID = 1L;

    @Autowired
    private PersonFactory personFactory;
    @Autowired
    private FighterFactory fighterFactory;

    @Autowired
    private GameInformationService gameInformationServiceMock;

    public ApprenticeExamTest(@Autowired ApprenticeExam apprenticeExam) {
        super(ApprenticeExamTest.class, apprenticeExam);
    }

    @Test
    void apprenticeExam_WithNew() throws IOException, URISyntaxException {
        List<BattleFighterDto> battleFighters = create(5000);
        List<BattleFighterDto> old = loadListFromFile("noClassFighters.json", new TypeReference<>() {
        });
        battleFighters.addAll(old);
        exam(battleFighters, "apprentices.json", "noClassFighters.json", 2500);
    }

    @Test
    void apprenticeExam_WithOld() throws IOException, URISyntaxException {
        exam("noClassFighters.json", "apprentices.json", "noClassFighters.json", 200);
    }

    List<BattleFighterDto> create(int size) {
        var destinyDate = createDestinyDate();
        given(gameInformationServiceMock.getCurrentDate(GAME_ID)).willReturn(destinyDate);
        List<BattleFighterDto> fighters = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            var personDto = personFactory.create(RaceEnum.HUMAN, 1L);
            var fighter = fighterFactory.create(personDto, 1L);
            fighters.add(fighter);
        }

        return fighters;
    }

    private DestinyDate createDestinyDate() {
        var destinyDate = new DestinyDate();
        destinyDate.setDay(1);
        destinyDate.setMonth(1);
        destinyDate.setYear(1);
        return destinyDate;
    }
}
