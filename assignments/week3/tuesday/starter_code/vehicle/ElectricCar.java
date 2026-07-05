package vehicle;

public class ElectricCar extends Vehicle {
    // TODO fields: e.g. kWhPer100Km, pricePerKWh
    private final double kWhPer100Km;
    private final double pricePerKWh;

    ElectricCar(String make, String model, double kWhPer100Km, double pricePerKWh){
        super(make, model);
        this.kWhPer100Km = kWhPer100Km;
        this.pricePerKWh = pricePerKWh;
    }

    @Override
    public double fuelCostPer100Km() {
        return kWhPer100Km * pricePerKWh;
    }
}