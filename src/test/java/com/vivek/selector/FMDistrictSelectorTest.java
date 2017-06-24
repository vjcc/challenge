package com.vivek.selector;

import com.vivek.model.District;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.Optional;

import static org.junit.Assert.assertEquals;

public class FMDistrictSelectorTest {

    private FMDistrictSelector subject;

    @Before
    public void setUp() throws Exception {
        subject = new FMDistrictSelector(new DistrictWastageComparator(5, 11));
    }

    @Test
    public void noDistrictIsSelectedWhenNoDistrictsAreDefined() throws Exception {
        Optional<District> result = subject.districtForManager(Collections.emptyList());

        assertEquals(false, result.isPresent());
    }

    @Test
    public void firstDistrictIsSelectedWhenOnlyOneDistrictExists() throws Exception {
        District district = new District(1, 10);
        Optional<District> result = subject.districtForManager(Collections.singletonList(district));

        assertEquals(district, result.orElseGet(null));
    }

    @Test
    public void districtWithLessWastageIsSelectedWhenMultipleDistrictsExist() throws Exception {
        District districtOne = new District(1, 8);
        District districtTwo = new District(2, 12);
        Optional<District> result = subject.districtForManager(Arrays.asList(districtOne, districtTwo));

        assertEquals(districtTwo, result.orElseGet(null));
    }
}