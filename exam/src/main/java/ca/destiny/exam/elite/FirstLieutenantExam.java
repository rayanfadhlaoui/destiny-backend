package ca.destiny.exam.elite;

import ca.destiny.exam.Exam;
import ca.destiny.exam.round.RoundExecutor;
import ca.destiny.fighter.ClassEnum;
import ca.destiny.weapon.behavior.OptimalWeaponFinder;
import org.springframework.stereotype.Component;

@Component
public class FirstLieutenantExam extends Exam {

    public FirstLieutenantExam(OptimalWeaponFinder optimalWeaponFinder,
                               RoundExecutor roundExecutor) {
        super(optimalWeaponFinder, roundExecutor);
    }

    @Override
    protected ClassEnum getPromotion() {
        return ClassEnum.FIRST_LIEUTENANT;
    }

    @Override
    protected int getMinimumDamage() {
        return 75;
    }

    @Override
    protected int getMaximumDamage() {
        return 85;
    }

    @Override
    protected String getWeaponName() {
        return "Golden";
    }

}
