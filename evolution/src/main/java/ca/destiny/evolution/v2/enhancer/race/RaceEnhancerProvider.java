package ca.destiny.evolution.v2.enhancer.race;

import ca.destiny.evolution.v2.enhancer.CharacteristicsEnhancer;
import ca.destiny.other.RandomNumberGeneratorService;
import ca.destiny.person.common.RaceEnum;
import org.springframework.stereotype.Component;

@Component
public class RaceEnhancerProvider {
    private final RandomNumberGeneratorService randomNumberGeneratorService;

    public RaceEnhancerProvider(RandomNumberGeneratorService randomNumberGeneratorService) {
        this.randomNumberGeneratorService = randomNumberGeneratorService;
    }

    public CharacteristicsEnhancer get(RaceEnum raceEnum) {
        switch (raceEnum) {
            case ORC:
                return new RaceEnhancer(4, 4, 8, 0, 0, 0, randomNumberGeneratorService);
            case HUMAN:
                return new RaceEnhancer(2, 2, 6, 2, 2, 2, randomNumberGeneratorService);
            case ELF:
                return new RaceEnhancer(0, 0, 4, 4, 4, 4, randomNumberGeneratorService);
            case DWARF:
                return new RaceEnhancer(0, 4, 8, 0, 0, 4, randomNumberGeneratorService);
            default:
                throw new IllegalArgumentException("No enhancer for raceEnum :" + raceEnum);
        }
    }
}
