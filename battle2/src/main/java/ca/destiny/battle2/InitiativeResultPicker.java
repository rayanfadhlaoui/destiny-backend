package ca.destiny.battle2;

import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class InitiativeResultPicker {
    public Integer pick(boolean positive, List<Integer> results) {
        return results.stream()
                .min((o1, o2) -> {
                    if (positive) {
                        return o2 - o1;
                    } else {
                        return o1 - o2;
                    }
                })
                .orElseThrow();

    }
}
