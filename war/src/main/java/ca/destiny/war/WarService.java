package ca.destiny.war;

import ca.destiny.battle.duel.TurnBasedBattleExecutor;
import ca.destiny.battle.factory.BattleBuilder;
import ca.destiny.battle.factory.BattleType;
import ca.destiny.battle.model.BattleDto;
import ca.destiny.evolution.refresh.BodyPartRefresher;
import ca.destiny.fighter.BattleFighterDto;
import ca.destiny.other.RandomNumberGeneratorService;
import org.springframework.stereotype.Component;

import java.util.LinkedList;
import java.util.List;

@Component
public class WarService {

    private final RandomNumberGeneratorService randomNumberGeneratorService;
    private final TurnBasedBattleExecutor turnBasedBattleExecutor;
    private final BodyPartRefresher bodyPartRefresher;

    public WarService(RandomNumberGeneratorService randomNumberGeneratorService,
                      TurnBasedBattleExecutor turnBasedBattleExecutor,
                      BodyPartRefresher bodyPartRefresher) {
        this.randomNumberGeneratorService = randomNumberGeneratorService;
        this.turnBasedBattleExecutor = turnBasedBattleExecutor;
        this.bodyPartRefresher = bodyPartRefresher;
    }

    public void execute(List<BattleFighterDto> fighters1, List<BattleFighterDto> fighters2) {

        List<BattleFighterDto> localFighters1 = new LinkedList<>(fighters1);
        List<BattleFighterDto> localFighters2 = new LinkedList<>(fighters2);

        while (localFighters1.size() != 0 && localFighters2.size() != 0) {
            int rand1 = randomNumberGeneratorService.getRandomNumberInts(0, localFighters1.size() - 1);
            BattleFighterDto battleFighterDto = localFighters1.get(rand1);
            int rand2 = randomNumberGeneratorService.getRandomNumberInts(0, localFighters2.size() - 1);
            BattleFighterDto battleFighterDto2 = localFighters2.get(rand2);
            turnBasedBattleExecutor.execute(createBattleDto(battleFighterDto, battleFighterDto2));
            if (isFighterOut(battleFighterDto)) {
                localFighters1.remove(rand1);
            }
            if (isFighterOut(battleFighterDto2)) {
                localFighters2.remove(rand2);
            }
        }
        bodyPartRefresher.refresh(fighters1, 10);
        bodyPartRefresher.refresh(fighters2, 10);
    }

    private boolean isFighterOut(BattleFighterDto battleFighterDto) {
        return battleFighterDto.getBattleInformation().getVitality() <= 0 || !battleFighterDto.getBattleInformation().getFightingStatus().canFight();
    }

    private BattleDto createBattleDto(BattleFighterDto battleFighterDto,
                                      BattleFighterDto battleFighterDto2) {
        return BattleBuilder.initWith(BattleType.DUEL_SINGLE_CELL)
                .addFighters(battleFighterDto, battleFighterDto2)
                .build();
    }
}
