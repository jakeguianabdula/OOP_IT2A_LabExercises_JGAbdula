public class Motorcycle extends LandTransport {
    private String engineType;
    public Motorcycle(int speed) {
        super("Motorcycle:", speed, 2); // Default wheels and name
        this.engineType = "V-Twin"; // Default
    }
    @Override
    public void move() {
        System.out.println(name + " motorcycle is speeding with " + engineType + " engine at " + speed + " km/h.");
    }
}