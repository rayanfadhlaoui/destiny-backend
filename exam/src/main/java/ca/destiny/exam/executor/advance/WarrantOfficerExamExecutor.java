package ca.destiny.exam.executor.advance;

import ca.destiny.exam.advance.WarrantOfficerExam;
import ca.destiny.exam.executor.ExamExecutor;
import ca.destiny.exam.executor.admiral.SubAdmiralExamExecutor;
import ca.destiny.fighter.ClassEnum;
import org.springframework.stereotype.Component;

@Component
public class WarrantOfficerExamExecutor extends ExamExecutor {

    public WarrantOfficerExamExecutor(SergeantMayorExamExecutor sergeantMayorExamExecutor, WarrantOfficerExam warrantOfficerExam) {
        super(sergeantMayorExamExecutor, warrantOfficerExam);
    }

    @Override
    protected int getTargetAmount() {
        return 150;
    }

    @Override
    protected ClassEnum getTargetClass() {
        return ClassEnum.WARRANT_OFFICER;
    }
}
