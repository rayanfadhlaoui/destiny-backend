package ca.destiny.fighter;

import ca.destiny.fighter.experience.ExperienceDto;
import ca.destiny.person.PersonDto;

public class BattleFighterDto {
    private long id;
    private long idMainUser;
    private PersonDto person;
    private CharacteristicsDto characteristics;
    private BattleInformation battleInformation;
    private ExperienceDto experience;

    public BattleFighterDto() {
    }

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
}
