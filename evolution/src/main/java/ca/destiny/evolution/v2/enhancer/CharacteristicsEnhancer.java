package ca.destiny.evolution.v2.enhancer;

import ca.destiny.fighter.CharacteristicsDto;
import ca.destiny.other.RandomNumberGeneratorService;

public abstract class CharacteristicsEnhancer {
    private final RandomNumberGeneratorService randomNumberGeneratorService;
    protected Integer strength = 0;
    protected Integer speed = 0;
    protected Integer dexterity = 0;
    protected Integer defense = 0;
    protected Integer vitality = 0;
    protected Integer courage = 0;
    protected Integer dodge = 0;
    protected Integer resistance = 0;
    protected Integer stamina = 0;

    protected CharacteristicsEnhancer(RandomNumberGeneratorService randomNumberGeneratorService) {
        this.randomNumberGeneratorService = randomNumberGeneratorService;
    }

    public void improve(CharacteristicsDto characteristics) {
        int courage = improve(characteristics.getCourage(), this.courage);
        int strength = improve(characteristics.getStrength(), this.strength);
        int speed = improve(characteristics.getSpeed(), this.speed);
        int dexterity = improve(characteristics.getDexterity(), this.dexterity);
        int resistance = improve(characteristics.getResistance(), this.resistance);
        int defense = improve(characteristics.getDefense(), this.defense);
        int vitality = improve(characteristics.getVitality(), this.vitality);
        int dodge = improve(characteristics.getDodge(), this.dodge);
        int stamina = improve(characteristics.getStamina(), this.stamina);

        characteristics.setCourage(courage);
        characteristics.setStrength(strength);
        characteristics.setSpeed(speed);
        characteristics.setResistance(resistance);
        characteristics.setDexterity(dexterity);
        characteristics.setDefense(defense);
        characteristics.setVitality(vitality);
        characteristics.setDodge(dodge);
        characteristics.setStamina(stamina);
    }

    private int improve(Integer current, Integer improvement) {
        return current + randomNumberGeneratorService.getRandomNumberInts(0, improvement);
    }
}
