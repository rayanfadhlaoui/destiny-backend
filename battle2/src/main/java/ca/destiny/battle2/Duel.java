package ca.destiny.battle2;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Duel {
    private Fighter aggressor;
    private Fighter defender;
    private boolean isOver;

    public Duel(Fighter aggressor, Fighter defender) {
        this.aggressor = aggressor;
        this.defender = defender;
        this.isOver = false;
    }

    public void flipFighter() {
        Fighter tmp = aggressor;
        aggressor = defender;
        defender = tmp;
    }
}
