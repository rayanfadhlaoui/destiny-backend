package ca.destiny.battle.action;

import ca.destiny.fighter.BattleFighterDto;

public class DamageService {

    private final DefenseService defenseService;
    private final WeaponDamageService weaponDamageService;

    public DamageService() {
        this.defenseService = new DefenseService();
        this.weaponDamageService = new WeaponDamageService();
    }

    public Range getDamage(BattleFighterDto battleFighterDto, int defense) {
        var equipmentDto = battleFighterDto.getEquipmentDto();
        var battleInformation = battleFighterDto.getBattleInformation();
        var damageRange = weaponDamageService.getRange(equipmentDto.getRightWeapon(), battleInformation);

        int damageReduction = defenseService.getDamageReduction(defense);
        int minimumDamage = Math.max(1, damageRange.getLeft() - damageReduction);
        int maximumDamage = Math.max(2, damageRange.getRight() - damageReduction);
        return new Range(minimumDamage, maximumDamage);
    }
}
