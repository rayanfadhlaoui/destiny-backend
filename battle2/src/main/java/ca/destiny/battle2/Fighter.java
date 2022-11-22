package ca.destiny.battle2;

import ca.destiny.v2.person.common.RaceEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Setter
public class Fighter {
    private Information information;
    private Characteristics characteristics;
    private Experience experience;
    private HealthStatus healthStatus;
    private RaceEnum raceEnum;
}
