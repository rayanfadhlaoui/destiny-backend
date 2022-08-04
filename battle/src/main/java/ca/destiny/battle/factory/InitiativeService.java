package ca.destiny.battle.factory;

import ca.destiny.fighter.BattleFighterDto;
import ca.destiny.other.RandomNumberGeneratorService;

import java.util.Stack;

public class InitiativeService {

    private final RandomNumberGeneratorService randomNumberGeneratorService = new RandomNumberGeneratorService();

    public Stack<BattleFighterDto> getOrder(BattleFighterDto battleFighterDto1, BattleFighterDto battleFighterDto2) {
        Stack<BattleFighterDto> stack = new Stack<>();
        int speed = getSpeed(battleFighterDto1);
        int speed2 = getSpeed(battleFighterDto2);
        if (speed > speed2) {
            oneFaster(battleFighterDto1, battleFighterDto2, stack);
        } else if (speed < speed2) {
            oneFaster(battleFighterDto2, battleFighterDto1, stack);
        } else if (randomNumberGeneratorService.getRandomNumberInts(0, 1) == 1) {
            oneFaster(battleFighterDto1, battleFighterDto2, stack);
        } else {
            oneFaster(battleFighterDto2, battleFighterDto1, stack);
        }
        return stack;
    }

    private int getSpeed(BattleFighterDto battleFighterDto1) {
        int speed = battleFighterDto1.getBattleInformation().getSpeed();
        return randomNumberGeneratorService.getRandomNumberInts(speed/2, speed);
    }

    private void oneFaster(BattleFighterDto first,
                           BattleFighterDto last,
                           Stack<BattleFighterDto> stack) {
        stack.push(last);
        stack.push(first);
    }
}
