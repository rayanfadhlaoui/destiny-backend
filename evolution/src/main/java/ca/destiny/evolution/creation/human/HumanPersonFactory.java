package ca.destiny.evolution.creation.human;

import ca.destiny.game.GameInformationService;
import ca.destiny.other.RandomNumberGeneratorService;
import ca.destiny.person.PersonDto;
import ca.destiny.person.common.GenderEnum;
import ca.destiny.person.common.OriginTown;
import ca.destiny.person.human.HumanPersonDto;
import org.springframework.stereotype.Component;

@Component
public class HumanPersonFactory {

    private final HumanNameProvider humanNameProvider;
    private final GameInformationService gameInformationService;
    private final RandomNumberGeneratorService randomNumberGeneratorService;

    public HumanPersonFactory(HumanNameProvider humanNameProvider,
                              GameInformationService gameInformationService,
                              RandomNumberGeneratorService randomNumberGeneratorService) {
        this.humanNameProvider = humanNameProvider;
        this.gameInformationService = gameInformationService;
        this.randomNumberGeneratorService = randomNumberGeneratorService;
    }

    public PersonDto create(Long gameId) {
        PersonDto personDto = new HumanPersonDto();
        String firstName = humanNameProvider.getMaleFirstName();
        String lastName = humanNameProvider.getLastName();
        GenderEnum gender = getGender();
        personDto.setAge(12);
        personDto.setFirstName(firstName);
        personDto.setLastName(lastName);
        personDto.setGender(gender);
        OriginTown originTown = new OriginTown();
        originTown.setName("Root Strain");
        personDto.setOriginTown(originTown);
        personDto.setDestinyDate(gameInformationService.getCurrentDate(gameId));
        return personDto;
    }

    private GenderEnum getGender() {
        return randomNumberGeneratorService.getRandomNumberInts(0, 1) == 0 ? GenderEnum.MALE : GenderEnum.FEMALE;
    }
}
