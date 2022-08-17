package ca.destiny.battle.action;

import ca.destiny.fighter.BattleFighterDto;
import ca.destiny.fighter.BattleInformation;
import ca.destiny.fighter.experience.ExperienceDto;
import ca.destiny.injury.InjuryService;
import ca.destiny.other.RandomNumberGeneratorService;
import ca.destiny.other.Range;

public abstract class AttackAction implements Action {
    private final HitService hitService;
    private final DamageService damageService;
    private final RandomNumberGeneratorService randomNumberGeneratorService;
    private final InjuryService injuryService;
    private final BattleFighterDto defensiveBattleFighter;
    private final BattleFighterDto activeBattleFighter;

    public AttackAction(RandomNumberGeneratorService randomNumberGeneratorService,
                        InjuryService injuryService,
                        BattleFighterDto activeFighter,
                        BattleFighterDto inactiveFighter) {
        this.randomNumberGeneratorService = randomNumberGeneratorService;
        this.injuryService = injuryService;
        this.hitService = new HitService();
        this.damageService = new DamageService();
        defensiveBattleFighter = inactiveFighter;
        activeBattleFighter = activeFighter;
    }

    @Override
    public boolean execute() {
        var activeBattleInformation = activeBattleFighter.getBattleInformation();
        var defensiveBattleInformation = defensiveBattleFighter.getBattleInformation();
        if (fighterHasHit(activeBattleInformation, defensiveBattleInformation)) {
            int damage = getDamage(defensiveBattleInformation);
            int currentVitality = defensiveBattleInformation.getVitality();
            int vitality = currentVitality - damage;
            defensiveBattleInformation.setVitality(vitality);
            ifWonAddExperience(vitality);
//            var fighterInjuryInformation = new FighterInjuryInformation(damage, defensiveBattleFighter);
//            injuryService.inflictInjuryIfNeeded(fighterInjuryInformation, activeBattleFighter.getEquipmentDto().getRightWeapon());
        }
        return false;
    }

    private int getDamage(BattleInformation defensiveBattleInformation) {
        int defense = defensiveBattleInformation.getDefense();
        Range range = damageService.getDamage(activeBattleFighter, defense);
        int damage = randomNumberGeneratorService.getRandomNumberInts(range.getLeft(), range.getRight());
        damage = applyDamageBonus(damage);
        return damage;
    }

    private boolean fighterHasHit(BattleInformation activeBattleInformation, BattleInformation defensiveBattleInformation) {
        int dexterity = activeBattleInformation.getDexterity();
        int dodge = defensiveBattleInformation.getDodge();
        int hitPercentage = hitService.hitPercentage(dexterity, dodge);
        hitPercentage = applyAccuracyBonus(hitPercentage);
        return randomNumberGeneratorService.getRandomNumberInts(0, 1000) <= hitPercentage;
    }

    protected abstract int applyAccuracyBonus(int hitPercentage);

    protected abstract int applyDamageBonus(int damage);

    private void ifWonAddExperience(int vitality) {
        if (vitality <= 0) {
            ExperienceDto experience = activeBattleFighter.getExperience();
            int currentExperience = experience.getCurrentExperience();
            int worth = defensiveBattleFighter.getExperience().getWorth();
            experience.setCurrentExperience(currentExperience + worth);
        }
    }

}
