public class TransportationTester {
    public static void main(String[] args) {
        // Air Transport
        Helicopter helicopter = new Helicopter(5);
        Airplane airplane = new Airplane(150);
        SpaceShuttle shuttle = new SpaceShuttle(7);

        // Land Transport
        Truck truck = new Truck(3);
        SUV suv = new SUV(7);
        Tricycle tricycle = new Tricycle(2);
        Motorcycle motorcycle = new Motorcycle(2);
        Kariton kariton = new Kariton(1);

        // Water Transport
        Boat boat = new Boat(20);
        Ship ship = new Ship(30);

        // Testing move() method
        System.out.print("\n===============================================================================================\n");
        System.out.print("Air Transport:");
        System.out.print("\n===============================================================================================\n");
        helicopter.move();
        airplane.move();
        shuttle.move();

        System.out.print("\n===============================================================================================\n");
        System.out.print("Land Transport:");
        System.out.print("\n===============================================================================================\n");
        truck.move();
        suv.move();
        tricycle.move();
        motorcycle.move();
        kariton.move();

        System.out.print("\n===============================================================================================\n");
        System.out.print("Water Transport:");
        System.out.print("\n===============================================================================================\n");
        boat.move();
        ship.move();
    }
}