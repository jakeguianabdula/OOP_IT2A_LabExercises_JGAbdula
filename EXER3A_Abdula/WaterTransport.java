public class WaterTransport extends Transportation {
    protected String propulsionType; // e.g., engine, sail
    public WaterTransport(String name, int speed, String propulsionType) {
        super(name, speed);
        this.propulsionType = propulsionType;
    }
    @Override
    public void move() {
        System.out.println(name + " is sailing on water with " + propulsionType + " propulsion at " + speed + " km/h.");
    }
}