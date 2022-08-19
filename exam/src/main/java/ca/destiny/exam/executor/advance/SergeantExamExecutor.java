package ca.destiny.exam.executor.advance;

import ca.destiny.exam.advance.SergeantExam;
import ca.destiny.exam.executor.ExamExecutor;
import ca.destiny.exam.executor.soldier.FirstClassExamExecutor;
import ca.destiny.fighter.ClassEnum;
import org.springframework.stereotype.Component;

@Component
public class SergeantExamExecutor extends ExamExecutor {

    public SergeantExamExecutor(FirstClassExamExecutor firstClassExamExecutor, SergeantExam sergeantExam) {
        super(firstClassExamExecutor, sergeantExam);
    }

    @Override
    protected int getTargetAmount() {
        return 400;
    }

    @Override
    protected ClassEnum getTargetClass() {
        return ClassEnum.SERGEANT;
    }
}
