package TU_Java.week_3.exercise_1;


public abstract class Vehicle {
    private int maxSpeed;
    private String model;
    private int price;

    public int getMaxSpeed() {
        return maxSpeed;
    }

    public void setMaxSpeed(int maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Vehicle(int maxSpeed, String model, int price) {
        this.maxSpeed = maxSpeed;
        this.model = model;
        this.price = price;
    }

    public abstract double checkPromo();
}
