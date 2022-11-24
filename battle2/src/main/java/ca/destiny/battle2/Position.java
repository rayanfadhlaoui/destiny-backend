package ca.destiny.battle2;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.Getter;

import java.util.List;

@Getter
public class Position {

    private final int x;
    private final int y;

    @JsonCreator
    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Position(String both) {
        String[] pairs = both.replace("\"", "").split("X");
        this.x = Integer.parseInt(pairs[0].trim());
        this.y = Integer.parseInt(pairs[1].trim());
    }


    @Override
    public int hashCode() {
        return 144 + x + 10 * y;
    }

    @Override
    public boolean equals(Object obj) {
        boolean isEqual = false;
        if (obj instanceof Position) {
            Position position = (Position) obj;
            isEqual = position.x == x && position.y == y;
        }
        return isEqual;
    }

    @JsonValue
    public String serialize() {
        return x + "X" + y;
    }

    public List<Position> getSurrounding() {
        return List.of(move(1, 0),
                move(-1, 0),
                move(0, 1),
                move(0, -1),
                move(1, 1),
                move(-1, 1),
                move(1, -1),
                move(-1, -1));
    }

    private Position move(int x, int y) {
        return new Position(this.x + x, this.y + y);
    }
}
