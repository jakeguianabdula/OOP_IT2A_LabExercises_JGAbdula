public class Transportation {
    protected String name;
    protected int speed; // in km/h
    public Transportation(String name, int speed) {
        this.name = name;
        this.speed = speed;
    }
    public void move() {
        System.out.println(name + " is moving at " + speed + " km/h.");
    }
}