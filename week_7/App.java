package TU_Java.week_7;

import java.util.ArrayList;
import java.util.InvalidPropertiesFormatException;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayList<GetProductsTo> products = new ArrayList<>();
        products.add(new Product1("Type1", 10, 121222001, 20));
        products.add(new Product2("Type2", 25, 121222002, 15));
        products.add(new Product2("Type3", 50, 121222003, 42));
        products.add(new Product2("Type4", 75, 121222004, 50));

        ArrayList<DeliveryAPI> devApi = new ArrayList<>();
        devApi.add(new Product1("Type4", 75, 121222003, 50));
        devApi.add(new Product1("Type4", 75, 121222004, 50));
        devApi.add(new Product1("Type4", 75, 121222005, 50));
        devApi.add(new Product1("Type4", 75, 121222006, 50));


        PresentStore presentStore = new PresentStore(products, devApi);

        try {
            System.out.print("Give max price: ");
            int maxPrice = Integer.parseInt(scanner.nextLine());
            ArrayList<GetProductsTo> affordableProducts = presentStore.getProductsByMaxPrice(maxPrice);
            System.out.println("Affordable products:");
            for (GetProductsTo product : affordableProducts) {
                System.out.println("Type: " + product.getType() + ", Price: " + product.getPrice());
            }

            System.out.print("Give  provider ID: ");
            int providerId = Integer.parseInt(scanner.nextLine());
            ArrayList<GetProductsTo> providerProducts = presentStore.getProductsByProviderId(providerId);
            System.out.println("Products from provider with id " + providerId + ":");
            for (GetProductsTo product : providerProducts) {
                System.out.println("Type: " + product.getType() + ", Price: " + product.getPrice());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

