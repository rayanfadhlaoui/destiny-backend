package ca.destiny.exam.soldier;

import ca.destiny.exam.Exam;
import ca.destiny.exam.round.RoundExecutor;
import ca.destiny.fighter.ClassEnum;
import ca.destiny.weapon.behavior.OptimalWeaponFinder;
import org.springframework.stereotype.Component;

@Component
public class ApprenticeExam extends Exam {

    public ApprenticeExam(OptimalWeaponFinder optimalWeaponFinder,
                          RoundExecutor roundExecutor) {
        super(optimalWeaponFinder, roundExecutor);
    }

    @Override
    protected ClassEnum getPromotion() {
        return ClassEnum.APPRENTICE;
    }

    @Override
    protected int getMinimumDamage() {
        return 5;
    }

    @Override
    protected int getMaximumDamage() {
        return 10;
    }

    @Override
    protected String getWeaponName() {
        return "Wood";
    }
}
