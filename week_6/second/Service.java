package TU_Java.week_6.second;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Service {
    private final ArrayList<Device> goodDevices;
    private final ArrayList<BrokenDevice> brokenDevices;

    public Service() {
        this.goodDevices = new ArrayList<>();
        this.brokenDevices = new ArrayList<>();
        readDevicesFromFile(goodDevices);
        readBrokenDevicesFromFile(brokenDevices);
    }

    public void inputDevice() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            System.out.print("Enter device type (good/broken): ");
            String deviceType = reader.readLine().toLowerCase();
            if ("good".equalsIgnoreCase(deviceType)) {
                Device device = new Device();
                device.inputDeviceInfo();
                goodDevices.add(device);
                writeDevicesToFile(goodDevices);
            } else if ("broken".equalsIgnoreCase(deviceType)) {
                BrokenDevice brokenDevice = new BrokenDevice();
                brokenDevice.inputBrokenDeviceInfo();
                brokenDevices.add(brokenDevice);
                writeBrokenDevicesToFile(brokenDevices);
            } else {
                System.out.println("Invalid device type.");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void displayDevices() {
        System.out.println("Good devices: ");
        for (Device device : goodDevices) {
            device.displayDeviceInfo();
        }

        System.out.println("\nBroken devices: ");
        for (BrokenDevice brokenDevice : brokenDevices) {
            brokenDevice.displayBrokenDeviceInfo();
        }
    }

    public void addDevice(Device device) {
        if (device instanceof BrokenDevice) {
            brokenDevices.add((BrokenDevice) device);
            writeBrokenDevicesToFile(brokenDevices);
        } else {
            goodDevices.add(device);
            writeDevicesToFile(goodDevices);
        }
    }

    public void repairedDevice(BrokenDevice brokenDevice) {
        brokenDevices.remove(brokenDevice);
        addDevice(brokenDevice);
    }

    public void printDevicesWithSymptom(String symptom) {
        for (BrokenDevice brokenDevice : brokenDevices) {
            if (brokenDevice.getSymptoms().equals(symptom)) {
                brokenDevice.displayBrokenDeviceInfo();
            }
        }
    }

    public double calculateTotalPrice() {
        double total = 0;
        for (Device device : goodDevices) {
            total += device.getPrice();
        }
        for (BrokenDevice brokenDevice : brokenDevices) {
            total += brokenDevice.getPrice();
        }
        return total;
    }

    public double calculatePotentialRevenue(double repairPricePerDay) {
        double potentialRevenue = 0;
        for (BrokenDevice brokenDevice : brokenDevices) {
            potentialRevenue += brokenDevice.getRepairTime() * repairPricePerDay;
        }
        return potentialRevenue;
    }

    private void readDevicesFromFile(List<Device> devices) {
        try (BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\vesko\\OneDrive\\Desktop\\Programming\\SoftUni\\SoftUni\\src\\TU_Java\\week_6\\second\\good_devices.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(", ");
                String brand = parts[0];
                String model = parts[1];
                double price = Double.parseDouble(parts[2]);
                devices.add(new Device(brand, model, (int) price));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void readBrokenDevicesFromFile(List<BrokenDevice> brokenDevices) {
        try (BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\vesko\\OneDrive\\Desktop\\Programming\\SoftUni\\SoftUni\\src\\TU_Java\\week_6\\second\\broken_devices.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(", ");
                String brand = parts[0];
                String model = parts[1];
                double price = Double.parseDouble(parts[2]);
                String symptoms = parts[3];
                int repairTime = Integer.parseInt(parts[4]);
                brokenDevices.add(new BrokenDevice(brand, model, (int) price, symptoms, repairTime));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void writeDevicesToFile(List<Device> devices) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("C:\\Users\\vesko\\OneDrive\\Desktop\\Programming\\SoftUni\\SoftUni\\src\\TU_Java\\week_6\\second\\good_devices_output.txt"))) {
            for (Device device : devices) {
                bw.write(device.getBrand() + "," + device.getModel() + "," + device.getPrice());
                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void writeBrokenDevicesToFile(List<BrokenDevice> brokenDevices) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("C:\\Users\\vesko\\OneDrive\\Desktop\\Programming\\SoftUni\\SoftUni\\src\\TU_Java\\week_6\\second\\broken_devices_output.txt"))) {
            for (BrokenDevice brokenDevice : brokenDevices) {
                bw.write(brokenDevice.getBrand() + "," + brokenDevice.getModel() + "," +
                        brokenDevice.getPrice() + "," + brokenDevice.getSymptoms() + "," +
                        brokenDevice.getRepairTime());
                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Service service = new Service();

        System.out.print("Continue/End: ");
        String input = scanner.nextLine();
        while (!input.equalsIgnoreCase("end")){
            service.inputDevice();
            System.out.print("Continue/End: ");
            input = scanner.nextLine();
        }

        service.displayDevices();

        System.out.print("\nEnter a symptom to search for: ");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            String symptom = reader.readLine();
            service.printDevicesWithSymptom(symptom);
        } catch (IOException e) {
            e.printStackTrace();
        }

        double totalPrice = service.calculateTotalPrice();
        System.out.println("\nTotal Price of All Devices: $" + totalPrice);

        System.out.print("Enter repair price per day: $");
        try {
            double repairPricePerDay = Double.parseDouble(reader.readLine());
            double potentialRevenue = service.calculatePotentialRevenue(repairPricePerDay);
            System.out.println("Potential Revenue from Repairs: $" + potentialRevenue);
        } catch (IOException | NumberFormatException e) {
            e.printStackTrace();
        }
    }
}
