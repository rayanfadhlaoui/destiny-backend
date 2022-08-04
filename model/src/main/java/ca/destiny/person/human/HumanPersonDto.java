package ca.destiny.person.human;

import ca.destiny.person.PersonDto;
import ca.destiny.person.common.RaceEnum;

public class HumanPersonDto extends PersonDto {
    @Override
    public RaceEnum getRace() {
        return RaceEnum.HUMAN;
    }
}
