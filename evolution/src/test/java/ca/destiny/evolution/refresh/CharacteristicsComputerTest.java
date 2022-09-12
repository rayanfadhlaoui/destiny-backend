package ca.destiny.evolution.refresh;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CharacteristicsComputerTest {

    private final CharacteristicsComputer characteristicsComputer = new CharacteristicsComputer();

    @Test
    void test100() {
        int actual = characteristicsComputer.compute(20);
        assertThat(actual).isEqualTo(20);
        actual = characteristicsComputer.compute(99);
        assertThat(actual).isEqualTo(99);
        actual = characteristicsComputer.compute(100);
        assertThat(actual).isEqualTo(100);
    }

    @Test
    void test200() {
        int actual = characteristicsComputer.compute(200);
        assertThat(actual).isEqualTo(150);
        actual = characteristicsComputer.compute(300);
        assertThat(actual).isEqualTo(200);
    }

    @Test
    void test5500() {
        int actual = characteristicsComputer.compute(5500);
        assertThat(actual).isEqualTo(1166);
    }

    @Test
    void test6599() {
        int actual = characteristicsComputer.compute(6599);
        assertThat(actual).isEqualTo(1349);
    }

}