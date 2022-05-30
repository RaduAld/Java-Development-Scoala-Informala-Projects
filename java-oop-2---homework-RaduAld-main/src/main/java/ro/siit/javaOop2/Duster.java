package ro.siit.javaOop2;

public class Duster extends Dacia {

    public Duster(int availableFuel, String chassisNumber) {
        super(60, "Diesel", 5, 6.5,
                availableFuel, chassisNumber);
        this.setTireSize(17);
        this.setConsumptionDecreasePerShiftChange(5);  //percentage
        this.setConsumptionIncreasePerTireChange(0.02);
    }

}
