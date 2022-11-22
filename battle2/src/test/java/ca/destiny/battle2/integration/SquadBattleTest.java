package ca.destiny.battle2.integration;

import ca.destiny.ApplicationTest;
import ca.destiny.battle2.*;
import ca.destiny.destinytest.AbstractIntegration;
import com.fasterxml.jackson.core.type.TypeReference;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

import static org.assertj.core.api.Java6Assertions.assertThat;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK, classes = ApplicationTest.class)
public class SquadBattleTest extends AbstractIntegration {

    @Autowired
    private SquadBattleExecutor squadBattleExecutor;

    public SquadBattleTest() {
        super(SquadBattleTest.class);
    }

    @Test
    @Disabled
    void read() throws IOException, URISyntaxException {
        List<Fraction> fractions = loadListFromFile("fractions.json", new TypeReference<>() {
        });
        Fighter fighter = fractions.get(1).getSquads().get(0).getFighterByPosition().get(new Position(0, 1));
        assertThat(fighter).isNotNull();

        Fraction fraction1 = fractions.get(0);
        Fraction fraction2 = fractions.get(1);
        SquadBattle squadBattle = new SquadBattle(fraction1.getSquads().get(0), fraction2.getSquads().get(0));

        while (!squadBattle.isOver()) {
            squadBattleExecutor.execute(squadBattle);
        }
    }

}
