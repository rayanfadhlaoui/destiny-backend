package ca.destiny.evolution.creation.human;

import org.springframework.stereotype.Component;

@Component
public class HumanNameProvider {
    public String getMaleFirstName() {
        return RandomNameGenerator.getMaleFirstName();
    }

    public String getFemaleFirstName() {
        return RandomNameGenerator.getFemaleFirstName();
    }

    public String getLastName() {
        return RandomNameGenerator.getLastName();
    }
}
