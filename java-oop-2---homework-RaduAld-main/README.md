#Java OOP 2

NOTE:

    Homework must be posted to github classroom OR, worst case, in ZIP file to Moodle. The ZIP file MUST NOT contain .class files; Only source files are permitted

##Requirements

Please implement the following classes based on the definition.
Use the provided code to run/test your implementation

Implement a hierarchy of Car classes where:

**Car** is a type of vehicle:
* properties of a car model which can not change: fuelTankSize, fuelType (PETROL, DIESEL, etc), gears (max 6), consumptionPer100Km (i.e 4.7)
* properties that are configurable: availableFuel, tireSize(15, 17, etc)
* properties that are instance specific: chassisNumber

Behavior:

* a car can be driven for N kms in different gears;
* consumptionPer100Km is the consumption of the car in cruising mode (last gear).
* During a start() and a stop() the car keeps track of the how much it has consumed.
* On every start() the consumption stats are reset.

## Task:

Implement the classes, abstract classes and interfaces according to the given information.

Create at least 2 car brands with 2 models for each (e.g Volkswagen: VWGolf, VWPassat; Mercedes: CKlasse, SKlasse).

Make sure each car has different consumption.


e.g

Some cars might have a 10% decrease every time they shift up.

Some cars might have an increase in consumption with larger tires.

API:


```Car car = new Car(); // This should not compile.

Car car = new Dacia(27, "oiqe0934hkkadsn"); // This should not compile! If I want to create a Dacia car, I will need to create an instance of a Dacia model.

// 27 = available fuel ; "oiqe0934hkkadsn" = chasis number
Car car = new Logan(27, "oiqe0934hkkadsn"); // Logan can extend from Dacia, while Dacia extends from Car

car.start();

car.shiftGear(1);

car.drive(0.01);// drives 0.01 KMs

car.shiftGear(2);

car.drive(0.02);

car.shiftGear(3);

car.drive(0.5);

car.shiftGear(4);

car.drive(0.5);

car.shiftGear(4);

car.drive(0.5);

car.shiftGear(5);

car.drive(10);

car.shiftGear(4);

car.drive(0.5);

car.shiftGear(3);

car.drive(0.1);

car.stop();

float availableFuel = car.getAvailableFuel();

float fuleConsumedPer100Km = car.getAverageFuelConsumption();


Vehicle vehicle = new VWGolf(30, "1987ddkshik289"); //available fuel and chassis number

vehicle.start();

vehicle.drive(1km);

vehicle.stop();

Car car = (Car) vehicle;

float availableFuel = car.getAvailableFuel();

float fuleConsumedPer100Km = car.getAverageFuelConsumption();
```

