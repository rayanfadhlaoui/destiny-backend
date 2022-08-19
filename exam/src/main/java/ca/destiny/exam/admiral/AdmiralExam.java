package ca.destiny.exam.admiral;

import ca.destiny.exam.Exam;
import ca.destiny.exam.round.RoundExecutor;
import ca.destiny.fighter.ClassEnum;
import ca.destiny.weapon.behavior.OptimalWeaponFinder;
import org.springframework.stereotype.Component;

@Component
public class AdmiralExam extends Exam {

    public AdmiralExam(OptimalWeaponFinder optimalWeaponFinder,
                       RoundExecutor roundExecutor) {
        super(optimalWeaponFinder, roundExecutor);
    }

    @Override
    protected ClassEnum getPromotion() {
        return ClassEnum.ADMIRAL;
    }

    @Override
    protected int getMinimumDamage() {
        return 135;
    }

    @Override
    protected int getMaximumDamage() {
        return 145;
    }

    @Override
    protected String getWeaponName() {
        return "Dragon";
    }

}
