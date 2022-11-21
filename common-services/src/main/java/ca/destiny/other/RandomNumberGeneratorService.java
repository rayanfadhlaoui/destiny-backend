package ca.destiny.other;

import org.springframework.stereotype.Service;

import java.util.Random;
@Service
public class RandomNumberGeneratorService {

    private final Random random;

    public RandomNumberGeneratorService() {
        this.random = new Random();
    }

    public int getRandomNumberInts(int min, int max) {
        return random.ints(min, (max + 1))
                .findFirst()
                .orElseGet(() -> {
                    System.out.println("RandomNumberGeneratorService --> error on " + min + "||" + max);
                    return 0;
                });
    }
}
