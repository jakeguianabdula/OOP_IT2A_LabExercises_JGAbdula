package EXER6_Abdula;

public class Electronics extends Product implements Tax {
    public Electronics(String name, double price) {
        super(name, price, new VAT()); // Inherits from Product and uses VAT for tax
    }

    // Implementing the Tax interface method
    @Override
    public double calculateTax(double amount) {
        return tax.calculateTax(amount);
    }
}