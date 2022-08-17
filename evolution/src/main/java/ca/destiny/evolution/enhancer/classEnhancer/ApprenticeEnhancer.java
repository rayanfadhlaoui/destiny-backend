package ca.destiny.evolution.enhancer.classEnhancer;

import ca.destiny.evolution.enhancer.CharacteristicsEnhancer;
import ca.destiny.other.RandomNumberGeneratorService;

public class ApprenticeEnhancer extends CharacteristicsEnhancer {
    public ApprenticeEnhancer(RandomNumberGeneratorService randomNumberGeneratorService) {
        super(randomNumberGeneratorService);
        int bonus1 = 2;
        int bonus2 = 1;
        this.strength = bonus1;
        this.speed = bonus1;
        this.dexterity = bonus1;
        this.dodge = bonus1;
        this.courage = bonus1;
        this.vitality = 10;
        this.resistance = 1;
        this.defense = bonus2;
        this.stamina = bonus2;
    }
}
