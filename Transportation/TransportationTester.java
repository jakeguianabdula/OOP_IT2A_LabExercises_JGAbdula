public class TransportationTester {
    public static void main(String[] args) {
        // Land Transport
        Transportation kariton = new Kariton();
        Transportation suv = new SUV();
        Transportation tricycle = new Tricycle();
        Transportation motorcycle = new Motorcycle();
        Transportation truck = new truck();
        // Air Transport
        Transportation helicopter = new Helicopter();
        Transportation plane = new Airplane();
        Transportation shuttle = new SpaceShuttle();
        // Water Transport
        Transportation boat = new Boat();
        Transportation submarine = new Submarine();

        // Array of all transports
        Transportation[] transports = {
            helicopter, plane, shuttle,
            truck, suv, tricycle, motorcycle, kariton,
            boat, submarine
        };

        // Display info and movement
        for (Transportation t : transports) {
            t.displayInfo();
            t.move();
            System.out.println("-------------------");
        }
    }
}