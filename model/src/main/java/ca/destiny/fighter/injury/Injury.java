package ca.destiny.fighter.injury;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME)
@JsonSubTypes({
        @JsonSubTypes.Type(BrokenBoneInjury.class),
        @JsonSubTypes.Type(DislocationInjury.class),
        @JsonSubTypes.Type(SevereFractureInjury.class),
        @JsonSubTypes.Type(MinorFractureInjury.class),
        @JsonSubTypes.Type(SevereBruiseInjury.class),
        @JsonSubTypes.Type(MinorBruiseInjury.class),
        @JsonSubTypes.Type(SuperficialBruiseInjury.class),
})
public abstract class Injury {

    private int deathProbability;
    private int lastingDays;

    protected Injury() {
    }

    protected Injury(int deathProbability, int lastingDays) {
        this.deathProbability = deathProbability;
        this.lastingDays = lastingDays;
    }

    public abstract String getName();

    public abstract int getPain();

    public int getDeathProbability() {
        return deathProbability;
    }

    public void setDeathProbability(int deathProbability) {
        this.deathProbability = deathProbability;
    }

    public int getLastingDays() {
        return lastingDays;
    }

    public void setLastingDays(int lastingDays) {
        this.lastingDays = lastingDays;
    }

    public abstract int getPenalty();
}
