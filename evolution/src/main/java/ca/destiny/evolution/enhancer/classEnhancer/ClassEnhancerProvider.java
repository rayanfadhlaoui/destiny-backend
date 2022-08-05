package ca.destiny.evolution.enhancer.classEnhancer;

import ca.destiny.evolution.enhancer.CharacteristicsEnhancer;
import ca.destiny.evolution.enhancer.DefaultEnhancer;
import ca.destiny.other.RandomNumberGeneratorService;
import ca.destiny.fighter.ClassEnum;
import org.springframework.stereotype.Component;

@Component
public class ClassEnhancerProvider {

    private final RandomNumberGeneratorService randomNumberGeneratorService;

    public ClassEnhancerProvider(RandomNumberGeneratorService randomNumberGeneratorService) {
        this.randomNumberGeneratorService = randomNumberGeneratorService;
    }

    public CharacteristicsEnhancer get(ClassEnum classEnum) {
        switch (classEnum) {
            case NO_CLASS:
                return new DefaultEnhancer(randomNumberGeneratorService);
            case APPRENTICE:
                return new ApprenticeEnhancer(randomNumberGeneratorService);
            case THIRD_CLASS:
                return new ThirdClassEnhancer(randomNumberGeneratorService);
            default:
                throw new IllegalArgumentException("No enhancer for class :" + classEnum);
        }
    }
}
