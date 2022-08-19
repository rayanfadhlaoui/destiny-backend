package ca.destiny.exam.admiral;

import ca.destiny.exam.Exam;
import ca.destiny.exam.round.RoundExecutor;
import ca.destiny.fighter.ClassEnum;
import ca.destiny.weapon.behavior.OptimalWeaponFinder;
import org.springframework.stereotype.Component;

@Component
public class RearAdmiralExam extends Exam {

    public RearAdmiralExam(OptimalWeaponFinder optimalWeaponFinder,
                       RoundExecutor roundExecutor) {
        super(optimalWeaponFinder, roundExecutor);
    }

    @Override
    protected ClassEnum getPromotion() {
        return ClassEnum.REAR_ADMIRAL;
    }

    @Override
    protected int getMinimumDamage() {
        return 105;
    }

    @Override
    protected int getMaximumDamage() {
        return 115;
    }

    @Override
    protected String getWeaponName() {
        return "Quality Rubis";
    }

}
