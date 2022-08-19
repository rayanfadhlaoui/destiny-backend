package ca.destiny.exam.executor.admiral;

import ca.destiny.exam.admiral.RearAdmiralExam;
import ca.destiny.exam.executor.ExamExecutor;
import ca.destiny.exam.executor.elite.ColonelExamExecutor;
import ca.destiny.fighter.ClassEnum;
import org.springframework.stereotype.Component;

@Component
public class RearAdmiralExamExecutor extends ExamExecutor {
    protected RearAdmiralExamExecutor(ColonelExamExecutor colonelExamExecutor, RearAdmiralExam rearAdmiralExam) {
        super(colonelExamExecutor, rearAdmiralExam);
    }

    @Override
    protected int getTargetAmount() {
        return 6;
    }

    @Override
    protected ClassEnum getTargetClass() {
        return ClassEnum.REAR_ADMIRAL;
    }
}
