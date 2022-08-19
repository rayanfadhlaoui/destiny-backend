package ca.destiny.exam.executor.admiral;

import ca.destiny.exam.admiral.AdmiralExam;
import ca.destiny.exam.executor.ExamExecutor;
import ca.destiny.fighter.ClassEnum;
import org.springframework.stereotype.Component;

@Component
public class AdmiralExamExecutor extends ExamExecutor {

    public AdmiralExamExecutor(ViceAdmiralExamExecutor viceAdmiralExamExecutor, AdmiralExam admiralExam) {
        super(viceAdmiralExamExecutor, admiralExam);
    }

    @Override
    protected int getTargetAmount() {
        return 3;
    }

    @Override
    protected ClassEnum getTargetClass() {
        return ClassEnum.ADMIRAL;
    }
}
