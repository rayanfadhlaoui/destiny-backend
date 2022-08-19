package ca.destiny.exam.executor;

import ca.destiny.exam.Exam;
import ca.destiny.fighter.BattleFighterDto;
import ca.destiny.fighter.ClassEnum;

import java.util.List;

public abstract class ExamExecutor {

    private final ExamExecutor examExecutor;
    private final Exam exam;

    protected ExamExecutor(ExamExecutor examExecutor, Exam exam) {
        this.examExecutor = examExecutor;
        this.exam = exam;
    }

    public List<BattleFighterDto> execute(List<BattleFighterDto> fighters, int needed) {
        long currentAmount = fighters.stream()
                .map(BattleFighterDto::getClassEnum)
                .filter(v -> v == getTargetClass())
                .count();
        int targetAmount = getTargetAmount() + needed;
        if (currentAmount < targetAmount) {
            examExecutor.execute(fighters, (int) (targetAmount - currentAmount));
            exam.exam(fighters, needed);
        } else {
            examExecutor.execute(fighters, 0);
        }
        return fighters;
    }

    protected abstract int getTargetAmount();

    protected abstract ClassEnum getTargetClass();
}
