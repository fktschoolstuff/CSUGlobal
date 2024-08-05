package projectFinal;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class AutomobileInventory {
    public static void main(String[] args) {
        Dealership dealership = new Dealership();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            try {
                // Display menu options to the user
                System.out.println("Enter 1 to add a vehicle");
                System.out.println("Enter 2 to remove a vehicle from index starting from 0");
                System.out.println("Enter 3 to list all vehicles");
                System.out.println("Enter 4 to update a vehicle from index starting from 0");
                System.out.println("Enter 5 to print and quit:");
                int choice = scanner.nextInt();
                scanner.nextLine();  // Consume newline left-over

                if (choice == 1) {
                    // Add a new vehicle into ArrayList
                    System.out.println("Enter the make, model, color, year, and mileage of the vehicle (separated by spaces):");
                    String make = scanner.next();
                    String model = scanner.next();
                    String color = scanner.next();
                    int year = scanner.nextInt();
                    int mileage = scanner.nextInt();
                    scanner.nextLine();  // Consume newline left-over
                    Automobile auto = new Automobile(make, model, color, year, mileage);
                    System.out.println(dealership.addVehicle(auto));
                } else if (choice == 2) {
                    // Remove a vehicle from ArrayList index
                    System.out.println("Enter the index of the vehicle to remove:");
                    int index = scanner.nextInt();
                    scanner.nextLine();  // Consume newline left-over
                    if (index < 0 || index >= dealership.listVehicles().size()) {
                        System.out.println("Invalid index");
                    } else {
                        System.out.println(dealership.removeVehicle(dealership.listVehicles().get(index)));
                    }
                } else if (choice == 3) {
                    // List all vehicles in ArrayList
                    for (Automobile auto : dealership.listVehicles()) {
                        for (String info : auto.listVehicleInfo()) {
                            System.out.println(info);
                        }
                        // Print an empty line to add space between vehicles in list
                        System.out.println();
                    }
                } else if (choice == 4) {
                    // Update a vehicle from ArrayList index
                    System.out.println("Enter the index of the vehicle to update:");
                    int index = scanner.nextInt();
                    scanner.nextLine();  // Consume newline left-over
                    if (index < 0 || index >= dealership.listVehicles().size()) {
                        System.out.println("Invalid index");
                    } else {
                        System.out.println("Enter the new make, model, color, year, and mileage of the vehicle (separated by spaces):");
                        String make = scanner.next();
                        String model = scanner.next();
                        String color = scanner.next();
                        int year = scanner.nextInt();
                        int mileage = scanner.nextInt();
                        scanner.nextLine();  // Consume newline left-over
                        Automobile auto = new Automobile(make, model, color, year, mileage);
                        dealership.removeVehicle(dealership.listVehicles().get(index));
                        System.out.println(dealership.addVehicle(auto));
                    }
                } else if (choice == 5) {
                    // Ask if the user wants to print the information to a file
                    System.out.println("Do you want to print the information to a file? (Y/N):");
                    String response = scanner.nextLine();
                    if (response.equalsIgnoreCase("Y")) {
                        printToFile(dealership);
                    } else {
                        System.out.println("A file will not be printed.");
                    }
                    break;
                } else {
                    System.out.println("Invalid choice");
                }
            } catch (Exception e) {
                // Handle any exceptions that occur due to improper user input
                System.out.println("An error occurred: " + e.getMessage());
                scanner.nextLine();  // Consume newline left-over
            }
        }

        scanner.close();
    }

    // Method to print the information to a file
    public static void printToFile(Dealership dealership) {
        // Define the directory and file path
        String directoryPath = "C:\\Temp";
        String filePath = directoryPath + "\\Autos.txt";

        // Create the directory if it doesn't exist
        File directory = new File(directoryPath);
        if (!directory.exists()) {
            directory.mkdirs();
        }

        // Write to the file
        try (FileWriter writer = new FileWriter(filePath)) {
            for (Automobile auto : dealership.listVehicles()) {
                for (String info : auto.listVehicleInfo()) {
                    writer.write(info + System.lineSeparator());
                }
                writer.write(System.lineSeparator()); // Add space between vehicles
            }
            System.out.println("Information has been printed to " + filePath);
        } catch (IOException e) {
            System.out.println("An error occurred while writing to the file: " + e.getMessage());
        }
    }
}
