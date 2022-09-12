package ca.destiny.exam.advance;

import ca.destiny.exam.Exam;
import ca.destiny.exam.PromotedFilter;
import ca.destiny.exam.round.RoundExecutor;
import ca.destiny.fighter.ClassEnum;
import ca.destiny.weapon.behavior.OptimalWeaponFinder;
import org.springframework.stereotype.Component;

@Component
public class SergeantMayorExam extends Exam {

    public SergeantMayorExam(OptimalWeaponFinder optimalWeaponFinder,
                             RoundExecutor roundExecutor,
                             PromotedFilter promotedFilter) {
        super(optimalWeaponFinder, promotedFilter, roundExecutor);
    }

    @Override
    protected ClassEnum getPromotion() {
        return ClassEnum.SERGEANT_MAYOR;
    }

    @Override
    protected int getMinimumDamage() {
        return 30;
    }

    @Override
    protected int getMaximumDamage() {
        return 35;
    }

    @Override
    protected String getWeaponName() {
        return "Quality Steel";
    }

    @Override
    protected int getStaminaNeeded() {
        return 15;
    }

    @Override
    protected int getMinimalDexterity() {
        return 30;
    }

    @Override
    protected int getOptimalDexterity() {
        return 55;
    }

}
