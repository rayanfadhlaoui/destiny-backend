package ca.destiny.battle2;

import ca.destiny.v2.person.common.RaceEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.awt.image.PixelGrabber;

@Getter
@AllArgsConstructor
public class Fighter {
    private final Information information;
    private final Characteristics characteristics;
    private final HealthStatus healthStatus;
    private final RaceEnum raceEnum;
}
