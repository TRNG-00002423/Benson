package vehicle;

public class AutonomousCar extends Vehicle implements AutonomousCapable {
    // TODO fields: e.g. litersPer100Km, pricePerLiter
    private final double litersPer100Km;
    private final double pricePerLiter;

    AutonomousCar(String make, String model, double litersPer100Km, double pricePerLiter) {
        super(make, model);
        this.litersPer100Km = litersPer100Km;
        this.pricePerLiter = pricePerLiter;
    }

    @Override
    public double fuelCostPer100Km() {
        return litersPer100Km * pricePerLiter;
    }

    @Override
    public boolean supportsSelfDrive() {
        return true;
    }
}