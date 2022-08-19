package ca.destiny.exam.executor.elite;

import ca.destiny.exam.elite.LieutenantExam;
import ca.destiny.exam.executor.ExamExecutor;
import ca.destiny.fighter.ClassEnum;
import org.springframework.stereotype.Component;

@Component
public class LieutenantExamExecutor extends ExamExecutor {
    protected LieutenantExamExecutor(JuniorLieutenantExamExecutor juniorLieutenantExamExecutor, LieutenantExam lieutenantExam) {
        super(juniorLieutenantExamExecutor, lieutenantExam);
    }

    @Override
    protected int getTargetAmount() {
        return 50;
    }

    @Override
    protected ClassEnum getTargetClass() {
        return ClassEnum.LIEUTENANT;
    }
}
