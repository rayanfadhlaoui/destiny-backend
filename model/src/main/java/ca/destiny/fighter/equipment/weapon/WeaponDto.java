package ca.destiny.fighter.equipment.weapon;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonTypeInfo(use = JsonTypeInfo.Id.DEDUCTION)
@JsonSubTypes({
        @JsonSubTypes.Type(SwordDto.class)}
)
public abstract class WeaponDto {

    private String name;
    private AbilityWeight abilityWeight;
    private int minimumDamage;
    private int maximumDamage;
    private int penetration;
    private int blunt;

    public abstract WeaponType getWeaponType();

    public AbilityWeight getAbilityWeight() {
        return abilityWeight;
    }

    public void setAbilityWeight(AbilityWeight abilityWeight) {
        this.abilityWeight = abilityWeight;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMinimumDamage() {
        return minimumDamage;
    }

    public void setMinimumDamage(int minimumDamage) {
        this.minimumDamage = minimumDamage;
    }

    public int getMaximumDamage() {
        return maximumDamage;
    }

    public void setMaximumDamage(int maximumDamage) {
        this.maximumDamage = maximumDamage;
    }

    public int getPenetration() {
        return penetration;
    }

    public void setPenetration(int penetration) {
        this.penetration = penetration;
    }

    public int getBlunt() {
        return blunt;
    }

    public void setBlunt(int blunt) {
        this.blunt = blunt;
    }
}
