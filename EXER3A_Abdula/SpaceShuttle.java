public class SpaceShuttle extends AirTransport {
    private boolean reusable;
    public SpaceShuttle(int speed) {
        super("SpaceShuttle:", speed, 400000); // Default altitude and name
        this.reusable = true; // Default
    }
    @Override
    public void move() {
        System.out.println(name + " space shuttle is launching/re-entering at " + speed + " km/h, reusable: " + reusable + ".");
    }
}