package TU_Java.week_7;

public class Product1 implements  GetProductsTo, DeliveryAPI{
    private  String type;
    private int price;
    private int idOfProvider;
    private int number;

    public Product1(String type, int price, int idOfProvider, int number) {
        this.type = type;
        this.price = price;
        this.idOfProvider = idOfProvider;
        this.number = number;
    }

    public Product1() {

    }

    @Override
    public double getPrice() {
        return price;
    }
    @Override
    public String getType() {
        return type;
    }
    @Override
    public int getNumber(int idOfProvider) {
        return number;
    }
    @Override
    public String getType(int idOfProvider) {
        return type;
    }
    @Override
    public int getIdOfProvider() {
        return idOfProvider;
    }
}
