package ca.destiny.evolution.creation.elf;

import org.springframework.stereotype.Component;

@Component
public class ElfNameProvider {
    public String getMaleFirstName() {
        return RandomElfNameGenerator.getMaleFirstName();
    }

    public String getFemaleFirstName() {
        return RandomElfNameGenerator.getFemaleFirstName();
    }

    public String getLastName() {
        return RandomElfNameGenerator.getLastName();
    }
}
