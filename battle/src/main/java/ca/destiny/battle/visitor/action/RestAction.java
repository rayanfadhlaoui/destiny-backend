package ca.destiny.battle.visitor.action;

import ca.destiny.battle.action.Action;
import ca.destiny.fighter.BattleFighterDto;
import ca.destiny.fighter.CharacteristicsDto;
import ca.destiny.other.RandomNumberGeneratorService;

public class RestAction implements Action {
    private final RandomNumberGeneratorService randomNumberGeneratorService;
    private final BattleFighterDto activeFighter;

    public RestAction(RandomNumberGeneratorService randomNumberGeneratorService, BattleFighterDto activeFighter) {
        this.randomNumberGeneratorService = randomNumberGeneratorService;
        this.activeFighter = activeFighter;
    }

    @Override
    public boolean execute() {
        var characteristics = activeFighter.getCharacteristics();
        int stamina = characteristics.getStamina();
        int currentStamina = activeFighter.getBattleInformation().getStamina();
        int newStamina = randomNumberGeneratorService.getRandomNumberInts(0, stamina / 5);
        newStamina = currentStamina + Math.max(5, newStamina);
        activeFighter.getBattleInformation().setStamina(Math.min(newStamina, stamina));
        return false;
    }
}
