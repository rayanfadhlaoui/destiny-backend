package ca.destiny.exam.executor.admiral;

import ca.destiny.exam.admiral.ViceAdmiralExam;
import ca.destiny.exam.executor.ExamExecutor;
import ca.destiny.fighter.ClassEnum;
import org.springframework.stereotype.Component;

@Component
public class ViceAdmiralExamExecutor extends ExamExecutor {

    public ViceAdmiralExamExecutor(SubAdmiralExamExecutor subAdmiralExamExecutor, ViceAdmiralExam viceAdmiralExam) {
        super(subAdmiralExamExecutor, viceAdmiralExam);
    }

    @Override
    protected int getTargetAmount() {
        return 4;
    }

    @Override
    protected ClassEnum getTargetClass() {
        return ClassEnum.VICE_ADMIRAL;
    }
}
