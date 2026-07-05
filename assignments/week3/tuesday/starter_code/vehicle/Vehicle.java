package vehicle;

/**
 * TODO: abstract Vehicle — encapsulate fields, declare abstract cost method.
 */
public abstract class Vehicle {
    // TODO private fields + ctor + getters
    private final String make;
    private final String model;
    public abstract double fuelCostPer100Km();
    
    Vehicle(String make, String model) {
        this.make = make;
        this.model = model;
    }

    public String getMake() {
        return make;
    }

    public String getModel() {
        return model;
    }
}