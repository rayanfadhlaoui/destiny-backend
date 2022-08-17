package ca.destiny.injury.blunt.generator.legorarm;

import ca.destiny.injury.blunt.generator.InjuryGeneratorTest;
import ca.destiny.injury.blunt.InjuryGenerator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
class LegOrArmSuperficialBluntInjuryGeneratorTest extends InjuryGeneratorTest {

    @Override
    protected InjuryGenerator createInjuryGenerator() {
        return new LegOrArmSuperficialBluntInjuryGenerator(bodyPart);
    }

    @Test
    void inflict_superficialBruise() {
        given(randomNumberGeneratorService.getRandomNumberInts(0, 100)).willReturn(75);
        assertInjuryNameIs(false, "Superficial Bruise");
    }

    @Test
    void inflict_MinorBruise() {
        given(randomNumberGeneratorService.getRandomNumberInts(0, 100)).willReturn(100);
        assertInjuryNameIs(false, "Minor bruise");
    }

    @Test
    void inflict_SevereBruise() {
        given(randomNumberGeneratorService.getRandomNumberInts(0, 100)).willReturn(100);
        assertInjuryNameIs(true, "Severe bruise");
    }
}