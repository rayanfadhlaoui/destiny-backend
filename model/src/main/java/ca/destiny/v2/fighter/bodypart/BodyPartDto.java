package ca.destiny.v2.fighter.bodypart;

import ca.destiny.v2.fighter.injury.Injury;

import java.util.ArrayList;
import java.util.List;

public class BodyPartDto {

    private BodyPartType type;
    private List<Injury> injuries = new ArrayList<>();
    private int penalty = 0;

    public BodyPartType getType() {
        return type;
    }

    public void setType(BodyPartType type) {
        this.type = type;
    }

    public List<Injury> getInjuries() {
        return injuries;
    }

    public void setInjuries(List<Injury> injuries) {
        this.injuries = injuries;
    }

    public void addInjury(Injury injury) {
        injuries.add(injury);
        penalty += injury.getPenalty();
    }

    public int getPenalty() {
        return penalty;
    }

    public void setPenalty(int penalty) {
        this.penalty = penalty;
    }
}
