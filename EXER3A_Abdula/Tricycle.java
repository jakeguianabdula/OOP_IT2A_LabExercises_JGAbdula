public class Tricycle extends LandTransport {
    private boolean hasPedals;
    public Tricycle(int speed) {
        super("Tricycle:", speed, 3); // Default wheels and name
        this.hasPedals = true; // Default
    }
    @Override
    public void move() {
        System.out.println(name + " tricycle is pedaling/driving at " + speed + " km/h with pedals: " + hasPedals + ".");
    }
}