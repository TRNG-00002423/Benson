package vehicle;

import java.util.ArrayList;
import java.util.List;

public class VehicleDemo {
    public static void main(String[] args) {
        List<Vehicle> fleet = new ArrayList<>();
        // TODO: add GasCar, ElectricCar, optionally one that implements AutonomousCapable
        // TODO: polymorphic loop + instanceof demo
        fleet.add(new GasCar("Toyota", "Camry", 8.5, 1.2));
        fleet.add(new ElectricCar("Tesla", "Model 3", 15.0, 0.13));
        fleet.add(new AutonomousCar("Waymo", "One", 10.0, 1.0));

        for(Vehicle v : fleet) {
            System.out.println(v.getMake() + " " + v.getModel() + " costs $" + v.fuelCostPer100Km() + " per 100km");
            if(v instanceof AutonomousCapable){
                System.out.printf("Autonomous Capable: %s%n", ((AutonomousCapable) v).supportsSelfDrive());
            }
        }
    }
}