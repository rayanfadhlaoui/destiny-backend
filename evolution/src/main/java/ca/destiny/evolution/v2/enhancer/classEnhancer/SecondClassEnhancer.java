package ca.destiny.evolution.v2.enhancer.classEnhancer;

import ca.destiny.evolution.v2.enhancer.CharacteristicsEnhancer;
import ca.destiny.other.RandomNumberGeneratorService;

public class SecondClassEnhancer extends CharacteristicsEnhancer {
    public SecondClassEnhancer(RandomNumberGeneratorService randomNumberGeneratorService) {
        super(randomNumberGeneratorService);
        int bonus1 = 3;
        int bonus2 = 2;
        this.strength = bonus1;
        this.speed = bonus1;
        this.dexterity = bonus1;
        this.courage = bonus1;
        this.stamina = bonus2;
        this.dodge = bonus2;
        this.defense = bonus2;
        this.resistance = 1;
        this.vitality = 20;
    }
}
