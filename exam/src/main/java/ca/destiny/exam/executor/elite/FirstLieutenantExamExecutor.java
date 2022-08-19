package ca.destiny.exam.executor.elite;

import ca.destiny.exam.elite.FirstLieutenantExam;
import ca.destiny.exam.executor.ExamExecutor;
import ca.destiny.fighter.ClassEnum;
import org.springframework.stereotype.Component;

@Component
public class FirstLieutenantExamExecutor extends ExamExecutor {
    protected FirstLieutenantExamExecutor(LieutenantExamExecutor lieutenantExamExecutor, FirstLieutenantExam firstLieutenantExam) {
        super(lieutenantExamExecutor, firstLieutenantExam);
    }

    @Override
    protected int getTargetAmount() {
        return 30;
    }

    @Override
    protected ClassEnum getTargetClass() {
        return ClassEnum.FIRST_LIEUTENANT;
    }
}
