package ca.destiny.exam.elite;

import ca.destiny.exam.Exam;
import ca.destiny.exam.round.RoundExecutor;
import ca.destiny.fighter.ClassEnum;
import ca.destiny.weapon.behavior.OptimalWeaponFinder;
import org.springframework.stereotype.Component;

@Component
public class ColonelExam extends Exam {

    public ColonelExam(OptimalWeaponFinder optimalWeaponFinder,
                       RoundExecutor roundExecutor) {
        super(optimalWeaponFinder, roundExecutor);
    }

    @Override
    protected ClassEnum getPromotion() {
        return ClassEnum.COLONEL;
    }

    @Override
    protected int getMinimumDamage() {
        return 95;
    }

    @Override
    protected int getMaximumDamage() {
        return 105;
    }

    @Override
    protected String getWeaponName() {
        return "Rubis";
    }
}
