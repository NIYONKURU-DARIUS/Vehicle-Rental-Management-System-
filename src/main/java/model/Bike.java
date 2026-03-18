package model;

import jakarta.persistence.DiscriminatorColumn;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("Bike")
public class Bike extends Vehicle{
    private int gearCount;
    public Bike(){};
    public Bike(String name, String type, int price, boolean availability, int gearCount){
        super.setName(name);
        super.setType(type);
        super.setPrice(price);
        super.setAvailability(availability);
        this.gearCount = gearCount;
    }

    public int getGearCount() {
        return gearCount;
    }

    public void setGearCount(int gearCount) {
        this.gearCount = gearCount;
    }
}
