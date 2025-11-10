public class Kariton extends LandTransport {
    private int loadCapacity; // in kg
    public Kariton(int speed) {
        super("Kariton:", speed, 4); // Default wheels and name
        this.loadCapacity = 500; // Default
    }
    @Override
    public void move() {
        System.out.println(name + " kariton is pulling load at " + speed + " km/h with capacity " + loadCapacity + " kg.");
    }
}
