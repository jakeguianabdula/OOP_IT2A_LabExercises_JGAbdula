package EXER6_Abdula;

public class InheritanceWithInterfacesDemo {
    public static void main(String[] args) {
        // Create product instances
        Book book = new Book("Java Programming Book", 50.0);
        Electronics laptop = new Electronics("Gaming Laptop", 1000.0);

        // Demonstrate inheritance and interface implementation
        System.out.println("Product: " + book.getName());
        System.out.println("Price: $" + book.getPrice());
        System.out.println("Tax: $" + book.calculateTax(book.getPrice()));
        System.out.println("Total Price: $" + book.getTotalPrice());
        System.out.println();

        System.out.println("Product: " + laptop.getName());
        System.out.println("Price: $" + laptop.getPrice());
        System.out.println("Tax: $" + laptop.calculateTax(laptop.getPrice()));
        System.out.println("Total Price: $" + laptop.getTotalPrice());
    }
}