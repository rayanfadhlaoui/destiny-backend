package ca.destiny.exam.soldier;

import ca.destiny.exam.Exam;
import ca.destiny.exam.PromotedFilter;
import ca.destiny.exam.round.RoundExecutor;
import ca.destiny.fighter.ClassEnum;
import ca.destiny.weapon.behavior.OptimalWeaponFinder;
import org.springframework.stereotype.Component;

@Component
public class FirstClassExam extends Exam {

    public FirstClassExam(OptimalWeaponFinder optimalWeaponFinder,
                          RoundExecutor roundExecutor,
                          PromotedFilter promotedFilter) {
        super(optimalWeaponFinder, promotedFilter, roundExecutor);
    }

    @Override
    protected ClassEnum getPromotion() {
        return ClassEnum.FIRST_CLASS;
    }

    @Override
    protected int getMinimumDamage() {
        return 20;
    }

    @Override
    protected int getMaximumDamage() {
        return 25;
    }

    @Override
    protected String getWeaponName() {
        return "Quality Iron";
    }

    @Override
    protected int getStaminaNeeded() {
        return 7;
    }

    @Override
    protected int getMinimalDexterity() {
        return 20;
    }

    @Override
    protected int getOptimalDexterity() {
        return 39;
    }
}
