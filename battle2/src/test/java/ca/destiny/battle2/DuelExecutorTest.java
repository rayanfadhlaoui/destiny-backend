package ca.destiny.battle2;

import ca.destiny.battle2.factory.dice.AccuracyDices;
import ca.destiny.battle2.factory.dice.DamageDices;
import ca.destiny.battle2.factory.dice.DiceFactory;
import ca.destiny.v2.person.common.RaceEnum;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
class DuelExecutorTest {

    @InjectMocks
    private DuelExecutor duelExecutor;

    @Mock
    private DiceFactory diceFactory;
    @Mock
    private AccuracyDices accuracyDices;
    @Mock
    private DamageDices damageDices;

    @Mock
    private Action action;

    @Test
    void execution() {
        given(diceFactory.getAccuracyDices(3, 3)).willReturn(accuracyDices);
//        given(accuracyDices.getAction()).willReturn(action);
        given(diceFactory.getDamageDices(3, 3)).willReturn(damageDices);
        var aggressor = createFighter();
        var defender = createFighter();
        var duel = new Duel(aggressor, defender);
        duelExecutor.execute(duel);
        var healthStatus = defender.getHealthStatus();
        assertThat(healthStatus.getStatus()).isEqualTo(Status.KNOCKOUT);
    }

    private static Fighter createFighter() {
        return new Fighter(new Characteristics(3, 3, 3, 3, 3, 1, 1), new HealthStatus(Status.AWARE), RaceEnum.ELF);
    }
}