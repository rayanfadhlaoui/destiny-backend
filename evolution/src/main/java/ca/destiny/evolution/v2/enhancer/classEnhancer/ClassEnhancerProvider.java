package ca.destiny.evolution.v2.enhancer.classEnhancer;

import ca.destiny.evolution.v2.enhancer.CharacteristicsEnhancer;
import ca.destiny.evolution.v2.enhancer.DefaultEnhancer;
import ca.destiny.fighter.ClassEnum;
import ca.destiny.other.RandomNumberGeneratorService;
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
            case SECOND_CLASS:
                return new SecondClassEnhancer(randomNumberGeneratorService);
            case FIRST_CLASS:
                return new FirstClassEnhancer(randomNumberGeneratorService);
            case SERGEANT:
                return new SergeantEnhancer(randomNumberGeneratorService);
            case SERGEANT_MAYOR:
                return new SergeantMayorEnhancer(randomNumberGeneratorService);
            case WARRANT_OFFICER:
                return new WarrantOfficerEnhancer(randomNumberGeneratorService);
            case OFFICER:
                return new OfficerEnhancer(randomNumberGeneratorService);
            case JUNIOR_LIEUTENANT:
                return new JuniorLieutenantEnhancer(randomNumberGeneratorService);
            case LIEUTENANT:
                return new LieutenantEnhancer(randomNumberGeneratorService);
            case FIRST_LIEUTENANT:
                return new FirstLieutenantEnhancer(randomNumberGeneratorService);
            case MAYOR:
                return new MayorEnhancer(randomNumberGeneratorService);
            case COLONEL:
                return new ColonelEnhancer(randomNumberGeneratorService);
            case REAR_ADMIRAL:
                return new RearAdmiralEnhancer(randomNumberGeneratorService);
            case SUB_ADMIRAL:
                return new SubAdmiralEnhancer(randomNumberGeneratorService);
            case VICE_ADMIRAL:
                return new ViceAdmiralEnhancer(randomNumberGeneratorService);
            case ADMIRAL:
                return new AdmiralEnhancer(randomNumberGeneratorService);
            case GRAND_ADMIRAL:
                return new GrandAdmiralEnhancer(randomNumberGeneratorService);
            default:
                throw new IllegalArgumentException("No enhancer for class :" + classEnum);
        }
    }
}
