package ca.destiny.battle2.integration;

import ca.destiny.ApplicationTest;
import ca.destiny.battle2.Duel;
import ca.destiny.battle2.DuelExecutor;
import ca.destiny.battle2.Fighter;
import ca.destiny.battle2.FighterFactoryV2;
import ca.destiny.destinytest.AbstractIntegration;
import ca.destiny.v2.person.common.RaceEnum;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.HashMap;
import java.util.Map;


@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK, classes = ApplicationTest.class)
public class DuelTest extends AbstractIntegration {

    @Autowired
    private DuelExecutor duelExecutor;

    @Autowired
    private FighterFactoryV2 fighterFactoryV2;

    private final Map<RaceEnum, Integer> score = new HashMap<>();

    public DuelTest() {
        super(DuelTest.class);
    }

    @Test
    @Disabled
    void simulate3000Fight() {
        Fighter human = fighterFactoryV2.create(RaceEnum.HUMAN);
        Fighter orc = fighterFactoryV2.create(RaceEnum.ORC);
        Fighter elf = fighterFactoryV2.create(RaceEnum.ELF);
        Fighter dwarf = fighterFactoryV2.create(RaceEnum.DWARF);

        long t0 = System.currentTimeMillis();
        simulate(human, orc);
        simulate(human, elf);
        simulate(human, dwarf);

        simulate(orc, human);
        simulate(orc, dwarf);
        simulate(orc, elf);

        simulate(dwarf, human);
        simulate(dwarf, orc);
        simulate(dwarf, elf);

        simulate(elf, human);
        simulate(elf, orc);
        simulate(elf, dwarf);

        System.out.println(System.currentTimeMillis() - t0 + " ms");
        System.out.println("Human :" + score.get(RaceEnum.HUMAN));
        System.out.println("Dwarf :" + score.get(RaceEnum.DWARF));
        System.out.println("Orc :" + score.get(RaceEnum.ORC));
        System.out.println("Elf :" + score.get(RaceEnum.ELF));
    }

    private void simulate(Fighter aggressor, Fighter defender) {
        for (int i = 0; i < 250; i++) {
            Duel duel = new Duel(aggressor, defender);
            while (!duel.isOver()) {
                duelExecutor.execute(duel);
            }
            aggressor.getCharacteristics().resetVitality();
            RaceEnum raceEnum = duel.getAggressor().getRaceEnum();
            score.putIfAbsent(raceEnum, 0);
            score.computeIfPresent(raceEnum, (r, s) -> s + 1);
        }
    }

}
