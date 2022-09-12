package ca.destiny.evolution.refresh;

import ca.destiny.fighter.BattleFighterDto;
import ca.destiny.fighter.bodypart.BodyPartDto;
import ca.destiny.fighter.injury.SevereBruiseInjury;
import ca.destiny.other.RandomNumberGeneratorService;
import ca.destiny.person.PersonDto;
import ca.destiny.person.human.HumanPersonDto;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;

class BodyPartRefresherTest {

    private final RandomNumberGeneratorService randomNumberGeneratorService = mock(RandomNumberGeneratorService.class);
    private final BodyPartRefresher bodyPartRefresher = new BodyPartRefresher(randomNumberGeneratorService);

    @Test
    void cleanAllInjuries() {
        var battleFighterDto = createBattleFighterDto();
        var battleFighterDto2 = createBattleFighterDto();
        var bodyPartDto = new BodyPartDto();
        bodyPartDto.addInjury(new SevereBruiseInjury(10, 120));
        PersonDto person = battleFighterDto2.getPerson();
        List<BodyPartDto> availableBodyParts = person.getAvailableBodyParts();
        availableBodyParts.add(bodyPartDto);
        List<BattleFighterDto> fighters = Arrays.asList(battleFighterDto, battleFighterDto2);

        given(randomNumberGeneratorService.getRandomNumberInts(anyInt(), anyInt())).willReturn(15);

        bodyPartRefresher.refresh(fighters, 20);

        BodyPartDto bodyPartDto1 = battleFighterDto.getPerson().getAvailableBodyParts().get(0);
        assertThat(bodyPartDto1.getInjuries()).isEmpty();
        assertThat(bodyPartDto1.getPenalty()).isEqualTo(0);
        assertThat(availableBodyParts.get(0).getInjuries()).isEmpty();
        assertThat(availableBodyParts.get(1).getInjuries()).hasSize(1);
        assertThat(availableBodyParts.get(1).getInjuries().get(0).getLastingDays()).isEqualTo(100);
    }

    private BattleFighterDto createBattleFighterDto() {
        BattleFighterDto battleFighterDto = new BattleFighterDto();
        HumanPersonDto person = new HumanPersonDto();
        BodyPartDto bodyPartDto = new BodyPartDto();
        bodyPartDto.addInjury(new SevereBruiseInjury(10, 20));
        bodyPartDto.addInjury(new SevereBruiseInjury(10, 20));
        bodyPartDto.addInjury(new SevereBruiseInjury(10, 20));
        bodyPartDto.addInjury(new SevereBruiseInjury(10, 20));
        bodyPartDto.addInjury(new SevereBruiseInjury(10, 20));
        List<BodyPartDto> list = new ArrayList<>();
        list.add(bodyPartDto);
        person.setAvailableBodyParts(list);
        battleFighterDto.setPerson(person);
        return battleFighterDto;
    }
}