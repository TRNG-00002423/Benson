package vehicle;

public class GasCar extends Vehicle {
    // TODO fields: e.g. litersPer100Km, pricePerLiter
    private final double litersPer100Km;
    private final double pricePerLiter;

    GasCar(String make, String model, double litersPer100Km, double pricePerLiter) {
        super(make, model);
        this.litersPer100Km = litersPer100Km;
        this.pricePerLiter = pricePerLiter;
    }

    @Override
    public double fuelCostPer100Km() {
        return litersPer100Km * pricePerLiter;
    }
}