package hu.nive.ujratervezes.zarovizsga.digitscounter;

import java.util.HashSet;
import java.util.Set;

public class DigitsCounter {

    public int getCountOfDigits(String s) {

        if (s == null || s.equals("") || s.isEmpty() || s.isBlank()) {
            return 0;
        }

        Set<Character> result = new HashSet<>();
        for (char c : s.toCharArray()) {
            if (checkLetter(c)) {
                result.add(c);
            }
        }
        return result.size();
    }

    private boolean checkLetter(char c) {
        return c >= '0' && c <= '9';
    }

    public static void main(String[] args) {
        DigitsCounter digitsCounter = new DigitsCounter();
        System.out.println(digitsCounter.getCountOfDigits(null));
    }
}
