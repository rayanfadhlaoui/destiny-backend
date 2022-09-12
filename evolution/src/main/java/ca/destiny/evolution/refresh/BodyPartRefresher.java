package ca.destiny.evolution.refresh;

import ca.destiny.fighter.BattleFighterDto;
import ca.destiny.fighter.bodypart.BodyPartDto;
import ca.destiny.fighter.injury.Injury;
import ca.destiny.other.RandomNumberGeneratorService;
import ca.destiny.person.PersonDto;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class BodyPartRefresher {

    private final RandomNumberGeneratorService randomNumberGeneratorService;

    public BodyPartRefresher(RandomNumberGeneratorService randomNumberGeneratorService) {
        this.randomNumberGeneratorService = randomNumberGeneratorService;
    }

    public void refresh(List<BattleFighterDto> fighters, int days) {
        List<BodyPartDto> injuredBodyPart = fighters.stream()
                .map(BattleFighterDto::getPerson)
                .map(PersonDto::getAvailableBodyParts)
                .flatMap(Collection::stream)
                .filter(b -> !b.getInjuries().isEmpty())
                .collect(Collectors.toList());

        for (BodyPartDto bodyPart : injuredBodyPart) {
            int penalty = bodyPart.getPenalty();
            List<Injury> updatedInjuries = new ArrayList<>();
            for (Injury injury : bodyPart.getInjuries()) {
                int daysUntilRecovery = injury.getLastingDays() - days;
                injury.setLastingDays(daysUntilRecovery);
                if (injury.getLastingDays() <= 0) {
                    int random = randomNumberGeneratorService.getRandomNumberInts(injury.getPenalty() / 2, injury.getPenalty());
                    penalty -= random;
                } else {
                    updatedInjuries.add(injury);
                }
            }
            bodyPart.setInjuries(updatedInjuries);
            bodyPart.setPenalty(Math.max(penalty, 0));
        }
    }
}
