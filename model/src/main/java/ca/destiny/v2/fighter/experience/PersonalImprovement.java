package ca.destiny.v2.fighter.experience;

public class PersonalImprovement {
    private int strength = 0;
    private int speed = 0;
    private int dexterity = 0;
    private int defense = 0;
    private int vitality = 0;
    private int courage = 0;
    private int dodge = 0;
    private int resistance = 0;
    private int stamina = 0;

    public PersonalImprovement(int param) {
        strength = param;
        speed = param;
        dexterity = param;
        defense = param;
        vitality = param*2;
        courage = param;
        dodge = param;
        resistance = param;
        stamina = param;
    }

    public PersonalImprovement() {

    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public void setDexterity(int dexterity) {
        this.dexterity = dexterity;
    }

    public void setDefense(int defense) {
        this.defense = defense;
    }

    public void setVitality(int vitality) {
        this.vitality = vitality;
    }

    public void setCourage(int courage) {
        this.courage = courage;
    }

    public void setDodge(int dodge) {
        this.dodge = dodge;
    }

    public void setResistance(int resistance) {
        this.resistance = resistance;
    }

    public void setStamina(int stamina) {
        this.stamina = stamina;
    }

    public int getSpeed() {
        return speed;
    }

    public int getDexterity() {
        return dexterity;
    }

    public int getDefense() {
        return defense;
    }

    public int getVitality() {
        return vitality;
    }

    public int getCourage() {
        return courage;
    }

    public int getDodge() {
        return dodge;
    }

    public int getResistance() {
        return resistance;
    }

    public int getStamina() {
        return stamina;
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }
}
