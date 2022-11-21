package ca.destiny.v2.fighter;

public class FightingStatus {
    private boolean isAlive = true;
    private boolean isConscience = true;

    public void setAlive(boolean alive) {
        isAlive = alive;
    }

    public void setConscience(boolean conscience) {
        isConscience = conscience;
    }

    public boolean isAlive() {
        return isAlive;
    }

    public boolean isConscience() {
        return isConscience;
    }

    public boolean canFight() {
        return isAlive && isConscience;
    }
}
