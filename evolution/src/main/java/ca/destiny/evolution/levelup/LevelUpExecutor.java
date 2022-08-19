package ca.destiny.evolution.levelup;

import ca.destiny.evolution.enhancer.CharacteristicsEnhancer;
import ca.destiny.evolution.enhancer.CharacteristicsEnhancerProvider;
import ca.destiny.evolution.specialisation.SpecialisationGenerator;
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
        specialisationGenerator.improvePersonalEnhancers(battleFighterDto.getExperience());
        getEnhancers(battleFighterDto).forEach(en -> en.improve(battleFighterDto.getCharacteristics()));
        battleFighterDto.setBattleInformation(getBattleInformation(battleFighterDto.getCharacteristics()));
    }

    private BattleInformation getBattleInformation(CharacteristicsDto characteristics) {
        BattleInformation battleInformation = new BattleInformation();
        battleInformation.setVitality(characteristics.getVitality());
        battleInformation.setDexterity(characteristics.getDexterity());
        battleInformation.setDodge(characteristics.getDodge());
        battleInformation.setCourage(characteristics.getCourage());
        battleInformation.setResistance(characteristics.getResistance());
        battleInformation.setSpeed(characteristics.getSpeed());
        battleInformation.setDefense(characteristics.getDefense());
        battleInformation.setStrength(characteristics.getStrength());
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
