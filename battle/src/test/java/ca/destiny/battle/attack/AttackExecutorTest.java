package ca.destiny.battle.attack;

import ca.destiny.fighter.BattleFighterDto;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
class AttackExecutorTest {

    @InjectMocks
    private AttackExecutor attackExecutor;

    @Test
    void miss() {
        AttackStatus status = attackExecutor.execute(new BattleFighterDto(), new BattleFighterDto());
        assertThat(status.hasMissed()).isTrue();
    }
}