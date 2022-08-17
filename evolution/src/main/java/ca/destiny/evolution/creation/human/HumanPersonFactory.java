package ca.destiny.evolution.creation.human;

import ca.destiny.evolution.creation.bodypart.BodyPartFactory;
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
    private final BodyPartFactory bodyPartFactory;
    private final RandomNumberGeneratorService randomNumberGeneratorService;

    public HumanPersonFactory(HumanNameProvider humanNameProvider,
                              GameInformationService gameInformationService,
                              BodyPartFactory bodyPartFactory, RandomNumberGeneratorService randomNumberGeneratorService) {
        this.humanNameProvider = humanNameProvider;
        this.gameInformationService = gameInformationService;
        this.bodyPartFactory = bodyPartFactory;
        this.randomNumberGeneratorService = randomNumberGeneratorService;
    }

    public PersonDto create(Long gameId) {
        PersonDto personDto = new HumanPersonDto();
        String lastName = humanNameProvider.getLastName();
        GenderEnum gender = getGender();
        String firstName;
        if (gender == GenderEnum.MALE) {
            firstName = humanNameProvider.getMaleFirstName();
        } else {
            firstName = humanNameProvider.getFemaleFirstName();
        }
        personDto.setAge(12);
        personDto.setFirstName(firstName);
        personDto.setLastName(lastName);
        personDto.setGender(gender);
        OriginTown originTown = new OriginTown();
        originTown.setName("Whutchan");
        personDto.setOriginTown(originTown);
        personDto.setAvailableBodyParts(bodyPartFactory.create());
        personDto.setDestinyDate(gameInformationService.getCurrentDate(gameId));
        return personDto;
    }

    private GenderEnum getGender() {
        return randomNumberGeneratorService.getRandomNumberInts(0, 1) == 0 ? GenderEnum.MALE : GenderEnum.FEMALE;
    }
}
