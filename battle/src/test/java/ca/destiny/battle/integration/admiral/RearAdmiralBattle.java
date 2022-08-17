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
public class RearAdmiralBattle extends Battle {

    public RearAdmiralBattle(@Autowired OptimalWeaponFinder optimalWeaponFinder,
                             @Autowired RandomNumberGeneratorService randomNumberGeneratorService,
                             @Autowired SimulationBattleExecutor simulationBattleExecutor) {
        super(RearAdmiralBattle.class, optimalWeaponFinder, randomNumberGeneratorService, simulationBattleExecutor);
    }

    @Test
    void rearAdmiralsExam() throws IOException, URISyntaxException {
        exam("colonels.json", "rearAdmirals.json", "colonels.json", 40);
    }

    @Override
    protected int laureate() {
        return 18;
    }

    @Override
    protected ClassEnum getPromotion() {
        return ClassEnum.REAR_ADMIRAL;
    }

    @Override
    protected int specialisationDifficulty() {
        return 4;
    }

    @Override
    protected int getMinimumDamage() {
        return 105;
    }

    @Override
    protected int getMaximumDamage() {
        return 115;
    }

    @Override
    protected String getWeaponName() {
        return "Quality Rubis";
    }

}
