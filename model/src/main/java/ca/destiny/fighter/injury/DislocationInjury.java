package ca.destiny.fighter.injury;

import com.fasterxml.jackson.annotation.JsonTypeName;

@JsonTypeName("DislocationInjury")
public class DislocationInjury extends Injury {
    public DislocationInjury() {

    }

    public DislocationInjury(int deathProbability, int lastingDays) {
        super(deathProbability, lastingDays);
    }

    @Override
    public String getName() {
        return "Dislocation";
    }

    @Override
    public int getPain() {
        return 75;
    }
}
