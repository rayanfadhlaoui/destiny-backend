package ca.destiny.exam.executor;

import ca.destiny.exam.Exam;
import ca.destiny.fighter.BattleFighterDto;
import ca.destiny.fighter.ClassEnum;
import ca.destiny.fighter.equipment.weapon.WeaponDto;

import java.util.List;
import java.util.function.Supplier;

public abstract class ExamExecutor {

    private final ExamExecutor examExecutor;
    private final Exam exam;

    protected ExamExecutor(ExamExecutor examExecutor, Exam exam) {
        this.examExecutor = examExecutor;
        this.exam = exam;
    }

    public List<BattleFighterDto> execute(List<BattleFighterDto> fighters, int missingFighter, List<Supplier<WeaponDto>> weaponSuppliers) {
        long currentAmount = fighters.stream()
                .map(BattleFighterDto::getClassEnum)
                .filter(v -> v == getTargetClass())
                .count();
        int targetAmount = (int) (getTargetAmount() - currentAmount);
        examExecutor.execute(fighters, missingFighter + targetAmount, weaponSuppliers);
        if (getTargetClass() != ClassEnum.GRAND_ADMIRAL) {
            exam.exam(fighters, Math.max(missingFighter, getTargetAmount()), weaponSuppliers);
        } else {
            exam.exam(fighters, 1, weaponSuppliers);
        }
        return fighters;
    }

    protected abstract int getTargetAmount();

    protected abstract ClassEnum getTargetClass();
}
