package ca.destiny.battle2;

import ca.destiny.v2.person.common.GenderEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Information {

    private String firstName;
    private String lastName;
    private GenderEnum gender;
    private int age;
}
