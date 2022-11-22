package ca.destiny.evolution.creation.orc;

import org.springframework.stereotype.Component;

@Component
public class OrcNameProvider {
    public String getMaleFirstName() {
        return RandomOrcNameGenerator.getMaleFirstName();
    }

    public String getFemaleFirstName() {
        return RandomOrcNameGenerator.getFemaleFirstName();
    }

    public String getLastName() {
        return RandomOrcNameGenerator.getLastName();
    }
}
