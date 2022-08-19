package ca.destiny.exam.executor.advance;

import ca.destiny.exam.advance.OfficerExam;
import ca.destiny.exam.executor.ExamExecutor;
import ca.destiny.fighter.ClassEnum;
import org.springframework.stereotype.Component;

@Component
public class OfficerExamExecutor extends ExamExecutor {

    public OfficerExamExecutor(WarrantOfficerExamExecutor warrantOfficerExamExecutor, OfficerExam officerExam) {
        super(warrantOfficerExamExecutor, officerExam);
    }

    @Override
    protected int getTargetAmount() {
        return 100;
    }

    @Override
    protected ClassEnum getTargetClass() {
        return ClassEnum.OFFICER;
    }
}
