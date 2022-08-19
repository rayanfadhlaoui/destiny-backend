package ca.destiny.evolution.specialisation;

import ca.destiny.fighter.experience.ExperienceDto;
import ca.destiny.fighter.experience.PersonalImprovement;
import ca.destiny.other.RandomNumberGeneratorService;
import org.springframework.stereotype.Component;

import java.util.function.Consumer;

@Component
public class SpecialisationGenerator {

    private final RandomNumberGeneratorService randomNumberGeneratorService;

    public SpecialisationGenerator(RandomNumberGeneratorService randomNumberGeneratorService) {
        this.randomNumberGeneratorService = randomNumberGeneratorService;
    }

    public void improvePersonalEnhancers(ExperienceDto experience) {
        var customEnhancer = experience.getPersonalImprovement();
        boolean shouldSet = false;
        if (customEnhancer == null) {
            shouldSet = true;
            customEnhancer = new PersonalImprovement();
        }

        int random = randomNumberGeneratorService.getRandomNumberInts(0, 8);

        switch (random) {
            case 0:
                shouldSet &= improve(customEnhancer.getStrength(), customEnhancer::setStrength);
                break;
            case 1:
                shouldSet &= improve(customEnhancer.getDexterity(), customEnhancer::setDexterity);
                break;
            case 2:
                shouldSet &= improve(customEnhancer.getDodge(), customEnhancer::setDodge);
                break;
            case 3:
                shouldSet &= improve(customEnhancer.getDefense(), customEnhancer::setDefense);
                break;
            case 4:
                shouldSet &= improve(customEnhancer.getSpeed(), customEnhancer::setSpeed);
                break;
            case 5:
                shouldSet &= improve(customEnhancer.getCourage(), customEnhancer::setCourage);
                break;
            case 6:
                shouldSet &= improve(customEnhancer.getStamina(), customEnhancer::setStamina);
                break;
            case 7:
                shouldSet &= improve(customEnhancer.getVitality(), customEnhancer::setVitality, 3);
                break;
            default:
                shouldSet &= improve(customEnhancer.getResistance(), customEnhancer::setResistance);
        }

        if (shouldSet) {
            experience.setPersonalImprovement(customEnhancer);
        }
    }

    private boolean improve(Integer value, Consumer<Integer> applyImprovement) {
        return improve(value, applyImprovement, 1);
    }

    private boolean improve(Integer value, Consumer<Integer> applyImprovement, int delta) {
        int difficulty;
        if (value <= 5) {
            difficulty = 20;
        } else if (value <= 10) {
            difficulty = 40;
        } else if (value <= 20) {
            difficulty = 80;
        } else {
            throw new IllegalArgumentException(value + " is too high, Investigate plz");
        }
        if (randomNumberGeneratorService.getRandomNumberInts(0, difficulty) == 0) {
            applyImprovement.accept(value + delta);
            return true;
        }
        return false;
    }
}
