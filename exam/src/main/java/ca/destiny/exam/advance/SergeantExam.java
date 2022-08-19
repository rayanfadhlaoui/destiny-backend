package ca.destiny.exam.advance;

import ca.destiny.exam.Exam;
import ca.destiny.exam.round.RoundExecutor;
import ca.destiny.fighter.ClassEnum;
import ca.destiny.weapon.behavior.OptimalWeaponFinder;
import org.springframework.stereotype.Component;

@Component
public class SergeantExam extends Exam {

    public SergeantExam(OptimalWeaponFinder optimalWeaponFinder,
                        RoundExecutor roundExecutor) {
        super(optimalWeaponFinder, roundExecutor);
    }

    @Override
    protected ClassEnum getPromotion() {
        return ClassEnum.SERGEANT;
    }

    @Override
    protected int getMinimumDamage() {
        return 25;
    }

    @Override
    protected int getMaximumDamage() {
        return 30;
    }

    @Override
    protected String getWeaponName() {
        return "Steel";
    }

}
