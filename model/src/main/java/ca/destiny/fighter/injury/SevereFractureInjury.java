package ca.destiny.fighter.injury;

import com.fasterxml.jackson.annotation.JsonTypeName;

@JsonTypeName("SevereFractureInjury")
public class SevereFractureInjury extends Injury {
    public SevereFractureInjury() {

    }
    public SevereFractureInjury(int deathProbability, int lastingDays) {
        super(deathProbability, lastingDays);
    }

    @Override
    public String getName() {
        return "Severe fracture";
    }

    @Override
    public int getPain() {
        return 75;
    }
}
