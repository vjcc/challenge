package com.vivek;

import com.vivek.model.District;
import com.vivek.selector.DistrictWastageComparator;
import com.vivek.selector.FMDistrictSelector;

import java.io.Console;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static com.vivek.InputValidator.validateInput;
import static java.lang.Integer.parseInt;
import static java.util.stream.Collectors.toList;

class Challenge {

    public static void main(String[] args) {
        Console c = System.console();
        if (c == null) {
            System.err.println("No console.");
            System.exit(1);
        }

        String scootersLine = c.readLine("Enter number of scooters per district separated by space (scooters): ");
        int[] scooters = Stream
                .of(scootersLine.split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int C = parseInt(c.readLine("Enter scooters per Fleet Manager (C): "));

        int P = parseInt(c.readLine("Enter scooters per Fleet Engineer (P): "));

        List<String> errors = validateInput(scooters, C, P);
        if (!errors.isEmpty()) {
            System.out.println("Invalid Input:");
            errors.forEach(System.out::println);
            System.exit(1);
        }

        int result = minimumNumberOfFERequired(scooters, C, P);
        System.out.println("Total number of Fleet Engineers required: " + result);
    }

    private static int minimumNumberOfFERequired(int[] scooters, int C, int P) {
        List<District> districts = districts(scooters);

        FMDistrictSelector fmDistrictSelector = new FMDistrictSelector(new DistrictWastageComparator(C, P));
        FECalculator feCalculator = new FECalculator(fmDistrictSelector, C, P);

        return feCalculator.calculateTotalFEsRequired(districts);
    }

    private static List<District> districts(int[] scooters) {
        return IntStream
                .range(0, scooters.length)
                .mapToObj(i -> new District(i, scooters[i]))
                .collect(toList());
    }

}
