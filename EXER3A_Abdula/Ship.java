public class Ship extends WaterTransport {
    private int passengerCapacity;
    public Ship(int speed) {
        super("Ship:", speed, "Steam Engine"); // Default propulsion and name
        this.passengerCapacity = 2200; // Default
    }
    @Override
    public void move() {
        System.out.println(name + " ship is navigating with " + propulsionType + " at " + speed + " km/h, capacity: " + passengerCapacity + " passengers.");
    }
}