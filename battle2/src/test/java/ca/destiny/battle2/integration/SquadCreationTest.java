package ca.destiny.battle2.integration;

import ca.destiny.ApplicationTest;
import ca.destiny.battle2.*;
import ca.destiny.destinytest.AbstractIntegration;
import ca.destiny.v2.person.common.RaceEnum;
import com.fasterxml.jackson.core.type.TypeReference;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Java6Assertions.assertThat;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK, classes = ApplicationTest.class)
public class SquadCreationTest extends AbstractIntegration {

    @Autowired
    private SquadFactory squadFactory;

    public SquadCreationTest() {
        super(SquadCreationTest.class);
    }

    @Test
    @Disabled
    void createFractions() throws IOException {
        List<Fraction> fractions = new ArrayList<>();

        fractions.add(createFraction(RaceEnum.ELF, "The Shallow Moon"));
        fractions.add(createFraction(RaceEnum.ELF, "The False Moon"));

        fractions.add(createFraction(RaceEnum.ORC, "The Rotten World"));
        fractions.add(createFraction(RaceEnum.ORC, "The Dying Territory"));

        fractions.add(createFraction(RaceEnum.HUMAN, "The Bitter Lands"));
        fractions.add(createFraction(RaceEnum.HUMAN, "The Perfect Region"));

        fractions.add(createFraction(RaceEnum.DWARF, "The Lost Lands"));
        fractions.add(createFraction(RaceEnum.DWARF, ""));

        writeData(fractions, "fractions.json");
    }


    @Test
    @Disabled
    void read() throws IOException, URISyntaxException {
        List<Fraction> fractions = loadListFromFile("fractions.json", new TypeReference<>() {
        });
        Fighter fighter = fractions.get(1).getSquads().get(0).getFighterByPosition().get(new Position(0, 1));
        assertThat(fighter).isNotNull();
    }

    private Fraction createFraction(RaceEnum raceEnum, String fractionName) {
        List<Squad> squads = new ArrayList<>();
        String squadName;
        switch (raceEnum) {
            case ORC:
                squadName = "Orc squad ";
                break;
            case HUMAN:
                squadName = "Human squad ";
                break;
            case ELF:
                squadName = "Elf squad ";
                break;
            case DWARF:
                squadName = "Dwarf squad ";
                break;
            default:
                throw new IllegalStateException();
        }
        squads.add(squadFactory.createFromScratch(raceEnum, squadName + "1"));
        squads.add(squadFactory.createFromScratch(raceEnum, squadName + "2"));
        squads.add(squadFactory.createFromScratch(raceEnum, squadName + "3"));
        squads.add(squadFactory.createFromScratch(raceEnum, squadName + "4"));
        return new Fraction(fractionName, squads);
    }

}
