package ca.destiny.v2.fighter.equipment;

import ca.destiny.v2.fighter.equipment.weapon.WeaponDto;

public class EquipmentDto {
    private WeaponDto rightWeapon;

    public WeaponDto getRightWeapon() {
        return rightWeapon;
    }

    public void setRightWeapon(WeaponDto rightWeapon) {
        this.rightWeapon = rightWeapon;
    }
}
