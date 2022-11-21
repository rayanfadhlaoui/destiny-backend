package ca.destiny.v2.fighter;

import com.fasterxml.jackson.annotation.JsonProperty;

public class InformationDto {
    private long id;
    private String firstName;
    private String lastName;
    private String race;
    private Integer age;
    @JsonProperty("class")
    private String fighterClass;
    private String gender;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getRace() {
        return race;
    }

    public void setRace(String race) {
        this.race = race;
    }

    public String getFighterClass() {
        return fighterClass;
    }

    public void setFighterClass(String fighterClass) {
        this.fighterClass = fighterClass;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
