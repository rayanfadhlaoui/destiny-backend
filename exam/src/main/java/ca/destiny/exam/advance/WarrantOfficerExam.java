package ca.destiny.exam.advance;

import ca.destiny.exam.Exam;
import ca.destiny.exam.PromotedFilter;
import ca.destiny.exam.round.RoundExecutor;
import ca.destiny.fighter.ClassEnum;
import ca.destiny.weapon.behavior.OptimalWeaponFinder;
import org.springframework.stereotype.Component;

@Component
public class WarrantOfficerExam extends Exam {

    public WarrantOfficerExam(OptimalWeaponFinder optimalWeaponFinder,
                              RoundExecutor roundExecutor,
                              PromotedFilter promotedFilter) {
        super(optimalWeaponFinder, promotedFilter, roundExecutor);
    }

    @Override
    protected ClassEnum getPromotion() {
        return ClassEnum.WARRANT_OFFICER;
    }

    @Override
    protected int getMinimumDamage() {
        return 35;
    }

    @Override
    protected int getMaximumDamage() {
        return 45;
    }

    @Override
    protected String getWeaponName() {
        return "Cooper";
    }

    @Override
    protected int getStaminaNeeded() {
        return 20;
    }

    @Override
    protected int getMinimalDexterity() {
        return 40;
    }

    @Override
    protected int getOptimalDexterity() {
        return 65;
    }

}
