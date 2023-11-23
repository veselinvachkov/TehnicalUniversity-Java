package TU_Java.week_6.second;

import java.util.Scanner;

public class BrokenDevice extends Device {
    private String symptoms;
    private int repairTime;
    public BrokenDevice(String brand, String model, double price, String symptoms, int repairTime) {
        super(brand, model, price);
        setSymptoms(symptoms);
        setRepairTime(repairTime);
    }

    public BrokenDevice() {
    }

    public String getSymptoms() {
        return symptoms;
    }

    public void setSymptoms(String symptoms) {
        this.symptoms = symptoms;
    }

    public int getRepairTime() {
        return repairTime;
    }

    public void setRepairTime(int repairTime) {
        this.repairTime = repairTime;
    }

    public void inputBrokenDeviceInfo() {
        super.inputDeviceInfo();
        Scanner scanner = new Scanner(System.in);
        System.out.print("What's broken: ");
        setSymptoms(scanner.nextLine());
        System.out.print("\nRepair time: ");
        setRepairTime(Integer.parseInt(scanner.nextLine()));
    }

    public void displayBrokenDeviceInfo() {
        super.displayDeviceInfo();
        System.out.println("Symptoms: " + symptoms + ", Repair Time: " + repairTime + " days");
    }
}
