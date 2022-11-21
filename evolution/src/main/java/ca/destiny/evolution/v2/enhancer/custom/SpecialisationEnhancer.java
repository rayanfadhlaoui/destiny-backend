package ca.destiny.evolution.v2.enhancer.custom;

import ca.destiny.evolution.v2.enhancer.CharacteristicsEnhancer;
import ca.destiny.fighter.experience.PersonalImprovement;
import ca.destiny.other.RandomNumberGeneratorService;

public class SpecialisationEnhancer extends CharacteristicsEnhancer {
    public SpecialisationEnhancer(PersonalImprovement personalImprovement,
                                  RandomNumberGeneratorService randomNumberGeneratorService) {
        super(randomNumberGeneratorService);
        if (personalImprovement != null) {
            this.strength = personalImprovement.getStrength();
            this.dexterity = personalImprovement.getDexterity();
            this.vitality = personalImprovement.getVitality();
            this.defense = personalImprovement.getDefense();
            this.resistance = personalImprovement.getResistance();
            this.dodge = personalImprovement.getDodge();
            this.speed = personalImprovement.getSpeed();
            this.stamina = personalImprovement.getStamina();
            this.courage = personalImprovement.getCourage();
        }
    }
}
