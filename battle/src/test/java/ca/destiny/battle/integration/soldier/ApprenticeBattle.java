package ca.destiny.battle.integration.soldier;

import ca.destiny.ApplicationTest;
import ca.destiny.battle.integration.Battle;
import ca.destiny.battle.integration.BattleConfiguration;
import ca.destiny.battle.simulation.SimulationBattleExecutor;
import ca.destiny.evolution.creation.FighterFactory;
import ca.destiny.evolution.creation.PersonFactory;
import ca.destiny.fighter.BattleFighterDto;
import ca.destiny.fighter.ClassEnum;
import ca.destiny.game.GameInformationService;
import ca.destiny.other.RandomNumberGeneratorService;
import ca.destiny.person.common.DestinyDate;
import ca.destiny.person.common.RaceEnum;
import ca.destiny.weapon.behavior.OptimalWeaponFinder;
import com.fasterxml.jackson.core.type.TypeReference;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.BDDMockito.given;

@ExtendWith(SpringExtension.class)
@Import(BattleConfiguration.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK, classes = ApplicationTest.class)
public class ApprenticeBattle extends Battle {

    public static final long GAME_ID = 1L;

    @Autowired
    private PersonFactory personFactory;
    @Autowired
    private FighterFactory fighterFactory;

    @Autowired
    private GameInformationService gameInformationServiceMock;

    public ApprenticeBattle(@Autowired OptimalWeaponFinder optimalWeaponFinder,
                            @Autowired RandomNumberGeneratorService randomNumberGeneratorService,
                            @Autowired SimulationBattleExecutor simulationBattleExecutor) {
        super(ApprenticeBattle.class, optimalWeaponFinder, randomNumberGeneratorService, simulationBattleExecutor);
    }


    @Test
    void apprenticeExam_WithNew() throws IOException, URISyntaxException {
        List<BattleFighterDto> battleFighters = create(5000);
        List<BattleFighterDto> old = loadListFromFile("noClassFighters.json", new TypeReference<>() {
        });
        battleFighters.addAll(old);
        exam(battleFighters, "apprentices.json", "noClassFighters.json", 200);
    }

    @Test
    void apprenticeExam_WithOld() throws IOException, URISyntaxException {

        exam("noClassFighters.json", "apprentices.json", "noClassFighters.json", 200);
    }

    List<BattleFighterDto> create(int size) {
        var destinyDate = createDestinyDate();
        given(gameInformationServiceMock.getCurrentDate(GAME_ID)).willReturn(destinyDate);
        List<BattleFighterDto> fighters = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            var personDto = personFactory.create(RaceEnum.HUMAN, 1L);
            var fighter = fighterFactory.create(personDto, 1L);
            fighters.add(fighter);
        }

        return fighters;
    }

    private DestinyDate createDestinyDate() {
        var destinyDate = new DestinyDate();
        destinyDate.setDay(1);
        destinyDate.setMonth(1);
        destinyDate.setYear(1);
        return destinyDate;
    }

    @Override
    protected int laureate() {
        return 1000;
    }

    @Override
    protected ClassEnum getPromotion() {
        return ClassEnum.APPRENTICE;
    }

    @Override
    protected int specialisationDifficulty() {
        return 100;
    }

    @Override
    protected int getMinimumDamage() {
        return 5;
    }

    @Override
    protected int getMaximumDamage() {
        return 10;
    }

    @Override
    protected String getWeaponName() {
        return "Wood";
    }

}
