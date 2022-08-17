package ca.destiny.battle.integration.elite;

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
public class ColonelBattle extends Battle {

    public ColonelBattle(@Autowired OptimalWeaponFinder optimalWeaponFinder,
                         @Autowired RandomNumberGeneratorService randomNumberGeneratorService,
                         @Autowired SimulationBattleExecutor simulationBattleExecutor) {
        super(ColonelBattle.class, optimalWeaponFinder, randomNumberGeneratorService, simulationBattleExecutor);
    }

    @Test
    void colonelExam() throws IOException, URISyntaxException {
        exam("mayors.json", "colonels.json", "mayors.json", 40);
    }

    @Override
    protected int laureate() {
        return 30;
    }

    @Override
    protected ClassEnum getPromotion() {
        return ClassEnum.COLONEL;
    }

    @Override
    protected int specialisationDifficulty() {
        return 5;
    }

    @Override
    protected int getMinimumDamage() {
        return 95;
    }

    @Override
    protected int getMaximumDamage() {
        return 105;
    }

    @Override
    protected String getWeaponName() {
        return "Rubis";
    }

}
