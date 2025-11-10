package EXER6_Abdula;

public class Book extends Product implements Tax {
    public Book(String name, double price) {
        super(name, price, new VAT()); // Inherits from Product and uses VAT for tax
    }

    // Implementing the Tax interface method (delegating to the composed tax object)
    @Override
    public double calculateTax(double amount) {
        return tax.calculateTax(amount);
    }
}