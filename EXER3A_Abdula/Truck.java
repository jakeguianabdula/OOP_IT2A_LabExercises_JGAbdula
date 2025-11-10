public class Truck extends LandTransport {
    private int cargoCapacity; // in tons
    public Truck(int speed) {
        super("Truck:", speed, 4); // Default wheels and name
        this.cargoCapacity = 5; // Default
    }
    @Override
    public void move() {
        System.out.println(name + " truck is hauling cargo at " + speed + " km/h with capacity " + cargoCapacity + " tons.");
    }
}