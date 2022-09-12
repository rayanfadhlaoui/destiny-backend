package ca.destiny.evolution.refresh;

import ca.destiny.fighter.BattleFighterDto;
import ca.destiny.fighter.BattleInformation;
import org.springframework.stereotype.Component;

@Component
public class BattleFighterRefresher {

    private final CharacteristicsComputer characteristicsComputer;

    public BattleFighterRefresher(CharacteristicsComputer characteristicsComputer) {
        this.characteristicsComputer = characteristicsComputer;
    }

    public void refresh(BattleFighterDto battleFighterDto, boolean stillFighting) {
        var characteristics = battleFighterDto.getCharacteristics();
        int vitality = characteristics.getVitality();
        int strength = characteristicsComputer.compute(characteristics.getStrength());
        int defense = characteristicsComputer.compute(characteristics.getDefense());
        int resistance = characteristics.getResistance();
        int stamina = characteristics.getStamina();

        int dexterity = characteristicsComputer.compute(characteristics.getDexterity());
        int speed = characteristicsComputer.compute(characteristics.getSpeed());
        int dodge = characteristicsComputer.compute(characteristics.getDodge());

        int courage = characteristicsComputer.compute(characteristics.getCourage());

        var battleInformation = battleFighterDto.getBattleInformation();
        if (battleInformation == null) {
            battleInformation = new BattleInformation();
            battleFighterDto.setBattleInformation(battleInformation);
        }

        battleInformation.setDexterity(dexterity);
        battleInformation.setDefense(defense);
        battleInformation.setSpeed(speed);
        battleInformation.setStrength(strength);
        battleInformation.setDodge(dodge);
        battleInformation.setResistance(resistance);
        battleInformation.setCourage(courage);
        if (!stillFighting) {
            battleInformation.setVitality(vitality);
            battleInformation.setStamina(stamina);
            battleInformation.getFightingStatus().setConscience(true);
        }
    }

    public void refresh(BattleFighterDto battleFighterDto) {
        refresh(battleFighterDto, false);
    }
}
