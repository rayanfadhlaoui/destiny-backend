package ca.destiny.evolution.enhancer.gender;

import ca.destiny.evolution.enhancer.CharacteristicsEnhancer;
import ca.destiny.person.common.GenderEnum;
import org.springframework.stereotype.Component;

@Component
public class GenderEnhancerProvider {
    public CharacteristicsEnhancer get(GenderEnum genderEnum) {
        switch (genderEnum) {
            case MALE:
                return new GenderEnhancer(3,0);
            case FEMALE:
                return new GenderEnhancer(0,3);
            default:
                throw new IllegalArgumentException("No enhancer for genderEnum :" + genderEnum);
        }
    }
}