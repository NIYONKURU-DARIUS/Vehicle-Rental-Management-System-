package model;

import jakarta.persistence.Entity;
import jakarta.persistence.DiscriminatorValue;

@Entity
@DiscriminatorValue("Car")
public class Car extends Vehicle {

    private int engineCapacity;

    public Car() {}

    public Car(String name, String type, int price, boolean availability, int engineCapacity) {
        super.setName(name);
        super.setType(type);
        super.setPrice(price);
        super.setAvailability(availability);
        this.engineCapacity = engineCapacity;
    }

    public int getEngineCapacity() {
        return engineCapacity;
    }

    public void setEngineCapacity(int engineCapacity) {
        this.engineCapacity = engineCapacity;
    }
}