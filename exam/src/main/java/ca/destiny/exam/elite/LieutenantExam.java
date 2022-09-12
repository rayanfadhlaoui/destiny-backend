package ca.destiny.exam.elite;

import ca.destiny.exam.Exam;
import ca.destiny.exam.PromotedFilter;
import ca.destiny.exam.round.RoundExecutor;
import ca.destiny.fighter.ClassEnum;
import ca.destiny.weapon.behavior.OptimalWeaponFinder;
import org.springframework.stereotype.Component;

@Component
public class LieutenantExam extends Exam {

    public LieutenantExam(OptimalWeaponFinder optimalWeaponFinder,
                          RoundExecutor roundExecutor,
                          PromotedFilter promotedFilter) {
        super(optimalWeaponFinder, promotedFilter, roundExecutor);
    }

    @Override
    protected ClassEnum getPromotion() {
        return ClassEnum.LIEUTENANT;
    }

    @Override
    protected int getMinimumDamage() {
        return 65;
    }

    @Override
    protected int getMaximumDamage() {
        return 75;
    }

    @Override
    protected String getWeaponName() {
        return "Quality Silver";
    }

    @Override
    protected int getStaminaNeeded() {
        return 35;
    }

    @Override
    protected int getMinimalDexterity() {
        return 65;
    }

    @Override
    protected int getOptimalDexterity() {
        return 95;
    }
}
