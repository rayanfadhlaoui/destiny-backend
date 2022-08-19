package ca.destiny.fighter.injury;

import com.fasterxml.jackson.annotation.JsonTypeName;

@JsonTypeName("BrokenBoneInjury")
public class BrokenBoneInjury extends Injury {
    public BrokenBoneInjury() {
    }

    public BrokenBoneInjury(int deathProbability, int lastingDays) {
        super(deathProbability, lastingDays);
    }

    @Override
    public String getName() {
        return "Broken";
    }

    @Override
    public int getPain() {
        return 100;
    }
}
