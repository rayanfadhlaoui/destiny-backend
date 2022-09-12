package ca.destiny.exam.admiral;

import ca.destiny.exam.Exam;
import ca.destiny.exam.PromotedFilter;
import ca.destiny.exam.round.RoundExecutor;
import ca.destiny.fighter.ClassEnum;
import ca.destiny.weapon.behavior.OptimalWeaponFinder;
import org.springframework.stereotype.Component;

@Component
public class GrandAdmiralExam extends Exam {

    public GrandAdmiralExam(OptimalWeaponFinder optimalWeaponFinder,
                            RoundExecutor roundExecutor,
                            PromotedFilter promotedFilter) {
        super(optimalWeaponFinder, promotedFilter, roundExecutor);
    }

    @Override
    protected ClassEnum getPromotion() {
        return ClassEnum.GRAND_ADMIRAL;
    }

    @Override
    protected int getMinimumDamage() {
        return 155;
    }

    @Override
    protected int getMaximumDamage() {
        return 175;
    }

    @Override
    protected String getWeaponName() {
        return "Celestial dragon";
    }

    @Override
    protected int getStaminaNeeded() {
        return 75;
    }

    @Override
    protected int getMinimalDexterity() {
        return 150;
    }

    @Override
    protected int getOptimalDexterity() {
        return 260;
    }
}
