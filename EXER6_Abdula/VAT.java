package EXER6_Abdula;

public class VAT implements Tax {
    private static final double VAT_RATE = 0.12; // 12% VAT rate

    @Override
    public double calculateTax(double amount) {
        return amount * VAT_RATE;
    }
}