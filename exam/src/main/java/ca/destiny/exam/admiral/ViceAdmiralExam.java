package ca.destiny.exam.admiral;

import ca.destiny.exam.Exam;
import ca.destiny.exam.PromotedFilter;
import ca.destiny.exam.round.RoundExecutor;
import ca.destiny.fighter.ClassEnum;
import ca.destiny.weapon.behavior.OptimalWeaponFinder;
import org.springframework.stereotype.Component;

@Component
public class ViceAdmiralExam extends Exam {

    public ViceAdmiralExam(OptimalWeaponFinder optimalWeaponFinder,
                           RoundExecutor roundExecutor,
                           PromotedFilter promotedFilter) {
        super(optimalWeaponFinder, promotedFilter, roundExecutor);
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

    @Override
    protected int getStaminaNeeded() {
        return 65;
    }

    @Override
    protected int getMinimalDexterity() {
        return 110;
    }

    @Override
    protected int getOptimalDexterity() {
        return 203;
    }
}
