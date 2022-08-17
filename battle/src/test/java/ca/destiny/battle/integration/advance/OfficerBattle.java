package ca.destiny.battle.integration.advance;

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
public class OfficerBattle extends Battle {

    public OfficerBattle(@Autowired OptimalWeaponFinder optimalWeaponFinder,
                         @Autowired RandomNumberGeneratorService randomNumberGeneratorService,
                         @Autowired SimulationBattleExecutor simulationBattleExecutor) {
        super(OfficerBattle.class, optimalWeaponFinder, randomNumberGeneratorService, simulationBattleExecutor);
    }

    @Test
    void officersExam() throws IOException, URISyntaxException {
        exam("warrantOfficers.json", "officers.json", "warrantOfficers.json", 30);
    }

    @Override
    protected int laureate() {
        return 250;
    }

    @Override
    protected ClassEnum getPromotion() {
        return ClassEnum.OFFICER;
    }

    @Override
    protected int specialisationDifficulty() {
        return 13;
    }

    @Override
    protected int getMinimumDamage() {
        return 45;
    }

    @Override
    protected int getMaximumDamage() {
        return 55;
    }

    @Override
    protected String getWeaponName() {
        return "Quality Cooper";
    }

}
