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
public class JuniorLieutenantBattle extends Battle {

    public JuniorLieutenantBattle(@Autowired OptimalWeaponFinder optimalWeaponFinder,
                                  @Autowired RandomNumberGeneratorService randomNumberGeneratorService,
                                  @Autowired SimulationBattleExecutor simulationBattleExecutor) {
        super(JuniorLieutenantBattle.class, optimalWeaponFinder, randomNumberGeneratorService, simulationBattleExecutor);
    }

    @Test
    void juniorLieutenantsExam() throws IOException, URISyntaxException {
        exam("officers.json", "juniorLieutenants.json", "officers.json", 30);
    }

    @Override
    protected int laureate() {
        return 150;
    }

    @Override
    protected ClassEnum getPromotion() {
        return ClassEnum.JUNIOR_LIEUTENANT;
    }

    @Override
    protected int specialisationDifficulty() {
        return 10;
    }

    @Override
    protected int getMinimumDamage() {
        return 55;
    }

    @Override
    protected int getMaximumDamage() {
        return 65;
    }

    @Override
    protected String getWeaponName() {
        return "Silver";
    }

}
