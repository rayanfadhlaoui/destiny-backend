package ca.destiny.v2.fighter.injury;

import com.fasterxml.jackson.annotation.JsonTypeName;

@JsonTypeName("SevereBruiseInjury")
public class SevereBruiseInjury extends Injury {
    public SevereBruiseInjury() {

    }

    public SevereBruiseInjury(int deathProbability, int lastingDays) {
        super(deathProbability, lastingDays);
    }

    @Override
    public String getName() {
        return "Severe bruise";
    }

    @Override
    public int getPain() {
        return 10;
    }

    @Override
    public int getPenalty() {
        return 15;
    }
}
