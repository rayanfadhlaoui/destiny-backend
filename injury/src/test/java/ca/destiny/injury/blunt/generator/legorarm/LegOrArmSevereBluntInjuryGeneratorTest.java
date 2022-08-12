package ca.destiny.injury.blunt.generator.legorarm;

import ca.destiny.injury.blunt.generator.InjuryGeneratorTest;
import ca.destiny.injury.injury.InjuryGenerator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
class LegOrArmSevereBluntInjuryGeneratorTest extends InjuryGeneratorTest {

    @Override
    protected InjuryGenerator createInjuryGenerator() {
        return new LegOrArmSevereBluntInjuryGenerator(bodyPart);
    }

    @Test
    void inflict_minorBruise() {
        given(randomNumberGeneratorService.getRandomNumberInts(0, 100)).willReturn(1);
        assertInjuryNameIs(false, "Superficial Bruise");
    }

    @Test
    void inflict_MinorBruise() {
        given(randomNumberGeneratorService.getRandomNumberInts(0, 100)).willReturn(5);
        assertInjuryNameIs(false, "Minor bruise");
    }

    @Test
    void inflict_SevereBruise() {
        given(randomNumberGeneratorService.getRandomNumberInts(0, 100)).willReturn(25);
        assertInjuryNameIs(false, "Severe bruise");
    }

    @Test
    void inflict_minorFracture() {
        given(randomNumberGeneratorService.getRandomNumberInts(0, 100)).willReturn(50);
        assertInjuryNameIs(false, "Minor fracture");
    }

    @Test
    void inflict_severeFracture() {
        given(randomNumberGeneratorService.getRandomNumberInts(0, 100)).willReturn(75);
        assertInjuryNameIs(false, "Severe fracture");
    }

    @Test
    void inflict_dislocation() {
        given(randomNumberGeneratorService.getRandomNumberInts(0, 100)).willReturn(80);
        assertInjuryNameIs(false, "Dislocation");
    }

    @Test
    void inflict_Broken() {
        given(randomNumberGeneratorService.getRandomNumberInts(0, 100)).willReturn(81);
        assertInjuryNameIs(false, "Broken");
    }

    @Test
    void inflict_BrokenKnockout() {
        given(randomNumberGeneratorService.getRandomNumberInts(0, 100)).willReturn(61);
        assertInjuryNameIs(true, "Broken");
    }

}