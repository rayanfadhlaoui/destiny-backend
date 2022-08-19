package ca.destiny.exam.executor.elite;

import ca.destiny.exam.elite.JuniorLieutenantExam;
import ca.destiny.exam.executor.ExamExecutor;
import ca.destiny.exam.executor.advance.OfficerExamExecutor;
import ca.destiny.fighter.ClassEnum;
import org.springframework.stereotype.Component;

@Component
public class JuniorLieutenantExamExecutor extends ExamExecutor {
    protected JuniorLieutenantExamExecutor(OfficerExamExecutor officerExamExecutor, JuniorLieutenantExam juniorLieutenantExam) {
        super(officerExamExecutor, juniorLieutenantExam);
    }

    @Override
    protected int getTargetAmount() {
        return 80;
    }

    @Override
    protected ClassEnum getTargetClass() {
        return ClassEnum.JUNIOR_LIEUTENANT;
    }
}
