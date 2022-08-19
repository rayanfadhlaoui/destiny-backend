package ca.destiny.injury.model;

import ca.destiny.fighter.BattleFighterDto;
import ca.destiny.fighter.BattleInformation;
import ca.destiny.fighter.bodypart.BodyPartDto;

import java.util.List;

public class FighterInjuryInformation {
    private final int damagePercentage;
    private final boolean isKnockout;
    private final List<BodyPartDto> availableBodyParts;
    private final BattleInformation battleInformation;

    public FighterInjuryInformation(int damage, BattleFighterDto battleFighterDto) {
        battleInformation = battleFighterDto.getBattleInformation();
        var characteristics = battleFighterDto.getCharacteristics();

        int maxVitality = characteristics.getVitality();

        availableBodyParts = battleFighterDto.getPerson().getAvailableBodyParts();
        isKnockout = battleInformation.getVitality() <= 0;
        this.damagePercentage = ((damage * 100) / maxVitality);
    }

    public BattleInformation getBattleInformation() {
        return battleInformation;
    }

    public int getDamagePercentage() {
        return damagePercentage;
    }

    public boolean isKnockout() {
        return isKnockout;
    }

    public int getResistance() {
        return battleInformation.getResistance();
    }

    public List<BodyPartDto> getAvailableBodyParts() {
        return availableBodyParts;
    }

    public void setResistance(int resistance) {
        battleInformation.setResistance(resistance);
    }
}
