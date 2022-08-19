package ca.destiny.injury.blunt;

import ca.destiny.fighter.BattleInformation;
import ca.destiny.injury.FightStatusUpdater;
import ca.destiny.injury.NoneInjuryGenerator;

public interface InjuryGenerator {
    InjuryGenerator EMPTY = new NoneInjuryGenerator(null);

    void inflict(boolean knockout, BattleInformation battleInformation, FightStatusUpdater fightStatusUpdater);
}
