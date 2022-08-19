package ca.destiny.evolution.enhancer.custom;

import ca.destiny.evolution.enhancer.CharacteristicsEnhancer;
import ca.destiny.fighter.experience.PersonalImprovement;
import ca.destiny.other.RandomNumberGeneratorService;
import org.springframework.stereotype.Component;

@Component
public class CustomEnhancerProvider {

    private final RandomNumberGeneratorService randomNumberGeneratorService;

    public CustomEnhancerProvider(RandomNumberGeneratorService randomNumberGeneratorService) {
        this.randomNumberGeneratorService = randomNumberGeneratorService;
    }

    public CharacteristicsEnhancer get(PersonalImprovement personalImprovement) {
        return new SpecialisationEnhancer(personalImprovement, randomNumberGeneratorService);
    }
}
