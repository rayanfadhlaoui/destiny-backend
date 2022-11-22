package ca.destiny.battle2;

import ca.destiny.v2.person.common.RaceEnum;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class SquadFactory {

    private final FighterFactoryV2 fighterFactoryV2;

    public SquadFactory(FighterFactoryV2 fighterFactoryV2) {
        this.fighterFactoryV2 = fighterFactoryV2;
    }

    public Squad createFromScratch(RaceEnum raceEnum, String name) {
        Position position = new Position(0, 0);
        Fighter leader = fighterFactoryV2.create(raceEnum);
        Map<Position, Fighter> fighters = new HashMap<>();
        fighters.put(position, leader);

        for (int i = 0; i < 5; i++) {
            position = getNewPosition(position);
            fighters.put(position, fighterFactoryV2.create(raceEnum));
        }
        return new Squad(leader, name, fighters, 2, 3);
    }

    private Position getNewPosition(Position position) {
        int x;
        int y;
        if (position.getX() == 2) {
            x = 0;
            y = position.getY() + 1;
        } else {
            x = position.getX() + 1;
            y = position.getY();
        }
        return new Position(x, y);
    }
}
