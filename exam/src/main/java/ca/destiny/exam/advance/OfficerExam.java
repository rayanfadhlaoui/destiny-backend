package ca.destiny.exam.advance;

import ca.destiny.exam.Exam;
import ca.destiny.exam.PromotedFilter;
import ca.destiny.exam.round.RoundExecutor;
import ca.destiny.fighter.ClassEnum;
import ca.destiny.weapon.behavior.OptimalWeaponFinder;
import org.springframework.stereotype.Component;

@Component
public class OfficerExam extends Exam {

    public OfficerExam(OptimalWeaponFinder optimalWeaponFinder,
                       RoundExecutor roundExecutor,
                       PromotedFilter promotedFilter) {
        super(optimalWeaponFinder, promotedFilter, roundExecutor);
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

    @Override
    protected int getStaminaNeeded() {
        return 25;
    }

    @Override
    protected int getMinimalDexterity() {
        return 50;
    }

    @Override
    protected int getOptimalDexterity() {
        return 80;
    }

}
