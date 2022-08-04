package ca.destiny.person;

import ca.destiny.person.common.DestinyDate;
import ca.destiny.person.common.GenderEnum;
import ca.destiny.person.common.OriginTown;
import ca.destiny.person.common.RaceEnum;
import ca.destiny.person.human.HumanPersonDto;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonTypeInfo(use = JsonTypeInfo.Id.DEDUCTION)
@JsonSubTypes({
        @JsonSubTypes.Type(HumanPersonDto.class)}
)
public abstract class PersonDto {
    private long id;
    private String firstName;
    private String lastName;
    private DestinyDate destinyDate;
    private OriginTown originTown;
    private int age;
    private GenderEnum gender;

    public abstract RaceEnum getRace();

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

    public DestinyDate getDestinyDate() {
        return destinyDate;
    }

    public void setDestinyDate(DestinyDate destinyDate) {
        this.destinyDate = destinyDate;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setGender(GenderEnum gender) {
        this.gender = gender;
    }

    public GenderEnum getGender() {
        return gender;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public OriginTown getOriginTown() {
        return originTown;
    }

    public void setOriginTown(OriginTown originTown) {
        this.originTown = originTown;
    }
}
