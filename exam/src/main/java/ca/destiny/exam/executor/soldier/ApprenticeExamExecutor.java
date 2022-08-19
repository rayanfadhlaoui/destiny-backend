package ca.destiny.exam.executor.soldier;

import ca.destiny.evolution.creation.FighterFactory;
import ca.destiny.exam.executor.ExamExecutor;
import ca.destiny.exam.soldier.ApprenticeExam;
import ca.destiny.fighter.BattleFighterDto;
import ca.destiny.fighter.ClassEnum;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ApprenticeExamExecutor extends ExamExecutor {

    private final ApprenticeExam apprenticeExam;
    private final FighterFactory fighterFactory;

    protected ApprenticeExamExecutor(ApprenticeExam apprenticeExam,
                                     FighterFactory fighterFactory) {
        super(null, apprenticeExam);
        this.apprenticeExam = apprenticeExam;
        this.fighterFactory = fighterFactory;
    }

    @Override
    protected int getTargetAmount() {
        return 3000;
    }

    @Override
    protected ClassEnum getTargetClass() {
        return ClassEnum.APPRENTICE;
    }

    @Override
    public List<BattleFighterDto> execute(List<BattleFighterDto> fighters, int needed) {
        long currentAmount = fighters.stream()
                .map(BattleFighterDto::getClassEnum)
                .filter(v -> v == getTargetClass())
                .count();

        long noClassAmount = fighters.stream()
                .map(BattleFighterDto::getClassEnum)
                .filter(v -> v == ClassEnum.NO_CLASS)
                .count();
        int targetAmount = getTargetAmount() + needed;
        if (needed > noClassAmount) {
            List<BattleFighterDto> newFighters = fighterFactory.create((int) ((needed - noClassAmount) + 3000));
            fighters.addAll(newFighters);
            apprenticeExam.exam(fighters, needed);
        } else if (currentAmount < targetAmount) {
            apprenticeExam.exam(fighters, needed);
        }
        return fighters;
    }
}
