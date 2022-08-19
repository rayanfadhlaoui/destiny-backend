package ca.destiny.exam.admiral;

import ca.destiny.exam.Exam;
import ca.destiny.exam.round.RoundExecutor;
import ca.destiny.fighter.ClassEnum;
import ca.destiny.weapon.behavior.OptimalWeaponFinder;
import org.springframework.stereotype.Component;

@Component
public class ViceAdmiralExam extends Exam {

    public ViceAdmiralExam(OptimalWeaponFinder optimalWeaponFinder,
                           RoundExecutor roundExecutor) {
        super(optimalWeaponFinder, roundExecutor);
    }

    @Override
    protected ClassEnum getPromotion() {
        return ClassEnum.VICE_ADMIRAL;
    }

    @Override
    protected int getMinimumDamage() {
        return 125;
    }

    @Override
    protected int getMaximumDamage() {
        return 135;
    }

    @Override
    protected String getWeaponName() {
        return "Quality Diamond";
    }

}
