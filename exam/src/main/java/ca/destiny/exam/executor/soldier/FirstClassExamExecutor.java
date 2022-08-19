package ca.destiny.exam.executor.soldier;

import ca.destiny.exam.executor.ExamExecutor;
import ca.destiny.exam.soldier.FirstClassExam;
import ca.destiny.fighter.ClassEnum;
import org.springframework.stereotype.Component;

@Component
public class FirstClassExamExecutor extends ExamExecutor {
    protected FirstClassExamExecutor(SecondClassExamExecutor secondClassExamExecutor, FirstClassExam firstClassExam) {
        super(secondClassExamExecutor, firstClassExam);
    }

    @Override
    protected int getTargetAmount() {
        return 800;
    }

    @Override
    protected ClassEnum getTargetClass() {
        return ClassEnum.FIRST_CLASS;
    }
}
