package com.vivek.selector;

import com.vivek.model.District;

import java.util.Comparator;

public class DistrictWastageComparator implements Comparator<District> {
    private final int scootersPerFM;
    private final int scootersPerFE;

    public DistrictWastageComparator(int scootersPerFM, int scootersPerFE) {
        this.scootersPerFM = scootersPerFM;
        this.scootersPerFE = scootersPerFE;
    }

    @Override
    public int compare(District firstDistrict, District secondDistrict) {
        int firstDistrictWastage = wastage(firstDistrict.numberOfScooters);
        int secondDistrictWastage = wastage(secondDistrict.numberOfScooters);

        return (firstDistrictWastage < secondDistrictWastage) ? -1 : 1;
    }

    private int wastage(int numberOfScooters) {
        int countMinusManagerCapacity = numberOfScooters - scootersPerFM;
        if (countMinusManagerCapacity <= 0) {
            return Math.abs(countMinusManagerCapacity);
        }

        int remainingCapacity = countMinusManagerCapacity % scootersPerFE;
        return remainingCapacity == 0 ? 0 : (scootersPerFE - remainingCapacity);
    }
}
