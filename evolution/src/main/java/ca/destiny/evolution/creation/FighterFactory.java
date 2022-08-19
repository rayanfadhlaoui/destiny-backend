package ca.destiny.evolution.creation;

import ca.destiny.evolution.levelup.LevelUpExecutor;
import ca.destiny.fighter.BattleFighterDto;
import ca.destiny.fighter.CharacteristicsDto;
import ca.destiny.fighter.ClassEnum;
import ca.destiny.fighter.equipment.EquipmentDto;
import ca.destiny.fighter.equipment.weapon.AbilityBonus;
import ca.destiny.fighter.equipment.weapon.FistDto;
import ca.destiny.fighter.experience.ExperienceDto;
import ca.destiny.other.RandomNumberGeneratorService;
import ca.destiny.person.PersonDto;
import ca.destiny.person.common.RaceEnum;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Component
public class FighterFactory {
    private long lastId = 1L;

    private final RandomNumberGeneratorService randomNumberGeneratorService;
    private final PersonalImprovementService personalImprovementService;
    private final PersonFactory personFactory;
    private final LevelUpExecutor levelUpExecutor;

    public FighterFactory(RandomNumberGeneratorService randomNumberGeneratorService,
                          PersonalImprovementService personalImprovementService,
                          PersonFactory personFactory,
                          LevelUpExecutor levelUpExecutor) {
        this.randomNumberGeneratorService = randomNumberGeneratorService;
        this.personalImprovementService = personalImprovementService;
        this.personFactory = personFactory;
        this.levelUpExecutor = levelUpExecutor;
    }

    public BattleFighterDto create(PersonDto personDto, Long userId) {
        BattleFighterDto battleFighter = createFighter(personDto, userId);
        levelUpExecutor.execute(battleFighter);
        return battleFighter;
    }

    public List<BattleFighterDto> create(int amount) {
        return IntStream.range(0, amount)
                .mapToObj(v -> personFactory.create(RaceEnum.HUMAN, 1L))
                .map(p -> create(p, 1L))
                .collect(Collectors.toList());
    }

    private BattleFighterDto createFighter(PersonDto person, Long userId) {
        BattleFighterDto fighterEntity = new BattleFighterDto();
        CharacteristicsDto characteristics = new CharacteristicsDto();
        fighterEntity.setId(lastId++);
        fighterEntity.setIdMainUser(userId);
        fighterEntity.setExperience(createExperience());
        fighterEntity.setPerson(person);
        fighterEntity.setClassEnum(ClassEnum.NO_CLASS);
        fighterEntity.setCharacteristics(characteristics);
        fighterEntity.setEquipmentDto(createEquipment());
        return fighterEntity;
    }

    private EquipmentDto createEquipment() {
        EquipmentDto equipmentDto = new EquipmentDto();
        FistDto rightWeapon = new FistDto();
        rightWeapon.setName("Bare hand");
        rightWeapon.setMinimumDamage(1);
        AbilityBonus abilityBonus = new AbilityBonus();
        abilityBonus.setStrength(0);
        abilityBonus.setSpeed(0);
        abilityBonus.setDexterity(0);
        rightWeapon.setAbilityBonus(abilityBonus);
        rightWeapon.setMaximumDamage(6);
        rightWeapon.setBlunt(1);
        rightWeapon.setPenetration(0);
        equipmentDto.setRightWeapon(rightWeapon);
        return equipmentDto;
    }

    private ExperienceDto createExperience() {
        var experienceDto = new ExperienceDto();
        experienceDto.setCurrentExperience(0);
        experienceDto.setWorth(10);
        experienceDto.setNextLevel(randomNumberGeneratorService.getRandomNumberInts(10, 100));
        experienceDto.setCurrentExperience(0);
        experienceDto.setPersonalImprovement(personalImprovementService.createRandom());
        return experienceDto;
    }

}
