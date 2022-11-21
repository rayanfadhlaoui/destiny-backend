package ca.destiny.evolution.v2.creation.bodypart;

import ca.destiny.fighter.bodypart.BodyPartDto;
import ca.destiny.fighter.bodypart.BodyPartType;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class BodyPartFactory {

    public List<BodyPartDto> create() {
        return Arrays.asList(createBodyPart(BodyPartType.HEAD),
                createBodyPart(BodyPartType.BODY),
                createBodyPart(BodyPartType.LEFT_ARM),
                createBodyPart(BodyPartType.LEFT_LEG),
                createBodyPart(BodyPartType.LEFT_FEET),
                createBodyPart(BodyPartType.RIGHT_ARM),
                createBodyPart(BodyPartType.RIGHT_LEG),
                createBodyPart(BodyPartType.RIGHT_FEET));
    }

    private BodyPartDto createBodyPart(BodyPartType partType) {
        BodyPartDto bodyPartDto = new BodyPartDto();
        bodyPartDto.setType(partType);
        return bodyPartDto;
    }
}
