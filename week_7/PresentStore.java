package TU_Java.week_7;

import java.util.ArrayList;

public class PresentStore {
    private ArrayList<GetProductsTo> products;
    private ArrayList<DeliveryAPI>devApi;


    public PresentStore(ArrayList<GetProductsTo> products, ArrayList<DeliveryAPI> devApi) {
        this.products = products;
        this.devApi = devApi;
    }

    public ArrayList<GetProductsTo> getProductsByMaxPrice(double maxPrice) {
        ArrayList<GetProductsTo> resultList = new ArrayList<>();
        for (GetProductsTo product : products) {
            if (product.getPrice() < maxPrice) {
                resultList.add(product);
            }
        }
        return resultList;
    }

    public ArrayList<GetProductsTo> getProductsByProviderId(int idOfProvider) {
        ArrayList<GetProductsTo> resultList = new ArrayList<>();
        for (DeliveryAPI api : devApi) {
            if (api.getIdOfProvider() == idOfProvider) {

                for (GetProductsTo product : products) {
                    if (product.getType().equals(api.getType(idOfProvider))) {
                        resultList.add(product);
                    }
                }
                break;
            }
        }
        return resultList;
    }
}