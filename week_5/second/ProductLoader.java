package TU_Java.week_5.second;

import Vesko.first.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

class ProductLoader implements ImportData {
    private static final String FILE_NAME = "SalesProducts.txt";

    @Override
    public Object[] importDataFromFile() throws IOException {
        int numberOfRows = getNumberOfRows();
        Product[] products = new Product[numberOfRows];

        try (BufferedReader br = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            int index = 0;

            while ((line = br.readLine()) != null) {
                String[] parts = line.split("#");

                if (parts[0].equals("1")) {
                    products[index] = new Electronics(
                            Integer.parseInt(parts[1]),
                            Double.parseDouble(parts[4]),
                            Integer.parseInt(parts[5]),
                            new Provider(parts[2], parts[3]),
                            parts[6],
                            parts[7]
                    );
                } else if (parts[0].equals("2")) {
                    products[index] = new Book(
                            Integer.parseInt(parts[1]),
                            Double.parseDouble(parts[4]),
                            Integer.parseInt(parts[5]),
                            new Provider(parts[2], parts[3]),
                            parts[6],
                            parts[7]
                    );
                }
                index++;
            }
        } catch (WrongPhoneNumberException e) {
            throw new RuntimeException(e);
        }

        return products;
    }

    private int getNumberOfRows() throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader(FILE_NAME))) {
            int count = 0;
            while (br.readLine() != null) {
                count++;
            }
            return count;
        }
    }
}