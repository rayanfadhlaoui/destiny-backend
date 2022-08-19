package ca.destiny.exam.soldier;

import ca.destiny.exam.Exam;
import ca.destiny.exam.round.RoundExecutor;
import ca.destiny.fighter.ClassEnum;
import ca.destiny.weapon.behavior.OptimalWeaponFinder;
import org.springframework.stereotype.Component;

@Component
public class SecondClassExam extends Exam {

    public SecondClassExam(OptimalWeaponFinder optimalWeaponFinder,
                           RoundExecutor roundExecutor) {
        super(optimalWeaponFinder, roundExecutor);
    }

    @Override
    protected ClassEnum getPromotion() {
        return ClassEnum.SECOND_CLASS;
    }

    @Override
    protected int getMinimumDamage() {
        return 15;
    }

    @Override
    protected int getMaximumDamage() {
        return 20;
    }

    @Override
    protected String getWeaponName() {
        return "Iron";
    }
}
