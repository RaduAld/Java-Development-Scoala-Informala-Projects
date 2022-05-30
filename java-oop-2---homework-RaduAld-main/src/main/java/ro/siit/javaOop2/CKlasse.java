package ro.siit.javaOop2;

public class CKlasse extends Mercedes {

    public CKlasse(int availableFuel, String chassisNumber) {
        super(66, "Petrol", 6, 8.1,
                availableFuel, chassisNumber);
        this.setTireSize(16);
        this.setConsumptionDecreasePerShiftChange(6);  //percentage
        this.setConsumptionIncreasePerTireChange(0.015);
    }
}
