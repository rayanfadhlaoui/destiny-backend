package ca.destiny.v2.fighter;

public class BattleInformation {
    private int vitality;
    private int dexterity;
    private int dodge;
    private int strength;
    private int resistance;
    private int defense;
    private int courage;
    private int speed;
    private int stamina;
    private FightingStatus fightingStatus = new FightingStatus();
    private Penalty penalty;

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

    public int getResistance() {
        return resistance;
    }

    public void setResistance(int resistance) {
        this.resistance = resistance;
    }

    public int getCourage() {
        return courage;
    }

    public void setCourage(int courage) {
        this.courage = courage;
    }

    public FightingStatus getFightingStatus() {
        return fightingStatus;
    }

    public void setFightingStatus(FightingStatus fightingStatus) {
        this.fightingStatus = fightingStatus;
    }


    public Penalty getPenalty() {
        return penalty;
    }

    public void setPenalty(Penalty penalty) {
        this.penalty = penalty;
    }

    public int getStamina() {
        return stamina;
    }

    public void setStamina(int stamina) {
        this.stamina = stamina;
    }
}
