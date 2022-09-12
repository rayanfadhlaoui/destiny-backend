package ca.destiny.exam.elite;

import ca.destiny.exam.Exam;
import ca.destiny.exam.PromotedFilter;
import ca.destiny.exam.round.RoundExecutor;
import ca.destiny.fighter.ClassEnum;
import ca.destiny.weapon.behavior.OptimalWeaponFinder;
import org.springframework.stereotype.Component;

@Component
public class MayorExam extends Exam {

    public MayorExam(OptimalWeaponFinder optimalWeaponFinder,
                     RoundExecutor roundExecutor,
                     PromotedFilter promotedFilter) {
        super(optimalWeaponFinder, promotedFilter, roundExecutor);
    }

    @Override
    protected ClassEnum getPromotion() {
        return ClassEnum.MAYOR;
    }

    @Override
    protected int getMinimumDamage() {
        return 85;
    }

    @Override
    protected int getMaximumDamage() {
        return 95;
    }

    @Override
    protected String getWeaponName() {
        return "Quality Golden";
    }

    @Override
    protected int getStaminaNeeded() {
        return 45;
    }

    @Override
    protected int getMinimalDexterity() {
        return 80;
    }

    @Override
    protected int getOptimalDexterity() {
        return 125;
    }
}
