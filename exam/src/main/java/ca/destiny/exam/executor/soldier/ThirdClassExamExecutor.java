package ca.destiny.exam.executor.soldier;

import ca.destiny.exam.executor.ExamExecutor;
import ca.destiny.exam.soldier.ThirdClassExam;
import ca.destiny.fighter.ClassEnum;
import org.springframework.stereotype.Component;

@Component
public class ThirdClassExamExecutor extends ExamExecutor {
    protected ThirdClassExamExecutor(ApprenticeExamExecutor apprenticeExamExecutor, ThirdClassExam thirdClassExam) {
        super(apprenticeExamExecutor, thirdClassExam);
    }

    @Override
    protected int getTargetAmount() {
        return 2500;
    }

    @Override
    protected ClassEnum getTargetClass() {
        return ClassEnum.THIRD_CLASS;
    }
}
