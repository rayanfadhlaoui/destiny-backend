package ca.destiny.exam;

import ca.destiny.exam.admiral.GrandAdmiralExam;
import ca.destiny.fighter.BattleFighterDto;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class OverallExam {

    private final GrandAdmiralExam grandAdmiralExam;

    public OverallExam(GrandAdmiralExam grandAdmiralExam) {
        this.grandAdmiralExam = grandAdmiralExam;
    }

    public void overallExam(List<BattleFighterDto> fighters) {
//        grandAdmiralExam.execute(fighters);
    }

}
