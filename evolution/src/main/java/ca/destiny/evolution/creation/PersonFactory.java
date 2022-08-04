package ca.destiny.evolution.creation;

import ca.destiny.evolution.creation.human.HumanPersonFactory;
import ca.destiny.person.PersonDto;
import ca.destiny.person.common.RaceEnum;
import org.apache.commons.lang3.NotImplementedException;
import org.springframework.stereotype.Component;

@Component
public class PersonFactory {

    private final HumanPersonFactory humanPersonFactory;

    public PersonFactory(HumanPersonFactory humanPersonFactory) {
        this.humanPersonFactory = humanPersonFactory;
    }

    public PersonDto create(RaceEnum raceEnum, Long gameId) {
        PersonDto personDto;
        if (raceEnum == RaceEnum.HUMAN) {
            personDto = humanPersonFactory.create(gameId);
        } else {
            throw new NotImplementedException(raceEnum + " creation is not implemented");
        }

        return personDto;
    }
}
