package com.vivek.model;

public class District {
    public final int id;
    public final int numberOfScooters;

    public District(int id, int numberOfScooters) {
        this.id = id;
        this.numberOfScooters = numberOfScooters;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        District district = (District) o;

        return id == district.id && numberOfScooters == district.numberOfScooters;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + numberOfScooters;
        return result;
    }
}
