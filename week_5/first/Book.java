package TU_Java.week_5.first;

public class Book extends Product{
    private String author;
    private String title;

    public Book(int inventoryNumber, double price, int quantity, Provider provider, String author, String title) {
        super(inventoryNumber, price, quantity, provider);
        this.author = author;
        this.title = title;
    }

    @Override
    protected double getPromotionalPrice() {
        return getPrice() * 0.5;
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

