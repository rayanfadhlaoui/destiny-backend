package ca.destiny.evolution.enhancer;

import ca.destiny.fighter.CharacteristicsDto;

public abstract class CharacteristicsEnhancer {
    protected Integer strength = 0;
    protected Integer speed = 0;
    protected Integer dexterity = 0;
    protected Integer defense = 0;
    protected Integer vitality = 0;
    protected Integer courage = 0;
    protected Integer dodge = 0;
    protected Integer stamina = 0;

    public void improve(CharacteristicsDto characteristics) {
        int courage = characteristics.getCourage() + this.courage;
        int strength = characteristics.getStrength() + this.strength;
        int speed = characteristics.getSpeed() + this.speed;
        int dexterity = characteristics.getDexterity() + this.dexterity;
        int defense = characteristics.getDefense() + this.defense;
        int vitality = characteristics.getVitality() + this.vitality;
        int dodge = characteristics.getDodge() + this.dodge;
        int stamina = characteristics.getStamina() + this.stamina;

        characteristics.setCourage(courage);
        characteristics.setStrength(strength);
        characteristics.setSpeed(speed);
        characteristics.setDexterity(dexterity);
        characteristics.setDefense(defense);
        characteristics.setVitality(vitality);
        characteristics.setDodge(dodge);
        characteristics.setStamina(stamina);
    }
}
