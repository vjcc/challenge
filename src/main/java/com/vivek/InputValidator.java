package com.vivek;

import java.util.ArrayList;
import java.util.List;

import static java.util.stream.IntStream.of;

class InputValidator {
    static List<String> validateInput(int[] scooters, int C, int P) {
        List<String> errors = new ArrayList<>();

        if (!isScootersLengthValid(scooters)) {
            errors.add("scooters can contain between 1 and 100 elements");
        }

        if (!isEachElementInScootersValid(scooters)) {
            errors.add("Each element in scooters can be between 0 and 1000");
        }

        if (!isCValid(C)) {
            errors.add("C can be between 1 and 999");
        }

        if (!isPValid(P)) {
            errors.add("P can be between 1 and 1000");

        }
        return errors;
    }

    private static boolean isScootersLengthValid(int[] scooters) {
        return scooters.length >= 1 && scooters.length <= 100;
    }

    private static boolean isEachElementInScootersValid(int[] scooters) {
        return of(scooters).allMatch(value -> value >= 0 && value <= 1000);
    }

    private static boolean isCValid(int C) {
        return C >= 1 && C <= 999;
    }

    private static boolean isPValid(int P) {
        return P >= 1 && P <= 1000;
    }
}
