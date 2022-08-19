package ca.destiny.exam.elite;

import ca.destiny.exam.Exam;
import ca.destiny.exam.round.RoundExecutor;
import ca.destiny.fighter.ClassEnum;
import ca.destiny.weapon.behavior.OptimalWeaponFinder;
import org.springframework.stereotype.Component;

@Component
public class JuniorLieutenantExam extends Exam {

    public JuniorLieutenantExam(OptimalWeaponFinder optimalWeaponFinder,
                                RoundExecutor roundExecutor) {
        super(optimalWeaponFinder, roundExecutor);
    }

    @Override
    protected ClassEnum getPromotion() {
        return ClassEnum.JUNIOR_LIEUTENANT;
    }

    @Override
    protected int getMinimumDamage() {
        return 55;
    }

    @Override
    protected int getMaximumDamage() {
        return 65;
    }

    @Override
    protected String getWeaponName() {
        return "Silver";
    }

}
