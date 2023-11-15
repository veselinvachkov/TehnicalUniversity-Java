package TU_Java.week_5.first;

public abstract class Product {
    private int inventoryNumber;
    private double price;
    private int quantity;
    private Provider provider;

    public Product(int inventoryNumber, double price, int quantity, Provider provider) {
        this.inventoryNumber = inventoryNumber;
        this.price = price;
        this.quantity = quantity;
        this.provider = provider;
    }

    protected abstract double getPromotionalPrice();

    protected abstract boolean sellProduct(int piece) throws NoMoreProductsException;

    public int getInventoryNumber() {
        return inventoryNumber;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public Provider getProvider() {
        return provider;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}