package ca.destiny.evolution.v2.enhancer.race;

import ca.destiny.evolution.v2.enhancer.CharacteristicsEnhancer;
import ca.destiny.other.RandomNumberGeneratorService;

public class RaceEnhancer extends CharacteristicsEnhancer {
    public RaceEnhancer(int strength,
                        int defense,
                        int vitality,
                        int dexterity,
                        int dodge,
                        int courage,
                        RandomNumberGeneratorService randomNumberGeneratorService) {
        super(randomNumberGeneratorService);
        this.strength = strength;
        this.defense = defense;
        this.vitality = vitality;
        this.dexterity = dexterity;
        this.dodge = dodge;
        this.courage = courage;
    }
}
