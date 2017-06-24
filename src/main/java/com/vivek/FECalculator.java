package com.vivek;

import com.vivek.model.District;
import com.vivek.selector.FMDistrictSelector;

import java.util.List;
import java.util.Optional;

import static java.lang.Math.ceil;

class FECalculator {
    private final FMDistrictSelector fmDistrictSelector;
    private final int scootersPerFM;
    private final int scootersPerFE;

    FECalculator(FMDistrictSelector fmDistrictSelector, int scootersPerFM, int scootersPerFE) {
        this.fmDistrictSelector = fmDistrictSelector;
        this.scootersPerFM = scootersPerFM;
        this.scootersPerFE = scootersPerFE;
    }

    int calculateTotalFEsRequired(List<District> districts) {
        Optional<District> maybeFMDistrict = fmDistrictSelector.districtForManager(districts);

        return districts.stream()
                .map(district -> {
                    if (maybeFMDistrict.isPresent() && maybeFMDistrict.get() == district) {
                        return fmDistrictWithRemainingScooterCount(district);
                    }
                    return district;
                })
                .mapToInt(this::calculateFEsForDistrict)
                .sum();
    }

    private District fmDistrictWithRemainingScooterCount(District fmDistrict) {
        int count = fmDistrict.numberOfScooters - this.scootersPerFM;
        return new District(fmDistrict.id, (count < 0) ? 0 : count);
    }

    private int calculateFEsForDistrict(District district) {
        return (int) ceil((double) district.numberOfScooters / (double) this.scootersPerFE);
    }

}
