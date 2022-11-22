package ca.destiny.battle2;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class SquadFighter {
    private final int teamNumber;
    private final Fighter fighter;
    private final Position position;
}
