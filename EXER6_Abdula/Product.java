package EXER6_Abdula;

public class Product {
    protected String name;
    protected double price;
    protected Tax tax; // Composition: Product has a Tax

    public Product(String name, double price, Tax tax) {
        this.name = name;
        this.price = price;
        this.tax = tax;
    }

    public double getPrice() {
        return price;
    }

    public double getTotalPrice() {
        return price + tax.calculateTax(price);
    }

    public String getName() {
        return name;
    }
}