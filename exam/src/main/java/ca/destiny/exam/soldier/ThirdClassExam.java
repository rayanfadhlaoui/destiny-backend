package ca.destiny.exam.soldier;

import ca.destiny.exam.Exam;
import ca.destiny.exam.round.RoundExecutor;
import ca.destiny.fighter.ClassEnum;
import ca.destiny.weapon.behavior.OptimalWeaponFinder;
import org.springframework.stereotype.Component;

@Component
public class ThirdClassExam extends Exam {

    public ThirdClassExam(OptimalWeaponFinder optimalWeaponFinder,
                          RoundExecutor roundExecutor) {
        super(optimalWeaponFinder, roundExecutor);
    }

    @Override
    protected ClassEnum getPromotion() {
        return ClassEnum.THIRD_CLASS;
    }

    @Override
    protected int getMinimumDamage() {
        return 10;
    }

    @Override
    protected int getMaximumDamage() {
        return 15;
    }

    @Override
    protected String getWeaponName() {
        return "Quality Wood";
    }
}
