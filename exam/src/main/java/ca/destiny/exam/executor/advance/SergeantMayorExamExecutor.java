package ca.destiny.exam.executor.advance;

import ca.destiny.exam.advance.SergeantMayorExam;
import ca.destiny.exam.executor.ExamExecutor;
import ca.destiny.fighter.ClassEnum;
import org.springframework.stereotype.Component;

@Component
public class SergeantMayorExamExecutor extends ExamExecutor {

    public SergeantMayorExamExecutor(SergeantExamExecutor sergeantExamExecutor, SergeantMayorExam sergeantMayorExam) {
        super(sergeantExamExecutor, sergeantMayorExam);
    }

    @Override
    protected int getTargetAmount() {
        return 250;
    }

    @Override
    protected ClassEnum getTargetClass() {
        return ClassEnum.SERGEANT_MAYOR;
    }
}
