package ca.destiny.fighter;

import ca.destiny.fighter.bodypart.BodyPartDto;
import ca.destiny.fighter.equipment.EquipmentDto;
import ca.destiny.fighter.experience.ExperienceDto;
import ca.destiny.person.PersonDto;

import java.util.List;

public class BattleFighterDto {
    private long id;
    private long idMainUser;
    private PersonDto person;
    private CharacteristicsDto characteristics;
    private BattleInformation battleInformation;
    private EquipmentDto equipmentDto;
    private List<BodyPartDto> availableBodyParts;
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

    public List<BodyPartDto> getAvailableBodyParts() {
        return availableBodyParts;
    }

    public void setAvailableBodyParts(List<BodyPartDto> availableBodyParts) {
        this.availableBodyParts = availableBodyParts;
    }
}
