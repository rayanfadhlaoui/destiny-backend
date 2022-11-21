package ca.destiny.v2.fighter.injury;

import com.fasterxml.jackson.annotation.JsonTypeName;

@JsonTypeName("MinorFractureInjury")
public class MinorFractureInjury extends Injury {
    public MinorFractureInjury() {

    }
    public MinorFractureInjury(int deathProbability, int lastingDays) {
        super(deathProbability, lastingDays);
    }

    @Override
    public String getName() {
        return "Minor fracture";
    }

    @Override
    public int getPain() {
        return 40;
    }

    @Override
    public int getPenalty() {
        return 30;
    }
}
