package ca.destiny.battle2;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class SquadFighter {
    private final int teamNumber;
    private final Fighter fighter;
    private Position position;
}
