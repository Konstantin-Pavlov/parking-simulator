package util;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

/**
 * This class is for generating unique car numbers
 * In the algorithm, a car number consisting of three random uppercase letters followed by three random digits.
 * For the letters, there are 26 possibilities (A-Z) for each position, resulting in a total of 26 * 26 * 26 = 17,576 combinations.
 * For the digits, there are 10 possibilities (0-9) for each position, resulting in a total of 10 * 10 * 10 = 1,000 combinations.
 * To calculate the total number of unique car numbers, we multiply the number of letter combinations by the number of digit combinations:
 * 17,576 * 1,000 = 17,576,000
 * Therefore, using the provided algorithm, it is possible to generate 17,576,000 unique car numbers.
 */

public class CarRegNumberGenerator {
    private static final String LETTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String DIGITS = "0123456789";
    private static final int LETTER_COUNT = 3;
    private static final int DIGIT_COUNT = 3;
    private static final Random random = new Random();
    private static final Set<String> usedCarNumbers = new HashSet<>();

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
