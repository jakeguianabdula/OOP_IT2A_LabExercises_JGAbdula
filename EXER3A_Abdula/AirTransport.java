public class AirTransport extends Transportation {
    protected int altitude; // in meters
    public AirTransport(String name, int speed, int altitude) {
        super(name, speed);
        this.altitude = altitude;
    }
    @Override
    public void move() {
        System.out.println(name + " is flying at " + speed + " km/h at " + altitude + " meters altitude.");
    }
}
