package ca.destiny.evolution.enhancer;

import ca.destiny.evolution.enhancer.classEnhancer.ClassEnhancerProvider;
import ca.destiny.evolution.enhancer.gender.GenderEnhancerProvider;
import ca.destiny.evolution.enhancer.race.RaceEnhancerProvider;
import ca.destiny.evolution.enhancer.specialisation.SpecialisationEnhancerProvider;
import ca.destiny.fighter.ClassEnum;
import ca.destiny.fighter.SpecialisationEnum;
import ca.destiny.person.common.GenderEnum;
import ca.destiny.person.common.RaceEnum;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class CharacteristicsEnhancerProvider {

    private final ClassEnhancerProvider classEnhancerProvider;
    private final RaceEnhancerProvider raceEnhancerProvider;
    private final GenderEnhancerProvider genderEnhancerProvider;
    private final SpecialisationEnhancerProvider specialisationEnhancerProvider;

    public CharacteristicsEnhancerProvider(ClassEnhancerProvider classEnhancerProvider,
                                           RaceEnhancerProvider raceEnhancerProvider,
                                           GenderEnhancerProvider genderEnhancerProvider,
                                           SpecialisationEnhancerProvider specialisationEnhancerProvider) {
        this.classEnhancerProvider = classEnhancerProvider;
        this.raceEnhancerProvider = raceEnhancerProvider;
        this.genderEnhancerProvider = genderEnhancerProvider;
        this.specialisationEnhancerProvider = specialisationEnhancerProvider;
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

    public List<CharacteristicsEnhancer> getForSpecialisation(List<SpecialisationEnum> specialisations) {
        return specialisations.stream()
                .map(specialisationEnhancerProvider::get)
                .collect(Collectors.toList());
    }
}
