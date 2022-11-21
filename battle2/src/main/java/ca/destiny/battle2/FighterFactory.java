package ca.destiny.battle2;

import ca.destiny.evolution.creation.human.HumanNameProvider;
import ca.destiny.v2.person.common.GenderEnum;
import ca.destiny.v2.person.common.RaceEnum;
import org.springframework.stereotype.Component;

@Component
public class FighterFactory {

    private final HumanNameProvider humanNameProvider;

    public FighterFactory(HumanNameProvider humanNameProvider) {
        this.humanNameProvider = humanNameProvider;
    }

    public Fighter create(RaceEnum raceEnum) {
        Characteristics characteristics;
        Information information;
        switch (raceEnum) {
            case ORC:
                characteristics = new Characteristics(2, 2, 4, 4, 3, 1, 1);
                information = new Information("Unknown", "Unknown", GenderEnum.MALE, 20);
                break;
            case HUMAN:
                characteristics = new Characteristics(3, 3, 3, 3, 3, 1, 1);
                String firstName = humanNameProvider.getMaleFirstName();
                String lastName = humanNameProvider.getLastName();
                information = new Information(firstName, lastName, GenderEnum.MALE, 20);
                break;
            case ELF:
                characteristics = new Characteristics(4, 4, 2, 2, 3, 1, 1);
                information = new Information("Unknown", "Unknown", GenderEnum.MALE, 20);
                break;
            case DWARF:
                characteristics = new Characteristics(2, 3, 3, 4, 3, 1, 1);
                information = new Information("Unknown", "Unknown", GenderEnum.MALE, 20);
                break;
            default:
                throw new IllegalStateException();
        }
        HealthStatus healthStatus = new HealthStatus(Status.AWARE);
        return new Fighter(information, characteristics, healthStatus, raceEnum);
    }
}
