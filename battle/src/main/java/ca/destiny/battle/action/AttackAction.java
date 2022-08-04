package ca.destiny.battle.action;


import ca.destiny.fighter.BattleFighterDto;
import ca.destiny.fighter.BattleInformation;
import ca.destiny.other.RandomNumberGeneratorService;

public class AttackAction implements Action {
    private final HitService hitService;
    private final DamageService damageService;
    private final RandomNumberGeneratorService randomNumberGeneratorService;
    private final BattleInformation defensiveBattleInformation;
    private final BattleInformation activeBattleInformation;

    public AttackAction(RandomNumberGeneratorService randomNumberGeneratorService,
                        BattleFighterDto activeFighter,
                        BattleFighterDto inactiveFighter) {
        this.randomNumberGeneratorService = randomNumberGeneratorService;
        this.hitService = new HitService();
        this.damageService = new DamageService();
        activeBattleInformation = activeFighter.getBattleInformation();
        defensiveBattleInformation = inactiveFighter.getBattleInformation();
    }

    @Override
    public boolean execute() {
        if (fighterHasHit()) {
            int damage = getDamage();
            Integer currentVitality = defensiveBattleInformation.getVitality();
            defensiveBattleInformation.setVitality(currentVitality - damage);
        }
        return false;
    }

    private int getDamage() {
        Integer minimumDamage = activeBattleInformation.getMinimumDamage();
        Integer maximumDamage = activeBattleInformation.getMaximumDamage();
        Integer defense = defensiveBattleInformation.getDefense();
        Range range = damageService.getDamage(new Range(minimumDamage, maximumDamage), defense);
        return randomNumberGeneratorService.getRandomNumberInts(range.getLeft(), range.getRight());
    }

    private boolean fighterHasHit() {
        Integer dexterity = activeBattleInformation.getDexterity();
        Integer dodge = defensiveBattleInformation.getDodge();
        int hitPercentage = hitService.hitPercentage(dexterity, dodge);
        return randomNumberGeneratorService.getRandomNumberInts(0, 100) <= hitPercentage;
    }


}
