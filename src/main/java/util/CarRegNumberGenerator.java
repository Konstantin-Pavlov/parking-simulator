package util;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class CarRegNumberGenerator {
    private static final String LETTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String DIGITS = "0123456789";
    private static final int LETTER_COUNT = 3;
    private static final int DIGIT_COUNT = 3;
    private static final Random random = new Random();
    private static Set<String> usedCarNumbers = new HashSet<>();

    private CarRegNumberGenerator() {
    }

    public static String getNewRegNumber() {
        String carNumber = generateCarNumber();
        while (usedCarNumbers.contains(carNumber)) {
            carNumber = generateCarNumber();
        }
        usedCarNumbers.add(carNumber);
        return carNumber;
    }

    public static Set<String> getAllCarNumbers() {
        return usedCarNumbers;
    }

    private static String generateCarNumber() {
        StringBuilder carNumber = new StringBuilder();

        // Generate letters
        for (int i = 0; i < LETTER_COUNT; i++) {
            int randomIndex = random.nextInt(LETTERS.length());
            carNumber.append(LETTERS.charAt(randomIndex));
        }

        // Generate digits
        for (int i = 0; i < DIGIT_COUNT; i++) {
            int randomIndex = random.nextInt(DIGITS.length());
            carNumber.append(DIGITS.charAt(randomIndex));
        }

        return carNumber.toString();
    }
}
