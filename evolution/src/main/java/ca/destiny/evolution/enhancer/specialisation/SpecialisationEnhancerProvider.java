package ca.destiny.evolution.enhancer.specialisation;

import ca.destiny.evolution.enhancer.CharacteristicsEnhancer;
import ca.destiny.fighter.SpecialisationEnum;
import ca.destiny.other.RandomNumberGeneratorService;
import org.springframework.stereotype.Component;

@Component
public class SpecialisationEnhancerProvider {

    private final RandomNumberGeneratorService randomNumberGeneratorService;

    public SpecialisationEnhancerProvider(RandomNumberGeneratorService randomNumberGeneratorService) {
        this.randomNumberGeneratorService = randomNumberGeneratorService;
    }

    public CharacteristicsEnhancer get(SpecialisationEnum specialisationEnum) {
        int strength = 0;
        int dexterity = 0;
        int speed = 0;
        int vitality = 0;
        int defense = 0;
        int dodge = 0;
        switch (specialisationEnum) {
            case DEXTERITY:
                dexterity = 2;
                break;
            case STRENGTH:
                strength = 2;
                break;
            case SPEED:
                speed = 2;
                break;
            case VITALITY:
                vitality = 5;
                break;
            case DEFENSE:
                defense = 1;
                break;
            case DODGE:
                dodge = 1;
                break;
        }
        return new SpecialisationEnhancer(strength, dexterity, speed, vitality, defense, dodge, randomNumberGeneratorService);
    }
}
