package ca.destiny.evolution.creation;

import ca.destiny.fighter.experience.PersonalImprovement;
import ca.destiny.other.RandomNumberGeneratorService;
import org.springframework.stereotype.Component;

@Component
public class PersonalImprovementService {
    private final RandomNumberGeneratorService randomNumberGeneratorService;

    public PersonalImprovementService(RandomNumberGeneratorService randomNumberGeneratorService) {
        this.randomNumberGeneratorService = randomNumberGeneratorService;
    }

    public PersonalImprovement createRandom() {
        int randomValue = randomNumberGeneratorService.getRandomNumberInts(0, 10000);
        if (randomValue <= 9500) {
            return null;
        } else if (randomValue <= 9700) {
            return createPersonalImprovement(1);
        } else if (randomValue <= 9800) {
            return createPersonalImprovement(2);
        } else if (randomValue <= 9900) {
            return createPersonalImprovement(3);
        } else if (randomValue <= 9990) {
            return createPersonalImprovement(4);
        } else if (randomValue <= 9999) {
            return createPersonalImprovement(5);
        } else {
            return createPersonalImprovement(9);
        }

    }

    private PersonalImprovement createPersonalImprovement(int value) {
        var personalImprovement = new PersonalImprovement();
        int strength = randomNumberGeneratorService.getRandomNumberInts(0, value);
        int speed = randomNumberGeneratorService.getRandomNumberInts(0, value);
        int dexterity = randomNumberGeneratorService.getRandomNumberInts(0, value);
        int defense = randomNumberGeneratorService.getRandomNumberInts(0, value);
        int vitality = randomNumberGeneratorService.getRandomNumberInts(0, value * 2);
        int courage = randomNumberGeneratorService.getRandomNumberInts(0, value);
        int dodge = randomNumberGeneratorService.getRandomNumberInts(0, value);
        int resistance = randomNumberGeneratorService.getRandomNumberInts(0, value);
        int stamina = randomNumberGeneratorService.getRandomNumberInts(0, value);

        personalImprovement.setStrength(strength);
        personalImprovement.setSpeed(speed);
        personalImprovement.setDexterity(dexterity);
        personalImprovement.setDefense(defense);
        personalImprovement.setVitality(vitality);
        personalImprovement.setCourage(courage);
        personalImprovement.setDodge(dodge);
        personalImprovement.setResistance(resistance);
        personalImprovement.setStamina(stamina);
        return personalImprovement;
    }
}
