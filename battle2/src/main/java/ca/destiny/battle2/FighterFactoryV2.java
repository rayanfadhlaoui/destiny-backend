package ca.destiny.battle2;

import ca.destiny.evolution.creation.dwarf.DwarfNameProvider;
import ca.destiny.evolution.creation.elf.ElfNameProvider;
import ca.destiny.evolution.creation.human.HumanNameProvider;
import ca.destiny.evolution.creation.orc.OrcNameProvider;
import ca.destiny.v2.person.common.GenderEnum;
import ca.destiny.v2.person.common.RaceEnum;
import org.springframework.stereotype.Component;

@Component
public class FighterFactoryV2 {

    private final HumanNameProvider humanNameProvider;
    private final OrcNameProvider orcNameProvider;
    private final DwarfNameProvider dwarfNameProvider;
    private final ElfNameProvider elfNameProvider;

    public FighterFactoryV2(HumanNameProvider humanNameProvider,
                            OrcNameProvider orcNameProvider,
                            DwarfNameProvider dwarfNameProvider,
                            ElfNameProvider elfNameProvider) {
        this.humanNameProvider = humanNameProvider;
        this.orcNameProvider = orcNameProvider;
        this.dwarfNameProvider = dwarfNameProvider;
        this.elfNameProvider = elfNameProvider;
    }

    public Fighter create(RaceEnum raceEnum) {
        Characteristics characteristics;
        String firstName;
        String lastName;
        switch (raceEnum) {
            case ORC:
                characteristics = new Characteristics(2, 2, 4, 4, 4, 2,1, 1);
                firstName = orcNameProvider.getMaleFirstName();
                lastName = orcNameProvider.getLastName();
                break;
            case HUMAN:
                characteristics = new Characteristics(3, 3, 3, 3, 3, 3,1, 1);
                firstName = humanNameProvider.getMaleFirstName();
                lastName = humanNameProvider.getLastName();
                break;
            case ELF:
                characteristics = new Characteristics(4, 4, 2, 2, 2,4, 1, 1);
                firstName = elfNameProvider.getMaleFirstName();
                lastName = elfNameProvider.getLastName();
                break;
            case DWARF:
                characteristics = new Characteristics(2, 3, 3, 4, 4,2, 1, 1);
                firstName = dwarfNameProvider.getMaleFirstName();
                lastName = dwarfNameProvider.getLastName();
                break;
            default:
                throw new IllegalStateException();
        }
        HealthStatus healthStatus = new HealthStatus(Status.AWARE);
        Experience experience = new Experience(0, 1, 10);
        Information information = new Information(firstName, lastName, GenderEnum.MALE, 20);

        return new Fighter(information, characteristics, experience, healthStatus, raceEnum);
    }
}
