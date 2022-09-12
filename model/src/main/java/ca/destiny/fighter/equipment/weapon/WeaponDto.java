package ca.destiny.fighter.equipment.weapon;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME)
@JsonSubTypes({
        @JsonSubTypes.Type(SwordDto.class),
        @JsonSubTypes.Type(AxeDto.class),
        @JsonSubTypes.Type(FistDto.class),
        @JsonSubTypes.Type(DaggerDto.class)})
public abstract class WeaponDto {

    private String name;
    private AbilityBonus abilityBonus;
    private int minimumDamage;
    private int staminaNeeded;
    private int maximumDamage;
    private int penetration;
    private int blunt;
    private int minimumDexterity = -1;
    private int optimalDexterity = -1;

    public abstract WeaponType getWeaponType();

    public abstract AbilityWeight getAbilityWeight();

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

    public AbilityBonus getAbilityBonus() {
        return abilityBonus;
    }

    public void setAbilityBonus(AbilityBonus abilityBonus) {
        this.abilityBonus = abilityBonus;
    }

    public int getStaminaNeeded() {
        return staminaNeeded;
    }

    public void setStaminaNeeded(int staminaNeeded) {
        this.staminaNeeded = staminaNeeded;
    }

    public int getMinimumDexterity() {
        return minimumDexterity;
    }

    public int getOptimalDexterity() {
        return optimalDexterity;
    }

    public void setMinimumDexterity(int minimumDexterity) {
        this.minimumDexterity = minimumDexterity;
    }

    public void setOptimalDexterity(int optimalDexterity) {
        this.optimalDexterity = optimalDexterity;
    }
}
