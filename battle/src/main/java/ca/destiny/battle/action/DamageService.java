package ca.destiny.battle.action;

public class DamageService {

    private final DefenseService defenseService;

    public DamageService() {
        this.defenseService = new DefenseService();
    }

    public Range getDamage(Range damageRange, int defense) {
        int damageReduction = defenseService.getDamageReduction(defense);
        int minimumDamage = Math.max(1, damageRange.getLeft() - damageReduction);
        int maximumDamage = Math.max(2, damageRange.getRight() - damageReduction);
        return new Range(minimumDamage, maximumDamage);
    }
}
