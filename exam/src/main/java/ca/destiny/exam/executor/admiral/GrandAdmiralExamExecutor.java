package ca.destiny.exam.executor.admiral;

import ca.destiny.exam.admiral.GrandAdmiralExam;
import ca.destiny.exam.executor.ExamExecutor;
import ca.destiny.fighter.ClassEnum;
import org.springframework.stereotype.Component;

@Component
public class GrandAdmiralExamExecutor extends ExamExecutor {

    public GrandAdmiralExamExecutor(AdmiralExamExecutor admiralExamExecutor,
                                    GrandAdmiralExam grandAdmiralExam) {
        super(admiralExamExecutor, grandAdmiralExam);
    }

    @Override
    protected int getTargetAmount() {
        return 1;
    }

    @Override
    protected ClassEnum getTargetClass() {
        return ClassEnum.GRAND_ADMIRAL;
    }
}
