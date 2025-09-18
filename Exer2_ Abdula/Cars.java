public class Cars{
    private String brandName;
    private String type;
    private int price;
    private String color;
    private String model;
    private int year;

    public Cars(String brandName, String color, String model, int price, String type, int year) {
        this.brandName = brandName;
        this.color = color;
        this.model = model;
        this.price = price;
        this.type = type;
        this.year = year;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }
}