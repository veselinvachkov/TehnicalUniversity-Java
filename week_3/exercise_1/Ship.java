package TU_Java.week_3.exercise_1;

public class Ship extends Vehicle implements IsSeaVessel {
    private int deadWeight;
    public Ship(int maxSpeed, String model, int price, int deadWeight) {
        super(maxSpeed, model, price);
        this.deadWeight = deadWeight;
    }

    public int getDeadWeight() {
        return deadWeight;
    }

    public void setDeadWeight(int deadWeight) {
        this.deadWeight = deadWeight;
    }

    @Override
    public double checkPromo() {
        return this.getPrice() * 0.97;
    }

    @Override
    public void enterSea() {
        System.out.print(getDeadWeight() + getPrice() + getMaxSpeed() + getModel() + checkPromo());
    }
}
