package ca.destiny.battle.action;

import ca.destiny.fighter.equipment.weapon.WeaponDto;
import ca.destiny.other.RandomNumberGeneratorService;

public class HitService {

    private final RandomNumberGeneratorService randomNumberGeneratorService;
    private final DodgePercentageComputer dodgePercentageComputer;

    public HitService(RandomNumberGeneratorService randomNumberGeneratorService) {
        this.randomNumberGeneratorService = randomNumberGeneratorService;
        this.dodgePercentageComputer = new DodgePercentageComputer();
    }


    public int hitPercentage(int dexterity, int dodge, WeaponDto weaponDto) {
        int dexterityPercentage = Math.min(600, getDexterityScore(weaponDto, dexterity));

        int dodgePercentage = dodgePercentageComputer.compute(dexterity - dodge);
        return dexterityPercentage + dodgePercentage;
    }

    private int getDexterityScore(WeaponDto weaponDto, int dexterity) {
        int dexterityScore = randomNumberGeneratorService.getRandomNumberInts(weaponDto.getMinimumDexterity(), dexterity);

        double percentage = (dexterityScore * 1.00 / weaponDto.getOptimalDexterity());
        return (int) (percentage * 600);
    }
}
