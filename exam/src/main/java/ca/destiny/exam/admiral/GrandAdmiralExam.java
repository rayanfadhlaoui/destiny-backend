package ca.destiny.exam.admiral;

import ca.destiny.exam.Exam;
import ca.destiny.exam.round.RoundExecutor;
import ca.destiny.fighter.ClassEnum;
import ca.destiny.weapon.behavior.OptimalWeaponFinder;
import org.springframework.stereotype.Component;

@Component
public class GrandAdmiralExam extends Exam {

    public GrandAdmiralExam(OptimalWeaponFinder optimalWeaponFinder,
                       RoundExecutor roundExecutor) {
        super(optimalWeaponFinder, roundExecutor);
    }

    @Override
    protected ClassEnum getPromotion() {
        return ClassEnum.GRAND_ADMIRAL;
    }

    @Override
    protected int getMinimumDamage() {
        return 155;
    }

    @Override
    protected int getMaximumDamage() {
        return 175;
    }

    @Override
    protected String getWeaponName() {
        return "Celestial dragon";
    }
}
