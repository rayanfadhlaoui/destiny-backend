package ca.destiny.exam;

import ca.destiny.fighter.BattleFighterDto;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Component
public class PromotedFilter {

    public Map<ExamStatus, List<BattleFighterDto>> sort(List<BattleFighterDto> participants, Map<Long, Integer> score, int laureate) {
        List<BattleFighterDto> sorted = score.entrySet()
                .stream()
                .sorted((o1, o2) -> o2.getValue().compareTo(o1.getValue()))
                .map(Map.Entry::getKey)
                .map(id -> participants.stream().filter(a -> a.getId() == id).findFirst().orElseThrow(() -> new RuntimeException(String.valueOf(id))))
                .filter(f -> f.getBattleInformation().getFightingStatus().isAlive())
                .collect(Collectors.toList());

        List<BattleFighterDto> potentialPromoted = new ArrayList<>();
        List<BattleFighterDto> promoted = new ArrayList<>();
        List<BattleFighterDto> rejected = new ArrayList<>();
        Map<ExamStatus, List<BattleFighterDto>> result = new HashMap<>();
        int count = 0;
        int currentScore = 0;
        boolean areRejected = false;
        for (BattleFighterDto fighter : sorted) {
            if (!areRejected) {
                int localScore = score.get(fighter.getId());
                if (localScore != currentScore && count <= laureate) {
                    promoted.addAll(potentialPromoted);
                    potentialPromoted.clear();
                    currentScore = localScore;
                } else if (localScore != currentScore) {
                    rejected.add(fighter);
                    areRejected = true;
                }
                if (!areRejected) {
                    potentialPromoted.add(fighter);
                    int age = fighter.getPerson().getAge();
                    fighter.getPerson().setAge(age + 1);
                    count++;
                }
            } else {
                rejected.add(fighter);
            }
        }

        result.put(ExamStatus.PROMOTED, promoted);
        result.put(ExamStatus.PENDING, potentialPromoted);
        result.put(ExamStatus.REJECTED, rejected);

        return result;
    }
}
