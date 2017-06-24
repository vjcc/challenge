package com.vivek.selector;

import com.vivek.model.District;

import java.util.List;
import java.util.Optional;

public class FMDistrictSelector {
    private final DistrictWastageComparator districtWastageComparator;

    public FMDistrictSelector(DistrictWastageComparator districtWastageComparator) {
        this.districtWastageComparator = districtWastageComparator;
    }

    public Optional<District> districtForManager(List<District> districts) {
        return districts.stream()
                .min(this.districtWastageComparator);
    }
}
