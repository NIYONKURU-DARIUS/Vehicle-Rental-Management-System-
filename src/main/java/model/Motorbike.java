package model;

import jakarta.persistence.Entity;
import jakarta.persistence.DiscriminatorValue;

@Entity
@DiscriminatorValue("Motorbike")
class Motorbike extends Vehicle {

    private int engineCapacity;
    private boolean helmetIncluded;
    public Motorbike() {}


    public Motorbike(String name, String type, int price, boolean availability, int engineCapacity, boolean helmetIncluded) {
        super.setName(name);
        super.setType(type);
        super.setPrice(price);
        super.setAvailability(availability);
        this.engineCapacity = engineCapacity;
        this.helmetIncluded = helmetIncluded;
    }

    // Getters and Setters
    public int getEngineCapacity() {
        return engineCapacity;
    }

    public void setEngineCapacity(int engineCapacity) {
        this.engineCapacity = engineCapacity;
    }

    public boolean isHelmetIncluded() {
        return helmetIncluded;
    }

    public void setHelmetIncluded(boolean helmetIncluded) {
        this.helmetIncluded = helmetIncluded;
    }
}