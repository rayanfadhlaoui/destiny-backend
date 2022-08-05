package ca.destiny.battle.action;

import ca.destiny.fighter.BattleFighterDto;
import ca.destiny.fighter.BattleInformation;
import ca.destiny.fighter.equipment.EquipmentDto;
import ca.destiny.fighter.equipment.weapon.AbilityWeight;
import ca.destiny.fighter.equipment.weapon.FistDto;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class DamageServiceTest {

    private final DamageService damageService = new DamageService();
    private final Range damageRange = new Range(1000, 10000);

    @Test
    void damageDef10() {
        Range damage = damageService.getDamage(createBattleFighterDto(10), 10);
        assertThat(damage.getLeft()).isEqualTo(13);
        assertThat(damage.getRight()).isEqualTo(27);

        damage = damageService.getDamage(createBattleFighterDto(20), 10);
        assertThat(damage.getLeft()).isEqualTo(17);
        assertThat(damage.getRight()).isEqualTo(35);


        damage = damageService.getDamage(createBattleFighterDto(30), 10);
        assertThat(damage.getLeft()).isEqualTo(21);
        assertThat(damage.getRight()).isEqualTo(43);


        damage = damageService.getDamage(createBattleFighterDto(130), 10);
        assertThat(damage.getLeft()).isEqualTo(61);
        assertThat(damage.getRight()).isEqualTo(123);
    }

    @Test
    void damageDef60() {
        Range damage = damageService.getDamage(createBattleFighterDto(10), 60);
        assertThat(damage.getLeft()).isEqualTo(7);
        assertThat(damage.getRight()).isEqualTo(21);
    }

    @Test
    void damageDef110() {
        Range damage = damageService.getDamage(createBattleFighterDto(10), 110);
        assertThat(damage.getLeft()).isEqualTo(1);
        assertThat(damage.getRight()).isEqualTo(1);
    }

    private BattleFighterDto createBattleFighterDto(int characteristic) {
        BattleFighterDto battleFighterDto = new BattleFighterDto();
        EquipmentDto equipmentDto = new EquipmentDto();
        FistDto rightWeapon = new FistDto();
        AbilityWeight abilityWeight = new AbilityWeight();
        abilityWeight.setSpeed(33);
        abilityWeight.setDexterity(33);
        abilityWeight.setStrength(34);
        rightWeapon.setAbilityWeight(abilityWeight);
        rightWeapon.setMinimumDamage(10);
        rightWeapon.setMaximumDamage(20);
        equipmentDto.setRightWeapon(rightWeapon);
        battleFighterDto.setEquipmentDto(equipmentDto);
        BattleInformation battleInformation = new BattleInformation();
        battleInformation.setSpeed(characteristic);
        battleInformation.setStrength(characteristic);
        battleInformation.setDexterity(characteristic);
        battleFighterDto.setBattleInformation(battleInformation);
        return battleFighterDto;
    }

}