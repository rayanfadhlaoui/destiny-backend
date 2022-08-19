package ca.destiny.exam.elite;

import ca.destiny.exam.Exam;
import ca.destiny.exam.round.RoundExecutor;
import ca.destiny.fighter.ClassEnum;
import ca.destiny.weapon.behavior.OptimalWeaponFinder;
import org.springframework.stereotype.Component;

@Component
public class MayorExam extends Exam {

    public MayorExam(OptimalWeaponFinder optimalWeaponFinder,
                       RoundExecutor roundExecutor) {
        super(optimalWeaponFinder, roundExecutor);
    }

    @Override
    protected ClassEnum getPromotion() {
        return ClassEnum.MAYOR;
    }

    @Override
    protected int getMinimumDamage() {
        return 85;
    }

    @Override
    protected int getMaximumDamage() {
        return 95;
    }

    @Override
    protected String getWeaponName() {
        return "Quality Golden";
    }

}