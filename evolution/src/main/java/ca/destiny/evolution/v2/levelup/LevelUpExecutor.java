package ca.destiny.evolution.v2.levelup;

import ca.destiny.evolution.v2.enhancer.CharacteristicsEnhancer;
import ca.destiny.evolution.v2.enhancer.CharacteristicsEnhancerProvider;
import ca.destiny.evolution.v2.specialisation.SpecialisationGenerator;
import ca.destiny.fighter.BattleFighterDto;
import ca.destiny.fighter.BattleInformation;
import ca.destiny.fighter.CharacteristicsDto;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class LevelUpExecutor {

    private final CharacteristicsEnhancerProvider characteristicsEnhancerProvider;
    private final SpecialisationGenerator specialisationGenerator;

    public LevelUpExecutor(CharacteristicsEnhancerProvider characteristicsEnhancerProvider,
                           SpecialisationGenerator specialisationGenerator) {
        this.characteristicsEnhancerProvider = characteristicsEnhancerProvider;
        this.specialisationGenerator = specialisationGenerator;
    }

    public void execute(BattleFighterDto battleFighterDto) {
        int previousVitality = battleFighterDto.getCharacteristics().getVitality();
        int previousStamina = battleFighterDto.getCharacteristics().getStamina();
        specialisationGenerator.improvePersonalEnhancers(battleFighterDto.getExperience());
        getEnhancers(battleFighterDto).forEach(en -> en.improve(battleFighterDto.getCharacteristics()));

        int vitality = battleFighterDto.getCharacteristics().getVitality();
        int stamina = battleFighterDto.getCharacteristics().getStamina();
        vitality = (vitality - previousVitality) + battleFighterDto.getBattleInformation().getVitality();
        stamina = (stamina - previousStamina) + battleFighterDto.getBattleInformation().getStamina();

        battleFighterDto.setBattleInformation(getBattleInformation(battleFighterDto.getCharacteristics(),
                vitality,
                stamina));
    }

    private BattleInformation getBattleInformation(CharacteristicsDto characteristics, int vitality, int stamina) {
        BattleInformation battleInformation = new BattleInformation();
        battleInformation.setStrength(characteristics.getStrength());
        battleInformation.setDefense(characteristics.getDefense());
        battleInformation.setVitality(vitality);
        battleInformation.setStamina(stamina);
        battleInformation.setResistance(characteristics.getResistance());
        battleInformation.setDexterity(characteristics.getDexterity());
        battleInformation.setDodge(characteristics.getDodge());
        battleInformation.setSpeed(characteristics.getSpeed());
        battleInformation.setCourage(characteristics.getCourage());
        return battleInformation;
    }

    private List<CharacteristicsEnhancer> getEnhancers(BattleFighterDto battleFighterDto) {
        var person = battleFighterDto.getPerson();
        List<CharacteristicsEnhancer> enhancers = new ArrayList<>();
        enhancers.add(characteristicsEnhancerProvider.getForClass(battleFighterDto.getClassEnum()));
        enhancers.add(characteristicsEnhancerProvider.getForRace(person.getRace()));
        enhancers.add(characteristicsEnhancerProvider.getForGender(person.getGender()));
        enhancers.add(characteristicsEnhancerProvider.getForCustom(battleFighterDto.getExperience().getPersonalImprovement()));
        return enhancers;
    }
}
