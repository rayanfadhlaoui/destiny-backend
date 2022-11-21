package ca.destiny.v2.fighter;

import ca.destiny.v2.fighter.equipment.EquipmentDto;
import ca.destiny.v2.fighter.experience.ExperienceDto;
import ca.destiny.v2.person.PersonDto;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class BattleFighterDto {
    private long id;
    private long idMainUser;
    private PersonDto person;
    private CharacteristicsDto characteristics;
    private BattleInformation battleInformation;
    private EquipmentDto equipmentDto;
    private ExperienceDto experience;
    private ClassEnum classEnum;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public PersonDto getPerson() {
        return person;
    }

    public void setPerson(PersonDto person) {
        this.person = person;
    }

    public CharacteristicsDto getCharacteristics() {
        return characteristics;
    }

    public void setCharacteristics(CharacteristicsDto characteristics) {
        this.characteristics = characteristics;
    }

    public long getIdMainUser() {
        return idMainUser;
    }

    public void setIdMainUser(long idMainUser) {
        this.idMainUser = idMainUser;
    }

    public BattleInformation getBattleInformation() {
        return battleInformation;
    }

    public void setBattleInformation(BattleInformation battleInformation) {
        this.battleInformation = battleInformation;
    }

    public ExperienceDto getExperience() {
        return experience;
    }

    public void setExperience(ExperienceDto experience) {
        this.experience = experience;
    }

    public ClassEnum getClassEnum() {
        return classEnum;
    }

    public void setClassEnum(ClassEnum classEnum) {
        this.classEnum = classEnum;
    }

    public EquipmentDto getEquipmentDto() {
        return equipmentDto;
    }

    public void setEquipmentDto(EquipmentDto equipmentDto) {
        this.equipmentDto = equipmentDto;
    }
}
