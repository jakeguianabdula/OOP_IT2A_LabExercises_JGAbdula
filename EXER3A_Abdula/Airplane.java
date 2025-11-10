public class Airplane extends AirTransport {
    private int wingspan; // in meters
    public Airplane(int speed) {
        super("Airplane:", speed, 10000); // Default altitude and name
        this.wingspan = 65; // Default
    }
    @Override
    public void move() {
        System.out.println(name + " airplane is cruising at " + speed + " km/h with a wingspan of " + wingspan + " m.");
    }
}