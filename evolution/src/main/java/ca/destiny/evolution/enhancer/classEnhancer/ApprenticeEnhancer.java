package ca.destiny.evolution.enhancer.classEnhancer;

import ca.destiny.evolution.enhancer.CharacteristicsEnhancer;
import ca.destiny.other.RandomNumberGeneratorService;

public class ApprenticeEnhancer extends CharacteristicsEnhancer {
    public ApprenticeEnhancer(RandomNumberGeneratorService randomNumberGeneratorService) {
        super(randomNumberGeneratorService);
        this.strength = 2;
        this.speed = 2;
        this.dexterity = 2;
        this.defense = 2;
        this.vitality = 10;
        this.courage = 2;
        this.resistance = 1;
        this.dodge = 2;
        this.stamina = 2;
    }
}
