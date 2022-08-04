package ca.destiny.battle.action;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
class HitServiceTest {

    private final HitService hitService = new HitService();
    static Map<Integer, Integer> percentageByValue = new HashMap<>();

    static {
        percentageByValue.put(-20, 0);
        percentageByValue.put(-19, 2);
        percentageByValue.put(-18, 4);
        percentageByValue.put(-17, 6);
        percentageByValue.put(-16, 8);
        percentageByValue.put(-15, 10);
        percentageByValue.put(-14, 13);
        percentageByValue.put(-13, 16);
        percentageByValue.put(-12, 19);
        percentageByValue.put(-11, 22);
        percentageByValue.put(-10, 25);
        percentageByValue.put(-9, 29);
        percentageByValue.put(-8, 33);
        percentageByValue.put(-7, 37);
        percentageByValue.put(-6, 41);
        percentageByValue.put(-5, 46);
        percentageByValue.put(-4, 50);
        percentageByValue.put(-3, 53);
        percentageByValue.put(-2, 59);
        percentageByValue.put(-1, 64);
        percentageByValue.put(0, 65);
        percentageByValue.put(1, 67);
        percentageByValue.put(2, 69);
        percentageByValue.put(3, 71);
        percentageByValue.put(4, 73);
        percentageByValue.put(5, 75);
        percentageByValue.put(6, 77);
        percentageByValue.put(7, 79);
        percentageByValue.put(8, 81);
        percentageByValue.put(9, 83);
        percentageByValue.put(10, 85);
        percentageByValue.put(11, 87);
        percentageByValue.put(12, 89);
        percentageByValue.put(13, 91);
        percentageByValue.put(14, 92);
        percentageByValue.put(15, 93);
        percentageByValue.put(16, 94);
        percentageByValue.put(17, 96);
        percentageByValue.put(18, 98);
        percentageByValue.put(19, 99);
        percentageByValue.put(20, 100);
    }

    @Test
    public void givenIncreasingDexterity_ReturnValueFromMap() {
        for (int dexterity = 0; dexterity <= 20; dexterity++) {
            int result = hitService.hitPercentage(dexterity, 0);
            assertThat(result).isEqualTo(percentageByValue.get(dexterity));
        }
        int result = hitService.hitPercentage(50, 0);
        assertThat(result).isEqualTo(100);
    }

    @Test
    public void givenIncreasingDodge_ReturnValueFromMap() {
        for (int dodge = 0; dodge <= 20; dodge++) {
            int result = hitService.hitPercentage(0, dodge);
            assertThat(result).isEqualTo(percentageByValue.get(-dodge));
        }
        int result = hitService.hitPercentage(0, 50);
        assertThat(result).isEqualTo(0);
    }

}