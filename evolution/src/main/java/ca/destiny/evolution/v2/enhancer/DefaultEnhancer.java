package ca.destiny.evolution.v2.enhancer;

import ca.destiny.other.RandomNumberGeneratorService;

public class DefaultEnhancer extends CharacteristicsEnhancer {

    public DefaultEnhancer(RandomNumberGeneratorService randomNumberGeneratorService) {
        super(randomNumberGeneratorService);
        this.strength = 1;
        this.speed = 1;
        this.dexterity = 1;
        this.defense = 1;
        this.vitality = 5;
        this.courage = 1;
        this.dodge = 1;
        this.resistance = 1;
        this.stamina = 1;
    }
}
