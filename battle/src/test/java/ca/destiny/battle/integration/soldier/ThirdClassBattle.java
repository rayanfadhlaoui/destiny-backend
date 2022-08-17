package ca.destiny.battle.integration.soldier;

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
public class ThirdClassBattle extends Battle {

    public ThirdClassBattle(@Autowired OptimalWeaponFinder optimalWeaponFinder,
                            @Autowired RandomNumberGeneratorService randomNumberGeneratorService,
                            @Autowired SimulationBattleExecutor simulationBattleExecutor) {
        super(ThirdClassBattle.class, optimalWeaponFinder, randomNumberGeneratorService, simulationBattleExecutor);
    }

    @Test
    void thirdClassesExam() throws IOException, URISyntaxException {
        exam("apprentices.json", "thirdClasses.json", "apprentices.json", 30);
    }

    @Override
    protected int laureate() {
        return 10000;
    }

    @Override
    protected ClassEnum getPromotion() {
        return ClassEnum.THIRD_CLASS;
    }

    @Override
    protected int specialisationDifficulty() {
        return 75;
    }

    @Override
    protected int getMinimumDamage() {
        return 10;
    }

    @Override
    protected int getMaximumDamage() {
        return 15;
    }

    @Override
    protected String getWeaponName() {
        return "Quality Wood";
    }

}
