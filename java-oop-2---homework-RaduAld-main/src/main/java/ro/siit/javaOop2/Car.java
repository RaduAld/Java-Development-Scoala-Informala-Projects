package ro.siit.javaOop2;

public abstract class Car implements Vehicle {

    final int fuelTankSize;
    final String fuelType;
    final int gears;
    final double consumptionPer100KM;

    int activeGear;
    int availableFuel;
    int tireSize;
    String chassisNumber;

    double consumptionDecreasePerShiftChange;   //percentage
    double consumptionIncreasePerTireChange = 1;    //percentage

    //properties of a car model which can not change: fuelTankSize,
    // fuelType (PETROL, DIESEL, etc), gears (max 6), consumptionPer100Km (i.e 4.7)


    double lastConsumed;

    //Constructor
    public Car(int fuelTankSize, String fuelType, int gears,
               double consumptionPer100KM, int availableFuel, String chassisNumber) {
        this.fuelTankSize = fuelTankSize;
        this.fuelType = fuelType;
        this.gears = gears;
        this.consumptionPer100KM = consumptionPer100KM;
        this.availableFuel = availableFuel;
        this.chassisNumber = chassisNumber;
    }

    //Getters and Setters

    public int getAvailableFuel() {
        return availableFuel;
    }

    public void setTireSize(int tireSize) {
        this.tireSize = tireSize;
    }

    public void setConsumptionDecreasePerShiftChange(double consumptionDecreasePerShiftChange) {
        this.consumptionDecreasePerShiftChange = consumptionDecreasePerShiftChange;
    }

    public void setConsumptionIncreasePerTireChange(double consumptionIncreasePerTyreChange) {
        this.consumptionIncreasePerTireChange = consumptionIncreasePerTyreChange;
    }


    public float getAverageFuelConsumption() {
        float average = 0;
        for (int i = 1; i < gears; i++) {
            average += (100 - this.consumptionPer100KM *
                    consumptionDecreasePerShiftChange *
                    (gears - i) / 100);
        }
        average += 100 - this.consumptionPer100KM;
        average = average / gears;
        return average;
    }

    //Behaviours
    @Override
    public void start() {
        this.lastConsumed = 0;
        System.out.println("\nStart!");
    }

    @Override
    public void stop() {
        System.out.println("\nStop!");
        System.out.println("The car has consumed: " + this.lastConsumed +
                "\nRemaining fuel: " + this.availableFuel);
    }

    @Override
    public void drive(double distance) {
        System.out.println("\nDriving!");
        if (activeGear == gears) {
            this.lastConsumed += distance * this.consumptionPer100KM / 100;
        } else {
            this.lastConsumed += (distance * this.consumptionPer100KM / 100) *
                    (100 - this.consumptionDecreasePerShiftChange * (this.gears - this.activeGear)) / 100;
        }
        System.out.println("Car consumption: " + lastConsumed);
        if (this.lastConsumed > this.availableFuel) {
            System.out.println("You have run out of gas!!");
        }
    }

    public void shiftGear(int newGear) {
        this.activeGear = newGear;
    }

    public void changeTire(int newTyre) {
        this.consumptionIncreasePerTireChange += consumptionIncreasePerTireChange * 0.1;
        this.tireSize = newTyre;
        System.out.println("\nTire changed to " + newTyre);
    }

}
