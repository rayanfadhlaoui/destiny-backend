package ca.destiny.exam.executor.soldier;

import ca.destiny.evolution.creation.FighterFactory;
import ca.destiny.exam.executor.ExamExecutor;
import ca.destiny.exam.soldier.ApprenticeExam;
import ca.destiny.fighter.BattleFighterDto;
import ca.destiny.fighter.ClassEnum;
import ca.destiny.fighter.equipment.weapon.WeaponDto;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.function.Supplier;

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
    public List<BattleFighterDto> execute(List<BattleFighterDto> fighters,
                                          int missingFighter,
                                          List<Supplier<WeaponDto>> weaponSuppliers) {
            long noClassAmount = fighters.stream()
                .map(BattleFighterDto::getClassEnum)
                .filter(v -> v == ClassEnum.NO_CLASS)
                .count();
        if (missingFighter > noClassAmount) {
            List<BattleFighterDto> newFighters = fighterFactory.create((int) ((missingFighter - noClassAmount) + getTargetAmount()));
            fighters.addAll(newFighters);
        }
        apprenticeExam.exam(fighters, missingFighter, weaponSuppliers);
        return fighters;
    }
}
