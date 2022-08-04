package ca.destiny.game;

import ca.destiny.person.common.DestinyDate;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class GameInformationService {

    private final Map<Long, GameInformationDto> gameInformationById = new HashMap<>();

    public GameInformationDto createGameInformation(Long userId) {
        GameInformationDto gameInformationDto = new GameInformationDto();
        gameInformationDto.setId(1);
        DestinyDate currentDate = new DestinyDate();
        currentDate.setDay(1);
        currentDate.setMonth(1);
        currentDate.setYear(12);
        gameInformationDto.setCurrentDate(currentDate);
        gameInformationDto.setIdMainUser(userId);
        return gameInformationDto;
    }

    public DestinyDate getCurrentDate(Long id) {
        return gameInformationById.get(id).getCurrentDate();
    }
}
