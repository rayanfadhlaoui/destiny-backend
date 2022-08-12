package ca.destiny.evolution.creation;

import ca.destiny.evolution.levelup.LevelUpExecutor;
import ca.destiny.fighter.BattleFighterDto;
import ca.destiny.fighter.CharacteristicsDto;
import ca.destiny.fighter.equipment.EquipmentDto;
import ca.destiny.fighter.equipment.weapon.AbilityWeight;
import ca.destiny.fighter.equipment.weapon.FistDto;
import ca.destiny.fighter.experience.ExperienceDto;
import ca.destiny.other.RandomNumberGeneratorService;
import ca.destiny.person.PersonDto;
import ca.destiny.fighter.ClassEnum;
import org.springframework.stereotype.Component;

@Component
public class FighterFactory {
    private long lastId = 1L;

    private final RandomNumberGeneratorService randomNumberGeneratorService;
    private final LevelUpExecutor levelUpExecutor;

    public FighterFactory(RandomNumberGeneratorService randomNumberGeneratorService,
                          LevelUpExecutor levelUpExecutor) {
        this.randomNumberGeneratorService = randomNumberGeneratorService;
        this.levelUpExecutor = levelUpExecutor;
    }

    public BattleFighterDto create(PersonDto personDto, Long userId) {
        BattleFighterDto battleFighter = createFighter(personDto, userId);
        levelUpExecutor.execute(battleFighter);
        return battleFighter;
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
        rightWeapon.setMaximumDamage(6);
        AbilityWeight abilityWeight = new AbilityWeight();
        abilityWeight.setDexterity(34);
        abilityWeight.setSpeed(33);
        abilityWeight.setStrength(33);
        rightWeapon.setAbilityWeight(abilityWeight);
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
        return experienceDto;
    }

}
