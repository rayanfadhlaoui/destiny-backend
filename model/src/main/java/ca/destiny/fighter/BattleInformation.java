package ca.destiny.fighter;

public class BattleInformation {
    private int vitality;
    private int dexterity;
    private int dodge;
    private int strength;
    private int defense;
    private int speed;

    public int getVitality() {
        return vitality;
    }

    public int getDexterity() {
        return dexterity;
    }

    public int getDodge() {
        return dodge;
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public void setDodge(int dodge) {
        this.dodge = dodge;
    }

    public void setVitality(int vitality) {
        this.vitality = vitality;
    }

    public void setDexterity(int dexterity) {
        this.dexterity = dexterity;
    }

    public void setDefense(int defense) {
        this.defense = defense;
    }

    public int getDefense() {
        return defense;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }
}
