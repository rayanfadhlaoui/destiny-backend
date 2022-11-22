package ca.destiny.battle2;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class InitiativeResultPickerTest {

    @Test
    void comparePositive() {
        InitiativeResultPicker initiativeResultPicker = new InitiativeResultPicker();
        Integer pick = initiativeResultPicker.pick(true, List.of(1, 2, 3, 4, 5, 6));
        assertThat(pick).isEqualTo(6);
    }
    
    @Test
    void compareNegative() {
        InitiativeResultPicker initiativeResultPicker = new InitiativeResultPicker();
        Integer pick = initiativeResultPicker.pick(false, List.of(1, 2, 3, 4, 5, 6));
        assertThat(pick).isEqualTo(1);
    }

}