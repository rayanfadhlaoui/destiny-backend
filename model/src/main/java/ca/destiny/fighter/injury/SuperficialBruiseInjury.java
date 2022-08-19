package ca.destiny.fighter.injury;

import com.fasterxml.jackson.annotation.JsonTypeName;

@JsonTypeName("SuperficialBruiseInjury")
public class SuperficialBruiseInjury extends Injury {

    public SuperficialBruiseInjury() {

    }
    public SuperficialBruiseInjury(int deathProbability, int lastingDays) {
        super(deathProbability, lastingDays);
    }

    @Override
    public String getName() {
        return "Superficial Bruise";
    }

    @Override
    public int getPain() {
        return 1;
    }
}
