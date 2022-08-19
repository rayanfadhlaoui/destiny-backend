package ca.destiny.exam.admiral;

import ca.destiny.exam.Exam;
import ca.destiny.exam.round.RoundExecutor;
import ca.destiny.fighter.ClassEnum;
import ca.destiny.weapon.behavior.OptimalWeaponFinder;
import org.springframework.stereotype.Component;

@Component
public class SubAdmiralExam extends Exam {

    public SubAdmiralExam(OptimalWeaponFinder optimalWeaponFinder,
                          RoundExecutor roundExecutor) {
        super(optimalWeaponFinder, roundExecutor);
    }

    @Override
    protected ClassEnum getPromotion() {
        return ClassEnum.SUB_ADMIRAL;
    }

    @Override
    protected int getMinimumDamage() {
        return 115;
    }

    @Override
    protected int getMaximumDamage() {
        return 125;
    }

    @Override
    protected String getWeaponName() {
        return "Diamond";
    }

}
