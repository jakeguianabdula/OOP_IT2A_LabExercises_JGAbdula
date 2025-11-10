public class Boat extends WaterTransport {
    private boolean motorized;
    public Boat(int speed) {
        super("Boat:", speed, "Outboard Motor"); // Default propulsion and name
        this.motorized = true; // Default
    }
    @Override
    public void move() {
        System.out.println(name + " boat is cruising with " + propulsionType + " at " + speed + " km/h, motorized: " + motorized + ".");
    }
}