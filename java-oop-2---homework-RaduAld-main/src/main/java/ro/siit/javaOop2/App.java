package ro.siit.javaOop2;

public class App {

    public static void main(String[] args) {

        Car car1 = new Logan(30, "B675FAR");
        Car car2 = new Duster(30, "IF333IST");
//        Car car3 = new CKlasse(30, "GR47ACS");
//        Car car4 = new SKlasse(30, "BV68OTR");

        car1.start();
        car1.shiftGear(6);
        car1.drive(100);// drives 0.01 KMs
        car1.shiftGear(5);
        car1.drive(100);
        car1.changeTire(16);
        car1.stop();

        car2.start();
        car2.shiftGear(6);
        car2.drive(100);// drives 0.01 KMs
        car2.shiftGear(5);
        car2.drive(100);
        car2.changeTire(16);
        car2.stop();

        float availableFuel = car1.getAvailableFuel();
        System.out.println("\nAvailable fuel: " + availableFuel);

        float fuelConsumedPer100Km = car1.getAverageFuelConsumption();
        System.out.println("\nAverage consumption of car is: " + fuelConsumedPer100Km);

        System.out.println("\nEND");

        //For testing:
//        Vehicle vehicle = new Logan(30, "1987ddkshik289"); //available fuel and chassis number
//
//        vehicle.start();
//
//        vehicle.drive(1);
//
//        vehicle.stop();
//
//        Car car = (Car) vehicle;
//
//        float availableFuel1 = car.getAvailableFuel();
//
//        float fuelConsumedPer100Km1 = car.getAverageFuelConsumption();

    }

}
