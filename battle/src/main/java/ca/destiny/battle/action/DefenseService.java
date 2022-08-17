package ca.destiny.battle.action;

public class DefenseService {

    public int getDamageReduction(Integer defense) {
        return defense / 10 + defense;
    }
}
