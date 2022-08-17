package ca.destiny.battle.integration.admiral;

import ca.destiny.ApplicationTest;
import ca.destiny.battle.integration.Battle;
import ca.destiny.battle.integration.BattleConfiguration;
import ca.destiny.battle.simulation.SimulationBattleExecutor;
import ca.destiny.fighter.ClassEnum;
import ca.destiny.other.RandomNumberGeneratorService;
import ca.destiny.weapon.behavior.OptimalWeaponFinder;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.io.IOException;
import java.net.URISyntaxException;

@ExtendWith(SpringExtension.class)
@Import(BattleConfiguration.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK, classes = ApplicationTest.class)
public class GrandAdmiralBattle extends Battle {

    public GrandAdmiralBattle(@Autowired OptimalWeaponFinder optimalWeaponFinder,
                              @Autowired RandomNumberGeneratorService randomNumberGeneratorService,
                              @Autowired SimulationBattleExecutor simulationBattleExecutor) {
        super(GrandAdmiralBattle.class, optimalWeaponFinder, randomNumberGeneratorService, simulationBattleExecutor);
    }

    @Test
    void admiralsExam() throws IOException, URISyntaxException {
        exam("admirals.json", "grandAdmirals.json", "admirals.json", 40);
    }

    @Override
    protected int laureate() {
        return 1;
    }

    @Override
    protected ClassEnum getPromotion() {
        return ClassEnum.GRAND_ADMIRAL;
    }

    @Override
    protected int specialisationDifficulty() {
        return 1;
    }

    @Override
    protected int getMinimumDamage() {
        return 155;
    }

    @Override
    protected int getMaximumDamage() {
        return 175;
    }

    @Override
    protected String getWeaponName() {
        return "Celestial dragon";
    }

}
