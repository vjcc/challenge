package com.vivek.selector;

import com.vivek.model.District;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DistrictWastageComparatorTest {
    private DistrictWastageComparator subject;

    @Before
    public void setUp() throws Exception {
        subject = new DistrictWastageComparator(7, 5);
    }

    @Test
    public void selectsDistrictWithLessWastage() throws Exception {
        assertEquals(-1, subject.compare(new District(1, 5), new District(2, 9)));
        assertEquals(-1, subject.compare(new District(1, 11), new District(2, 8)));
        assertEquals(1, subject.compare(new District(1, 8), new District(2, 12)));
    }
}