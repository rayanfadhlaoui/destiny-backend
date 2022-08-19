package ca.destiny.evolution.enhancer;

import ca.destiny.evolution.enhancer.classEnhancer.ClassEnhancerProvider;
import ca.destiny.evolution.enhancer.custom.CustomEnhancerProvider;
import ca.destiny.evolution.enhancer.gender.GenderEnhancerProvider;
import ca.destiny.evolution.enhancer.race.RaceEnhancerProvider;
import ca.destiny.fighter.ClassEnum;
import ca.destiny.fighter.experience.PersonalImprovement;
import ca.destiny.person.common.GenderEnum;
import ca.destiny.person.common.RaceEnum;
import org.springframework.stereotype.Component;

@Component
public class CharacteristicsEnhancerProvider {

    private final ClassEnhancerProvider classEnhancerProvider;
    private final RaceEnhancerProvider raceEnhancerProvider;
    private final GenderEnhancerProvider genderEnhancerProvider;
    private final CustomEnhancerProvider customEnhancerProvider;

    public CharacteristicsEnhancerProvider(ClassEnhancerProvider classEnhancerProvider,
                                           RaceEnhancerProvider raceEnhancerProvider,
                                           GenderEnhancerProvider genderEnhancerProvider,
                                           CustomEnhancerProvider customEnhancerProvider) {
        this.classEnhancerProvider = classEnhancerProvider;
        this.raceEnhancerProvider = raceEnhancerProvider;
        this.genderEnhancerProvider = genderEnhancerProvider;
        this.customEnhancerProvider = customEnhancerProvider;
    }

    public CharacteristicsEnhancer getForClass(ClassEnum classEnum) {
        return classEnhancerProvider.get(classEnum);
    }

    public CharacteristicsEnhancer getForRace(RaceEnum raceEnum) {
        return raceEnhancerProvider.get(raceEnum);
    }

    public CharacteristicsEnhancer getForGender(GenderEnum genderEnum) {
        return genderEnhancerProvider.get(genderEnum);
    }

    public CharacteristicsEnhancer getForCustom(PersonalImprovement personalImprovement) {
        return customEnhancerProvider.get(personalImprovement);
    }
}
