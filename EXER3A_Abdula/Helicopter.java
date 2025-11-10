public class Helicopter extends AirTransport {
    private int rotorBlades;
    public Helicopter(int speed) {
        super("Helicopter:", speed, 3000); // Default altitude and name
        this.rotorBlades = 4; // Default
    }
    @Override
    public void move() {
        System.out.println(name + " helicopter is hovering/flying with " + rotorBlades + " rotor blades at " + speed + " km/h.");
    }
}