package edu.dmacc.codedsm.hw8;

import java.util.Random;

public class RandomStrings {
    public static void main(String[] args) {
        String[] stringArray = new String[5];
        int i = 0;
        while (i < stringArray.length) {
            String generatedString = createRandomAlphaNumericString(5);
            if (containsNumbers(generatedString)) {
                System.out.println("Unused string - A string with a number was created: " + generatedString);
                stringArray[i] = generatedString;
            } else if (generatedString.matches("([AEIOU]).*")) {
                stringArray[i] = generatedString;
                i++;
            }
        }

        for (int a = 0; a < stringArray.length; a++) {
            System.out.println(stringArray[a]);
        }
    }

    public static boolean containsNumbers(String input) {
        char[] chars = input.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (Character.isDigit(chars[i])) {
                return true;
            }
        }
        return false;
    }

    public static String createRandomAlphaNumericString(int randomStringLength) {
        int leftLimit = 97; // letter 'a'
        int rightLimit = 122; // letter 'z'
        Random random = new Random();
        StringBuilder buffer = new StringBuilder(randomStringLength);
        for (int i = 0; i < randomStringLength; i++) {
            if (random.nextInt(10) >= 9) {
                buffer.append(random.nextInt(9));
            } else {
                int randomLimitedInt = leftLimit + (int)
                        (random.nextFloat() * (rightLimit - leftLimit + 1));
                char characterForString = (char) randomLimitedInt;
                if (random.nextBoolean()) {
                    characterForString = Character.toUpperCase(characterForString);
                }
                buffer.append(characterForString);
            }
        }
        return buffer.toString();
    }
}