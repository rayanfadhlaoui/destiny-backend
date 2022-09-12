package ca.destiny.battle.action;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class DodgePercentageComputerTest {

    private final DodgePercentageComputer dodgePercentageComputer = new DodgePercentageComputer();

    @Test
    void computeMaximum() {
        int result = dodgePercentageComputer.compute(250);
        assertThat(result).isEqualTo(400);
    }

    @Test
    void compute200() {
        int result = dodgePercentageComputer.compute(200);
        assertThat(result).isEqualTo(340);
    }

    @Test
    void compute100() {
        int result = dodgePercentageComputer.compute(100);
        assertThat(result).isEqualTo(220);
    }

    @Test
    void compute0() {
        int result = dodgePercentageComputer.compute(0);
        assertThat(result).isEqualTo(100);
    }

    @Test
    void computeNegative50() {
        int result = dodgePercentageComputer.compute(-50);
        assertThat(result).isEqualTo(50);
    }

    @Test
    void computeNegative100() {
        int result = dodgePercentageComputer.compute(-100);
        assertThat(result).isEqualTo(0);
    }

    @Test
    void computeNegative200() {
        int result = dodgePercentageComputer.compute(-200);
        assertThat(result).isEqualTo(0);
    }
}