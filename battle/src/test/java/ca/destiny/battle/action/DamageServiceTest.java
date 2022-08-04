package ca.destiny.battle.action;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class DamageServiceTest {

    private final DamageService damageService = new DamageService();
    private final Range damageRange = new Range(1000, 10000);

    @Test
    void damageDef10() {
        Range damage = damageService.getDamage(damageRange, 10);
        assertThat(damage.getLeft()).isEqualTo(990);
        assertThat(damage.getRight()).isEqualTo(9990);
    }

    @Test
    void damageDef60() {
        Range damage = damageService.getDamage(damageRange, 60);
        assertThat(damage.getLeft()).isEqualTo(1);
        assertThat(damage.getRight()).isEqualTo(8840);
    }

    @Test
    void damageDef110() {
        Range damage = damageService.getDamage(damageRange, 110);
        assertThat(damage.getLeft()).isEqualTo(1);
        assertThat(damage.getRight()).isEqualTo(2);
    }
}