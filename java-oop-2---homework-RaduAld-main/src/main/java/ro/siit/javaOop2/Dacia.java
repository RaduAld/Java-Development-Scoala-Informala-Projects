package ro.siit.javaOop2;

public abstract class Dacia extends Car {

    public Dacia(int fuelTankSize, String fuelType, int gears, double consumptionPer100KM, int availableFuel, String chassisNumber) {
        super(fuelTankSize, fuelType, gears, consumptionPer100KM, availableFuel, chassisNumber);
    }
}
