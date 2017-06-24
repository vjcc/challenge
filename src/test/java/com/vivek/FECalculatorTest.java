package com.vivek;

import com.vivek.model.District;
import com.vivek.selector.DistrictWastageComparator;
import com.vivek.selector.FMDistrictSelector;
import org.junit.Test;

import java.util.List;

import static java.util.stream.Collectors.toList;
import static java.util.stream.IntStream.range;
import static org.junit.Assert.assertEquals;

public class FECalculatorTest {

    @Test
    public void noFERequiredWhenDistrictsAreNotDefined() throws Exception {
        int result = createFECalculator(1, 2).calculateTotalFEsRequired(createDistricts());

        assertEquals(0, result);
    }

    @Test
    public void noFERequiredWhenOnlyOneDistrictWithScootersLessThanCapacityForFMExists() throws Exception {
        int result = createFECalculator(5, 10).calculateTotalFEsRequired(createDistricts(4));

        assertEquals(0, result);
    }

    @Test
    public void oneFERequiredWhenScootersAreEqualToCapacityForFE() throws Exception {
        int result = createFECalculator(5, 10).calculateTotalFEsRequired(createDistricts(15));

        assertEquals(1, result);
    }

    @Test
    public void scenarioOneInChallenge() throws Exception {
        int result = createFECalculator(12, 5).calculateTotalFEsRequired(createDistricts(15, 10));

        assertEquals(3, result);
    }

    @Test
    public void scenarioTwoInChallenge() throws Exception {
        int result = createFECalculator(9, 5).calculateTotalFEsRequired(createDistricts(11, 15, 13));

        assertEquals(7, result);
    }

    private FECalculator createFECalculator(int scootersPerFM, int scootersPerFE) {
        DistrictWastageComparator comparator = new DistrictWastageComparator(scootersPerFM, scootersPerFE);
        FMDistrictSelector selector = new FMDistrictSelector(comparator);
        return new FECalculator(selector, scootersPerFM, scootersPerFE);
    }

    private List<District> createDistricts(int... scooters) {
        return range(0, scooters.length)
                .mapToObj(i -> new District(i, scooters[i]))
                .collect(toList());
    }
}