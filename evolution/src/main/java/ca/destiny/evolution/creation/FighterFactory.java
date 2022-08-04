package ca.destiny.evolution.creation;

import ca.destiny.evolution.enhancer.CharacteristicsEnhancer;
import ca.destiny.evolution.enhancer.CharacteristicsEnhancerProvider;
import ca.destiny.fighter.BattleFighterDto;
import ca.destiny.fighter.BattleInformation;
import ca.destiny.fighter.CharacteristicsDto;
import ca.destiny.fighter.experience.ExperienceDto;
import ca.destiny.other.RandomNumberGeneratorService;
import ca.destiny.person.PersonDto;
import ca.destiny.person.common.ClassEnum;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class FighterFactory {
    private long lastId = 1L;

    private final CharacteristicsEnhancerProvider characteristicsEnhancerProvider;
    private final RandomNumberGeneratorService randomNumberGeneratorService;

    public FighterFactory(CharacteristicsEnhancerProvider characteristicsEnhancerProvider,
                          RandomNumberGeneratorService randomNumberGeneratorService) {
        this.characteristicsEnhancerProvider = characteristicsEnhancerProvider;
        this.randomNumberGeneratorService = randomNumberGeneratorService;
    }

    public BattleFighterDto create(PersonDto personDto, Long userId) {
        BattleFighterDto battleFighter = createFighter(personDto, userId);
        getEnhancers(personDto).forEach(en -> en.improve(battleFighter.getCharacteristics()));
        battleFighter.setBattleInformation(getBattleInformation(battleFighter.getCharacteristics()));
        return battleFighter;
    }

    private BattleInformation getBattleInformation(CharacteristicsDto characteristics) {
        BattleInformation battleInformation = new BattleInformation();
        battleInformation.setVitality(characteristics.getVitality());
        battleInformation.setDexterity(characteristics.getDexterity());
        battleInformation.setDodge(characteristics.getDodge());
        battleInformation.setDefense(characteristics.getDefense());
        Integer strength = characteristics.getStrength();
        battleInformation.setMinimumDamage(Math.max(1, strength / 2));
        battleInformation.setMaximumDamage(strength);
        return battleInformation;
    }

    private BattleFighterDto createFighter(PersonDto person, Long userId) {
        BattleFighterDto fighterEntity = new BattleFighterDto();
        CharacteristicsDto characteristics = new CharacteristicsDto();
        fighterEntity.setId(lastId++);
        fighterEntity.setIdMainUser(userId);
        fighterEntity.setExperience(createExperience());
        fighterEntity.setPerson(person);
        fighterEntity.setCharacteristics(characteristics);
        return fighterEntity;
    }

    private ExperienceDto createExperience() {
        var experienceDto = new ExperienceDto();
        experienceDto.setCurrentExperience(0);
        experienceDto.setWorth(10);
        experienceDto.setNextLevel(randomNumberGeneratorService.getRandomNumberInts(10, 1000));
        experienceDto.setCurrentExperience(0);
        return experienceDto;
    }

    private List<CharacteristicsEnhancer> getEnhancers(PersonDto personDto) {
        List<CharacteristicsEnhancer> enhancers = new ArrayList<>();
        enhancers.add(characteristicsEnhancerProvider.getForClass(ClassEnum.NO_CLASS));
        enhancers.add(characteristicsEnhancerProvider.getForRace(personDto.getRace()));
        enhancers.add(characteristicsEnhancerProvider.getForGender(personDto.getGender()));
        return enhancers;
    }
}
