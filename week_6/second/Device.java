package TU_Java.week_6.second;

import java.util.Scanner;

public class Device {
    private String brand;
    private String model;
    private double price;

    public Device(String brand, String model, double price) {
        setBrand(brand);
        setModel(model);
        setPrice(price);
    }

    public Device() {
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void inputDeviceInfo() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Brand: ");
        setBrand(scanner.nextLine());
        System.out.print("\nModel: ");
        setModel(scanner.nextLine());
        System.out.print("\nPrice: ");
        setPrice(Double.parseDouble(scanner.nextLine()));
    }

    public void displayDeviceInfo() {
        System.out.println("Brand: " + brand + ", Model: " + model + ", Price: " + price);
    }
}
