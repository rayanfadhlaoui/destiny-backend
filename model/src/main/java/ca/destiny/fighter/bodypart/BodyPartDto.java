package ca.destiny.fighter.bodypart;

import java.util.ArrayList;
import java.util.List;

public class BodyPartDto {

    private BodyPartType type;
    private List<Injury> injuries = new ArrayList<>();

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
    }
}
