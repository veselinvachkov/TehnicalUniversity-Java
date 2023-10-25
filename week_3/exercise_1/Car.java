package TU_Java.week_3.exercise_1;

public class Car extends Vehicle implements IsLandVehicle {
    private int kW;
    public Car(int maxSpeed, String model, int price, int kW) {
        super(maxSpeed, model, price);
        this.kW = kW;
    }

    public int getkW() {
        return kW;
    }

    public void setkW(int kW) {
        this.kW = kW;
    }

    @Override
    public double checkPromo() {
        return this.getPrice() * 0.8;
    }

    public void enterLand() {
        System.out.print(getkW() + getPrice() + getMaxSpeed() + getModel() + checkPromo());
    }
}
