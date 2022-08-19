package ca.destiny.exam.executor.elite;

import ca.destiny.exam.elite.MayorExam;
import ca.destiny.exam.executor.ExamExecutor;
import ca.destiny.fighter.ClassEnum;
import org.springframework.stereotype.Component;

@Component
public class MayorExamExecutor extends ExamExecutor {
    protected MayorExamExecutor(FirstLieutenantExamExecutor firstLieutenantExamExecutor, MayorExam mayorExam) {
        super(firstLieutenantExamExecutor, mayorExam);
    }

    @Override
    protected int getTargetAmount() {
        return 20;
    }

    @Override
    protected ClassEnum getTargetClass() {
        return ClassEnum.MAYOR;
    }
}
