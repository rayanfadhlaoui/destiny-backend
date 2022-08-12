package ca.destiny.injury.blunt.generator;

import ca.destiny.fighter.bodypart.BodyPartDto;
import ca.destiny.injury.injury.AbstractInjuryGenerator;
import ca.destiny.injury.injury.InjuryGenerator;
import ca.destiny.other.RandomNumberGeneratorService;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.Mock;

import static org.assertj.core.api.Assertions.assertThat;

public abstract class InjuryGeneratorTest {
    @Mock
    protected RandomNumberGeneratorService randomNumberGeneratorService;
    protected InjuryGenerator injuryGenerator;
    protected BodyPartDto bodyPart;

    @BeforeEach
    void setup() {
        bodyPart = new BodyPartDto();
        injuryGenerator = createInjuryGenerator();
        setRandomNumber();
    }

    protected abstract InjuryGenerator createInjuryGenerator();

    protected void setRandomNumber() {
        try {
            var field = AbstractInjuryGenerator.class
                    .getDeclaredField("randomNumberGeneratorService");
            field.setAccessible(true);
            field.set(injuryGenerator, randomNumberGeneratorService);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            throw new IllegalArgumentException(e);
        }
    }

    protected void assertInjuryNameIs(boolean isKnockout, String injuryName) {
        injuryGenerator.inflict(isKnockout);
        assertThat(bodyPart.getInjuries().get(0).getName()).isEqualTo(injuryName);
    }
}
