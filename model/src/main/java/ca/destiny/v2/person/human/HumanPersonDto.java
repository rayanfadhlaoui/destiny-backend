package ca.destiny.v2.person.human;

import ca.destiny.v2.person.PersonDto;
import ca.destiny.v2.person.common.RaceEnum;

public class HumanPersonDto extends PersonDto {
    @Override
    public RaceEnum getRace() {
        return RaceEnum.HUMAN;
    }
}
