package ca.destiny.battle2;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Experience {
    private int currentExperience;
    private int level;
    private int nextLevel;
}
