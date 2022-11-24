package ca.destiny.battle2;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class KeyPair<F, S> {

    private F first;
    private S second;
}
