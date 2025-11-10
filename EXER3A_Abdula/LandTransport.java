public class LandTransport extends Transportation {
    protected int wheels;
    public LandTransport(String name, int speed, int wheels) {
        super(name, speed);
        this.wheels = wheels;
    }
    @Override
    public void move() {
        System.out.println(name + " is driving on land with " + wheels + " wheels at " + speed + " km/h.");
    }
}