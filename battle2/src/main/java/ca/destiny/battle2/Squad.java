package ca.destiny.battle2;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.*;

import java.util.HashMap;
import java.util.Map;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Squad {

    private Fighter leader;
    private String fraction;
    @JsonSerialize(keyUsing = PositionSerializer.class)
    private Map<Position, Fighter> fighterByPosition = new HashMap<>();
    private int length;
    private int width;

}
