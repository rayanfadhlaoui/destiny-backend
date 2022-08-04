package ca.destiny.evolution.creation;

import ca.destiny.evolution.creation.human.HumanPersonFactory;
import ca.destiny.person.PersonDto;
import ca.destiny.person.common.RaceEnum;
import org.apache.commons.lang3.NotImplementedException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;

@ExtendWith(MockitoExtension.class)
class FighterFactoryTest {

    @InjectMocks
    private PersonFactory personFactory;

    @Mock
    private HumanPersonFactory humanPersonFactory;

    @Test
    void createHuman() {
        PersonDto expected = mock(PersonDto.class);
        given(humanPersonFactory.create(1L)).willReturn(expected);

        PersonDto actual = personFactory.create(RaceEnum.HUMAN, 1L);
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void createOther() {
        assertThatThrownBy(() -> personFactory.create(RaceEnum.ORC, 1L))
                .isInstanceOf(NotImplementedException.class)
                .hasMessageContaining("ORC creation is not implemented");
    }

}