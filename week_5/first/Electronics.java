package TU_Java.week_5.first;

public class Electronics extends  Product{
    private String manufacturer;
    private String model;

    public Electronics(int inventoryNumber, double price, int quantity, Provider provider, String manufacturer, String model) {
        super(inventoryNumber, price, quantity, provider);
        this.manufacturer = manufacturer;
        this.model = model;
    }

    @Override
    protected double getPromotionalPrice() {
        return getPrice() * 0.9;
    }

    @Override
    protected boolean sellProduct(int piece) throws NoMoreProductsException {
        if (getQuantity() >= piece) {
            setQuantity(getQuantity() - piece);
            return true;
        } else {
            throw new NoMoreProductsException("Not enough quantity available");
        }
    }
}
