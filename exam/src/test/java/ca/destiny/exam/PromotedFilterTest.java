package ca.destiny.exam;

import ca.destiny.fighter.BattleFighterDto;
import ca.destiny.fighter.BattleInformation;
import ca.destiny.person.human.HumanPersonDto;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

class PromotedFilterTest {

    private final PromotedFilter promotedFilter = new PromotedFilter();

    @Test
    void tooManyWinners() {
        List<BattleFighterDto> participants = Arrays.asList(createFighter(1L),
                createFighter(2L),
                createFighter(3L),
                createFighter(4L));
        Map<Long, Integer> score = new HashMap<>();
        score.put(1L, 4);
        score.put(2L, 4);
        score.put(3L, 4);
        score.put(4L, 0);
        Map<ExamStatus, List<BattleFighterDto>> sorted = promotedFilter.sort(participants, score, 2);
        assertThat(sorted.get(ExamStatus.PROMOTED)).hasSize(0);
        assertThat(sorted.get(ExamStatus.PENDING)).hasSize(3);
        assertThat(sorted.get(ExamStatus.REJECTED)).hasSize(1);
    }

    @Test
    void notEnoughWinners() {
        List<BattleFighterDto> participants = Arrays.asList(createFighter(1L),
                createFighter(2L),
                createFighter(3L),
                createFighter(4L));
        Map<Long, Integer> score = new HashMap<>();
        score.put(1L, 4);
        score.put(2L, 0);
        score.put(3L, 0);
        score.put(4L, 0);
        Map<ExamStatus, List<BattleFighterDto>> result = promotedFilter.sort(participants, score, 1);
        assertThat(result.get(ExamStatus.PROMOTED)).hasSize(1);
        assertThat(result.get(ExamStatus.PENDING)).hasSize(3);
        assertThat(result.get(ExamStatus.REJECTED)).isEmpty();
    }

    @Test
    void lotsOfRejected() {
        List<BattleFighterDto> participants = Arrays.asList(createFighter(1L),
                createFighter(2L),
                createFighter(3L),
                createFighter(4L),
                createFighter(5L),
                createFighter(6L),
                createFighter(7L),
                createFighter(8L));
        Map<Long, Integer> score = new HashMap<>();
        score.put(1L, 4);
        score.put(2L, 4);
        score.put(3L, 4);
        score.put(4L, 2);
        score.put(5L, 2);
        score.put(6L, 0);
        score.put(7L, 0);
        score.put(8L, 0);
        Map<ExamStatus, List<BattleFighterDto>> result = promotedFilter.sort(participants, score, 4);
        assertThat(result.get(ExamStatus.PROMOTED)).hasSize(3);
        assertThat(result.get(ExamStatus.PENDING)).hasSize(2);
        assertThat(result.get(ExamStatus.REJECTED)).hasSize(3);
    }

    private BattleFighterDto createFighter(long id) {
        BattleFighterDto battleFighterDto = new BattleFighterDto();
        battleFighterDto.setId(id);
        battleFighterDto.setBattleInformation(new BattleInformation());
        HumanPersonDto person = new HumanPersonDto();
        person.setAge(1);
        battleFighterDto.setPerson(person);
        return battleFighterDto;
    }

}