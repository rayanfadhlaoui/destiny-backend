package ca.destiny.exam.executor.elite;

import ca.destiny.exam.elite.ColonelExam;
import ca.destiny.exam.executor.ExamExecutor;
import ca.destiny.fighter.ClassEnum;
import org.springframework.stereotype.Component;

@Component
public class ColonelExamExecutor extends ExamExecutor {
    protected ColonelExamExecutor(MayorExamExecutor mayorExamExecutor, ColonelExam colonelExam) {
        super(mayorExamExecutor, colonelExam);
    }

    @Override
    protected int getTargetAmount() {
        return 15;
    }

    @Override
    protected ClassEnum getTargetClass() {
        return ClassEnum.COLONEL;
    }
}
