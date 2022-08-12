package ca.destiny.injury.provider;

import ca.destiny.fighter.equipment.weapon.WeaponDto;
import ca.destiny.injury.InjuryGeneratorFactory;
import ca.destiny.injury.blunt.factory.*;
import ca.destiny.injury.model.FighterInjuryInformation;
import ca.destiny.injury.sharpe.factory.*;
import ca.destiny.other.RandomNumberGeneratorService;
import org.springframework.stereotype.Component;

@Component
public class InjuryGeneratorFactoryProvider {
    private final RandomNumberGeneratorService randomNumberGeneratorService;

    public InjuryGeneratorFactoryProvider(RandomNumberGeneratorService randomNumberGeneratorService) {
        this.randomNumberGeneratorService = randomNumberGeneratorService;
    }

    public InjuryGeneratorFactory get(int damagePercentage, FighterInjuryInformation fighterInjuryInformation, WeaponDto weaponDto) {
        int[] probabilityAndSeverity = computeInjuryProbabilityAndSeverity(damagePercentage);
        int probability = probabilityAndSeverity[0];
        int randomNumber = randomNumberGeneratorService.getRandomNumberInts(0, 100);
        int resistance = randomNumberGeneratorService.getRandomNumberInts(0, fighterInjuryInformation.getResistance());
        int delta = randomNumber - probability;
        if (resistance + delta >= 0) {
            return InjuryGeneratorFactory.EMPTY;
        }
        if (weaponDto.getBlunt() > 0) {
            return getBluntInjuryGeneratorFactory(probabilityAndSeverity[1]);
        } else {
            return getSharpeInjuryGeneratorFactory(probabilityAndSeverity[1]);
        }
    }

    private InjuryGeneratorFactory getBluntInjuryGeneratorFactory(int severity) {
        InjuryGeneratorFactory injuryGeneratorFactory;
        if (severity == 1) {
            injuryGeneratorFactory = new BluntSuperficialInjuryGeneratorFactory();
        } else if (severity == 2) {
            injuryGeneratorFactory = new BluntMinorInjuryGeneratorFactory();
        } else if (severity == 3) {
            injuryGeneratorFactory = new BluntModerateInjuryGeneratorFactory();
        } else if (severity == 4) {
            injuryGeneratorFactory = new BluntSeriousInjuryGeneratorFactory();
        } else {
            injuryGeneratorFactory = new BluntSevereInjuryGeneratorFactory();
        }

        return injuryGeneratorFactory;
    }

    private InjuryGeneratorFactory getSharpeInjuryGeneratorFactory(int severity) {
        InjuryGeneratorFactory injuryGeneratorFactory;
        if (severity == 1) {
            injuryGeneratorFactory = new SharpeSuperficialInjuryGeneratorFactory();
        } else if (severity == 2) {
            injuryGeneratorFactory = new SharpeMinorInjuryGeneratorFactory();
        } else if (severity == 3) {
            injuryGeneratorFactory = new SharpeModerateInjuryGeneratorFactory();
        } else if (severity == 4) {
            injuryGeneratorFactory = new SharpeSeriousInjuryGeneratorFactory();
        } else {
            injuryGeneratorFactory = new SharpeSevereInjuryGeneratorFactory();
        }

        return injuryGeneratorFactory;
    }

    private int[] computeInjuryProbabilityAndSeverity(int damagePercentage) {
        int percentage;
        int severity;
        if (damagePercentage < 10) {
            percentage = 1;
            severity = 1;
        } else if (damagePercentage <= 25) {
            percentage = 3;
            severity = 2;
        } else if (damagePercentage <= 50) {
            percentage = 5;
            severity = 3;
        } else if (damagePercentage <= 75) {
            percentage = 8;
            severity = 4;
        } else {
            percentage = 15;
            severity = 5;
        }
        return new int[]{percentage, randomNumberGeneratorService.getRandomNumberInts(1, severity)};
    }
}
