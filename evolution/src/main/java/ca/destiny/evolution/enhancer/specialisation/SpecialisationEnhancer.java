package ca.destiny.evolution.enhancer.specialisation;

import ca.destiny.evolution.enhancer.CharacteristicsEnhancer;
import ca.destiny.other.RandomNumberGeneratorService;

public class SpecialisationEnhancer extends CharacteristicsEnhancer {
    public SpecialisationEnhancer(int strength,
                                  int dexterity,
                                  int speed,
                                  int vitality,
                                  int defense,
                                  int dodge,
                                  RandomNumberGeneratorService randomNumberGeneratorService) {
        super(randomNumberGeneratorService);
        this.strength = strength;
        this.dexterity = dexterity;
        this.speed = speed;
        this.vitality = vitality;
        this.defense = defense;
        this.dodge = dodge;
    }
}
