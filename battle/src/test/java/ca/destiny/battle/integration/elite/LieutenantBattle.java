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
public class LieutenantBattle extends Battle {

    public LieutenantBattle(@Autowired OptimalWeaponFinder optimalWeaponFinder,
                            @Autowired RandomNumberGeneratorService randomNumberGeneratorService,
                            @Autowired SimulationBattleExecutor simulationBattleExecutor) {
        super(LieutenantBattle.class, optimalWeaponFinder, randomNumberGeneratorService, simulationBattleExecutor);
    }

    @Test
    void lieutenantsExam() throws IOException, URISyntaxException {
        exam("juniorLieutenants.json", "lieutenants.json", "juniorLieutenants.json", 30);
    }

    @Override
    protected int laureate() {
        return 100;
    }

    @Override
    protected ClassEnum getPromotion() {
        return ClassEnum.LIEUTENANT;
    }

    @Override
    protected int specialisationDifficulty() {
        return 8;
    }

    @Override
    protected int getMinimumDamage() {
        return 65;
    }

    @Override
    protected int getMaximumDamage() {
        return 75;
    }

    @Override
    protected String getWeaponName() {
        return "Quality Silver";
    }

}
