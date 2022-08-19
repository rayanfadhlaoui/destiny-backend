package ca.destiny.fighter.injury;

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
}
