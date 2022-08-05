package ca.destiny.evolution.enhancer.classEnhancer;

import ca.destiny.evolution.enhancer.CharacteristicsEnhancer;
import ca.destiny.other.RandomNumberGeneratorService;

public class ThirdClassEnhancer extends CharacteristicsEnhancer {
    public ThirdClassEnhancer(RandomNumberGeneratorService randomNumberGeneratorService) {
        super(randomNumberGeneratorService);
        this.strength = 3;
        this.speed = 3;
        this.dexterity = 3;
        this.defense = 3;
        this.vitality = 15;
        this.courage = 3;
        this.dodge = 3;
        this.stamina = 3;
        this.speed = 2;
    }
}
