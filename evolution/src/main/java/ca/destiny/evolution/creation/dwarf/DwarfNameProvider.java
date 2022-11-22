package ca.destiny.evolution.creation.dwarf;

import org.springframework.stereotype.Component;

@Component
public class DwarfNameProvider {
    public String getMaleFirstName() {
        return RandomDwarfNameGenerator.getMaleFirstName();
    }

    public String getFemaleFirstName() {
        return RandomDwarfNameGenerator.getFemaleFirstName();
    }

    public String getLastName() {
        return RandomDwarfNameGenerator.getLastName();
    }
}
