package ca.destiny.exam.round;

import ca.destiny.battle.factory.BattleBuilder;
import ca.destiny.battle.factory.BattleType;
import ca.destiny.battle.model.BattleDto;
import ca.destiny.battle.simulation.SimulationBattleExecutor;
import ca.destiny.evolution.refresh.BattleFighterRefresher;
import ca.destiny.fighter.BattleFighterDto;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class RoundExecutor {

    private final SimulationBattleExecutor simulationBattleExecutor;
    private final BattleFighterRefresher battleFighterRefresher;

    public RoundExecutor(SimulationBattleExecutor simulationBattleExecutor,
                         BattleFighterRefresher battleFighterRefresher) {
        this.simulationBattleExecutor = simulationBattleExecutor;
        this.battleFighterRefresher = battleFighterRefresher;
    }

    public Map<Long, Integer> execute(List<BattleFighterDto> participants, int nbRounds) {

        List<BattleFighterDto> localParticipants = new ArrayList<>(participants);
        Optional<BattleFighterDto> optionalOutsider = getOutsider(localParticipants);

        Map<Long, Integer> score = new HashMap<>();
        localParticipants.forEach(p -> score.put(p.getId(), 0));
        for (int i = 0; i < nbRounds; i++) {
            Collections.shuffle(localParticipants);

            optionalOutsider.ifPresent(outsider -> oneRoundForOutsider(localParticipants, score, outsider));
            long t1 = System.currentTimeMillis();
            for (int j = 0; j < localParticipants.size(); j += 2) {
                simulateOneRound(localParticipants, score, j);
            }
            t1 = System.currentTimeMillis() - t1;
            System.out.println(t1 + " ms");
        }
        return score;
    }

    private void simulateOneRound(List<BattleFighterDto> localParticipants, Map<Long, Integer> score, int j) {
        BattleFighterDto winner = getWinner(localParticipants.get(j + 1), localParticipants.get(j));
        score.putIfAbsent(winner.getId(), 0);
        score.computeIfPresent(winner.getId(), (k, v) -> v + 1);
    }

    private void oneRoundForOutsider(List<BattleFighterDto> localParticipants, Map<Long, Integer> score, BattleFighterDto outsider) {
        BattleFighterDto winner = getWinner(outsider, localParticipants.get(0));
        if (winner.getId() == outsider.getId()) {
            score.putIfAbsent(winner.getId(), 0);
            score.computeIfPresent(winner.getId(), (k, v) -> v + 1);
        }
    }

    private BattleFighterDto getWinner(BattleFighterDto battleFighterDto, BattleFighterDto battleFighterDto2) {
        battleFighterRefresher.refresh(battleFighterDto, false);
        battleFighterRefresher.refresh(battleFighterDto2, false);

        var battleDto = createBattleDto(battleFighterDto, battleFighterDto2);
        BattleDto res = simulationBattleExecutor.execute(battleDto);
        var winner = res.getSummary().getWinners().get(0);
        battleFighterRefresher.refresh(battleFighterDto, false);
        battleFighterRefresher.refresh(battleFighterDto2, false);
        return winner;
    }

    private Optional<BattleFighterDto> getOutsider(List<BattleFighterDto> localParticipants) {
        if (localParticipants.size() % 2 == 1) {
            BattleFighterDto outsider = localParticipants.get(localParticipants.size() - 1);
            localParticipants.remove(localParticipants.size() - 1);
            return Optional.of(outsider);
        }
        return Optional.empty();
    }

    private BattleDto createBattleDto(BattleFighterDto battleFighterDto,
                                      BattleFighterDto battleFighterDto2) {
        return BattleBuilder.initWith(BattleType.DUEL_SINGLE_CELL)
                .addFighters(battleFighterDto, battleFighterDto2)
                .build();
    }
}
