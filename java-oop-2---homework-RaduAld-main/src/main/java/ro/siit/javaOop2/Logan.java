package ro.siit.javaOop2;

public class Logan extends Dacia {

    public Logan(int availableFuel, String chassisNumber) {
        super(50, "Petrol", 6, 6,
                availableFuel, chassisNumber);
        this.setTireSize(15);
        this.setConsumptionDecreasePerShiftChange(10);  //percentage
        this.setConsumptionIncreasePerTireChange(0.1);  //percentage
    }
}
