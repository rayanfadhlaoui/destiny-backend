package ca.destiny.exam.advance;

import ca.destiny.exam.Exam;
import ca.destiny.exam.round.RoundExecutor;
import ca.destiny.fighter.ClassEnum;
import ca.destiny.weapon.behavior.OptimalWeaponFinder;
import org.springframework.stereotype.Component;

@Component
public class OfficerExam extends Exam {

    public OfficerExam(OptimalWeaponFinder optimalWeaponFinder,
                       RoundExecutor roundExecutor) {
        super(optimalWeaponFinder, roundExecutor);
    }

    @Override
    protected ClassEnum getPromotion() {
        return ClassEnum.OFFICER;
    }

    @Override
    protected int getMinimumDamage() {
        return 45;
    }

    @Override
    protected int getMaximumDamage() {
        return 55;
    }

    @Override
    protected String getWeaponName() {
        return "Quality Cooper";
    }

}
