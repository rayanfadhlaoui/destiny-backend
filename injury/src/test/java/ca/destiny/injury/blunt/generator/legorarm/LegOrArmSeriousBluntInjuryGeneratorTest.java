package ca.destiny.injury.blunt.generator.legorarm;

import ca.destiny.injury.blunt.generator.InjuryGeneratorTest;
import ca.destiny.injury.blunt.InjuryGenerator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
class LegOrArmSeriousBluntInjuryGeneratorTest extends InjuryGeneratorTest {

    @Override
    protected InjuryGenerator createInjuryGenerator() {
        return new LegOrArmSeriousBluntInjuryGenerator(bodyPart);
    }

    @Test
    void inflict_minorBruise() {
        given(randomNumberGeneratorService.getRandomNumberInts(0, 100)).willReturn(5);
        assertInjuryNameIs(false, "Superficial Bruise");
    }

    @Test
    void inflict_MinorBruise() {
        given(randomNumberGeneratorService.getRandomNumberInts(0, 100)).willReturn(25);
        assertInjuryNameIs(false, "Minor bruise");
    }

    @Test
    void inflict_SevereBruise() {
        given(randomNumberGeneratorService.getRandomNumberInts(0, 100)).willReturn(50);
        assertInjuryNameIs(false, "Severe bruise");
    }

    @Test
    void inflict_minorFracture() {
        given(randomNumberGeneratorService.getRandomNumberInts(0, 100)).willReturn(75);
        assertInjuryNameIs(false, "Minor fracture");
    }

    @Test
    void inflict_severeFracture() {
        given(randomNumberGeneratorService.getRandomNumberInts(0, 100)).willReturn(100);
        assertInjuryNameIs(false, "Severe fracture");
    }

    @Test
    void inflict_dislocation() {
        given(randomNumberGeneratorService.getRandomNumberInts(0, 100)).willReturn(100);
        assertInjuryNameIs(true, "Dislocation");
    }

}