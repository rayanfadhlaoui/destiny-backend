package ca.destiny.exam.executor.admiral;

import ca.destiny.exam.admiral.SubAdmiralExam;
import ca.destiny.exam.executor.ExamExecutor;
import ca.destiny.fighter.ClassEnum;
import org.springframework.stereotype.Component;

@Component
public class SubAdmiralExamExecutor extends ExamExecutor {

    protected SubAdmiralExamExecutor(RearAdmiralExamExecutor rearAdmiralExamExecutor, SubAdmiralExam subAdmiralExam) {
        super(rearAdmiralExamExecutor, subAdmiralExam);
    }

    @Override
    protected int getTargetAmount() {
        return 5;
    }

    @Override
    protected ClassEnum getTargetClass() {
        return ClassEnum.SUB_ADMIRAL;
    }
}
