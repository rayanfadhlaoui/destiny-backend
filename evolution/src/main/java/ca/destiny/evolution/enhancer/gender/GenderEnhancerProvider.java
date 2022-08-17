package ca.destiny.evolution.enhancer.gender;

import ca.destiny.evolution.enhancer.CharacteristicsEnhancer;
import ca.destiny.other.RandomNumberGeneratorService;
import ca.destiny.person.common.GenderEnum;
import org.springframework.stereotype.Component;

@Component
public class GenderEnhancerProvider {
    private final RandomNumberGeneratorService randomNumberGeneratorService;

    public GenderEnhancerProvider(RandomNumberGeneratorService randomNumberGeneratorService) {
        this.randomNumberGeneratorService = randomNumberGeneratorService;
    }

    public CharacteristicsEnhancer get(GenderEnum genderEnum) {
        switch (genderEnum) {
            case MALE:
                return new GenderEnhancer(2, 1, randomNumberGeneratorService);
            case FEMALE:
                return new GenderEnhancer(1, 2, randomNumberGeneratorService);
            default:
                throw new IllegalArgumentException("No enhancer for genderEnum :" + genderEnum);
        }
    }
}