package ca.destiny.exam.executor.soldier;

import ca.destiny.exam.executor.ExamExecutor;
import ca.destiny.exam.soldier.SecondClassExam;
import ca.destiny.fighter.ClassEnum;
import org.springframework.stereotype.Component;

@Component
public class SecondClassExamExecutor extends ExamExecutor {
    protected SecondClassExamExecutor(ThirdClassExamExecutor thirdClassExamExecutor, SecondClassExam secondClassExam) {
        super(thirdClassExamExecutor, secondClassExam);
    }

    @Override
    protected int getTargetAmount() {
        return 1500;
    }

    @Override
    protected ClassEnum getTargetClass() {
        return ClassEnum.SECOND_CLASS;
    }
}
