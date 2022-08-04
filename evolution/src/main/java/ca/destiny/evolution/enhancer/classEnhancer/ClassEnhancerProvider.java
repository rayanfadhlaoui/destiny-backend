package ca.destiny.evolution.enhancer.classEnhancer;

import ca.destiny.evolution.enhancer.CharacteristicsEnhancer;
import ca.destiny.evolution.enhancer.DefaultEnhancer;
import ca.destiny.person.common.ClassEnum;
import org.springframework.stereotype.Component;

@Component
public class ClassEnhancerProvider {
    public CharacteristicsEnhancer get(ClassEnum classEnum) {
        switch (classEnum) {
            case NO_CLASS:
                return new DefaultEnhancer();
            default:
                throw new IllegalArgumentException("No enhancer for class :" + classEnum);
        }
    }
}
