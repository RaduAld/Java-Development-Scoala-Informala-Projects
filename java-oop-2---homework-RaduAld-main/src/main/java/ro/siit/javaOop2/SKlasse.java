package ro.siit.javaOop2;

public class SKlasse extends Mercedes {

    public SKlasse(int availableFuel, String chassisNumber) {
        super(80, "Diesel", 5, 9.9,
                availableFuel, chassisNumber);
        this.setTireSize(15);
        this.setConsumptionDecreasePerShiftChange(3);   //percentage
        this.setConsumptionIncreasePerTireChange(0.7);    //percentage
    }
}
