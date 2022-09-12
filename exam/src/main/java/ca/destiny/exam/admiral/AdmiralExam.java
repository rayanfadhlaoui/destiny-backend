package ca.destiny.exam.admiral;

import ca.destiny.exam.Exam;
import ca.destiny.exam.PromotedFilter;
import ca.destiny.exam.round.RoundExecutor;
import ca.destiny.fighter.ClassEnum;
import ca.destiny.weapon.behavior.OptimalWeaponFinder;
import org.springframework.stereotype.Component;

@Component
public class AdmiralExam extends Exam {

    public AdmiralExam(OptimalWeaponFinder optimalWeaponFinder,
                       RoundExecutor roundExecutor,
                       PromotedFilter promotedFilter) {
        super(optimalWeaponFinder, promotedFilter, roundExecutor);
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

    @Override
    protected int getStaminaNeeded() {
        return 70;
    }

    @Override
    protected int getMinimalDexterity() {
        return 130;
    }

    @Override
    protected int getOptimalDexterity() {
        return 220;
    }
}
