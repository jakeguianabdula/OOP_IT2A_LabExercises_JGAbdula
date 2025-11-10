public class SUV extends LandTransport {
    private boolean allWheelDrive;
    public SUV(int speed) {
        super("SUV:", speed, 4); // Default wheels and name
        this.allWheelDrive = true; // Default
    }
    @Override
    public void move() {
        System.out.println(name + " SUV is driving with all-wheel drive: " + allWheelDrive + " at " + speed + " km/h.");
    }
}