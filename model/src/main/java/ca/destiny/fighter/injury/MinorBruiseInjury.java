package ca.destiny.fighter.injury;

import com.fasterxml.jackson.annotation.JsonTypeName;

@JsonTypeName("MinorBruiseInjury")
public class MinorBruiseInjury extends Injury {
    public MinorBruiseInjury() {
    }

    public MinorBruiseInjury(int deathProbability, int lastingDays) {
        super(deathProbability, lastingDays);
    }

    @Override
    public String getName() {
        return "Minor bruise";
    }

    @Override
    public int getPain() {
        return 5;
    }

    @Override
    public int getPenalty() {
        return 10;
    }
}
