package ca.destiny.battle2;

import ca.destiny.v2.person.common.GenderEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Information {

    private final String firstName;
    private final String lastName;
    private final GenderEnum gender;
    private int age;
}
