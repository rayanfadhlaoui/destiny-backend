package ca.destiny.battle.action;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

class DefenseServiceTest {

    private final DefenseService defenseService = new DefenseService();
    static Map<Integer, Integer> reductionByDefense = new HashMap<>();

    static {
        reductionByDefense.put(1, 1);
        reductionByDefense.put(10, 10);
        reductionByDefense.put(20, 60);
        reductionByDefense.put(30, 160);
        reductionByDefense.put(40, 360);
        reductionByDefense.put(50, 660);
        reductionByDefense.put(60, 1160);
        reductionByDefense.put(70, 1960);
        reductionByDefense.put(80, 3260);
        reductionByDefense.put(90, 5360);
        reductionByDefense.put(100, 8760);
        reductionByDefense.put(110, 14260);
        reductionByDefense.put(120, 23160);
        reductionByDefense.put(125, 30360);
        reductionByDefense.put(130, 37560);
        reductionByDefense.put(140, 60860);
        reductionByDefense.put(150, 98560);
        reductionByDefense.put(160, 159560);
        reductionByDefense.put(170, 258260);
        reductionByDefense.put(190, 676360);
        reductionByDefense.put(200, 1094460);
    }

    @Test
    public void givenIncreasingDexterity_ReturnValueFromMap() {
        reductionByDefense.forEach((key, value) -> {
            long t = System.currentTimeMillis();
            int damageReduction = defenseService.getDamageReduction(key);
            t = System.currentTimeMillis() - t;
            System.out.println(key + " " + t + "ms");
            assertThat(damageReduction).isEqualTo(value);
        });
    }
}