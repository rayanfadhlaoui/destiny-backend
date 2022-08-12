package ca.destiny.injury.blunt.generator.legorarm;

import ca.destiny.injury.blunt.generator.InjuryGeneratorTest;
import ca.destiny.injury.injury.InjuryGenerator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
class LegOrArmModerateBluntInjuryGeneratorTest extends InjuryGeneratorTest {

    @Override
    protected InjuryGenerator createInjuryGenerator() {
        return new LegOrArmModerateBluntInjuryGenerator(bodyPart);
    }

    @Test
    void inflict_minorBruise() {
        given(randomNumberGeneratorService.getRandomNumberInts(0, 100)).willReturn(20);
        assertInjuryNameIs(false, "Superficial Bruise");
    }

    @Test
    void inflict_MinorBruise() {
        given(randomNumberGeneratorService.getRandomNumberInts(0, 100)).willReturn(45);
        assertInjuryNameIs(false, "Minor bruise");
    }

    @Test
    void inflict_SevereBruise() {
        given(randomNumberGeneratorService.getRandomNumberInts(0, 100)).willReturn(95);
        assertInjuryNameIs(false, "Severe bruise");
    }

    @Test
    void inflict_minorFracture() {
        given(randomNumberGeneratorService.getRandomNumberInts(0, 100)).willReturn(100);
        assertInjuryNameIs(false, "Minor fracture");
    }

    @Test
    void inflict_severeFracture() {
        given(randomNumberGeneratorService.getRandomNumberInts(0, 100)).willReturn(100);
        assertInjuryNameIs(true, "Severe fracture");
    }

}