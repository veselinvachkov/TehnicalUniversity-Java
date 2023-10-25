package TU_Java.week_3.exercise_1;

public class Hovercraft extends Vehicle implements IsSeaVessel, IsLandVehicle {
    private int passengers;
    public Hovercraft(int maxSpeed, String model, int price, int passengers) {
        super(maxSpeed, model, price);
        this.passengers = passengers;
    }

    public int getPassengers() {
        return passengers;
    }

    public void setPassengers(int passengers) {
        this.passengers = passengers;
    }

    @Override
    public double checkPromo() {
        return this.getPrice() * 0.97;
    }

    @Override
    public void enterSea() {
        System.out.print(getPassengers() + getPrice() + getMaxSpeed() + getModel() + checkPromo());
    }
    public void enterLand() {
        System.out.print(getPassengers() + getPrice() + getMaxSpeed() + getModel() + checkPromo());
    }
}
