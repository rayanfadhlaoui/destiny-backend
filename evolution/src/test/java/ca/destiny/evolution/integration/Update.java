package ca.destiny.evolution.integration;

import ca.destiny.ApplicationTest;
import ca.destiny.destinytest.AbstractIntegrationTest;
import ca.destiny.evolution.creation.bodypart.BodyPartFactory;
import ca.destiny.fighter.BattleFighterDto;
import ca.destiny.fighter.bodypart.BodyPartDto;
import ca.destiny.other.RandomNumberGeneratorService;
import com.fasterxml.jackson.core.type.TypeReference;
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
public class Update extends AbstractIntegrationTest {

    @Autowired
    private RandomNumberGeneratorService randomNumberGeneratorService;
    @Autowired
    private BodyPartFactory bodyPartFactory;

    @Test
    void update() throws IOException, URISyntaxException {
        List<BattleFighterDto> fighters = loadListFromFile("thirdClass.json", new TypeReference<>() {
        });
        fighters.forEach(f -> {
            int resistance = randomNumberGeneratorService.getRandomNumberInts(25, 50);
            f.getCharacteristics().setResistance(resistance);
            f.getBattleInformation().setResistance(resistance);
            List<BodyPartDto> bodyPartDtos = bodyPartFactory.create();
            f.getPerson().setAvailableBodyParts(bodyPartDtos);
        });
        fighters.size();

        writeData(fighters, "thirdClassUpdated.json");
    }
}
