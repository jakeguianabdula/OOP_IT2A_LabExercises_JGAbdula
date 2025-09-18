public class CarTester{
    public static void main(String[] args) {
        Cars car1 = new Cars("Toyota", "Red", "Corolla", 20000, "Sedan", 2020);
        Cars car2 = new Cars("Honda", "Blue", "Civic", 22000, "Sedan", 2021);
        Cars car3 = new Cars("Ford", "Black", "Mustang", 30000, "Coupe", 2019);

        System.out.println("Car 1: " + car1.getBrandName() + ", " + car1.getColor() + ", " + car1.getModel() + ", $" + car1.getPrice() + ", " + car1.getType() + ", " + car1.getYear());
        System.out.println("Car 2: " + car2.getBrandName() + ", " + car2.getColor() + ", " + car2.getModel() + ", $" + car2.getPrice() + ", " + car2.getType() + ", " + car2.getYear());
        System.out.println("Car 3: " + car3.getBrandName() + ", " + car3.getColor() + ", " + car3.getModel() + ", $" + car3.getPrice() + ", " + car3.getType() + ", " + car3.getYear());
    }
}