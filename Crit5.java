import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Crit5 {
    public static void main(String[] args) {
        // Create ArrayLists to store days and temperatures
        ArrayList<String> days = new ArrayList<>();
        ArrayList<Double> temperatures = new ArrayList<>();

        // Add days of the week to the days ArrayList
        days.add("Monday");
        days.add("Tuesday");
        days.add("Wednesday");
        days.add("Thursday");
        days.add("Friday");
        days.add("Saturday");
        days.add("Sunday");

        // Initialize temperatures with null values to indicate no data entered
        for (int i = 0; i < days.size(); i++) {
            temperatures.add(null);
        }

        // Scanner for user input
        Scanner scanner = new Scanner(System.in);
        String input;

        while (true) {
            // Display menu
            System.out.println("Menu:");
            System.out.println("1. Enter temperature for a specific day");
            System.out.println("2. Show temperature for a specific day");
            System.out.println("Week - Show all temperatures and weekly average");
            System.out.println("Exit");
            System.out.print("Enter your choice: ");
            input = scanner.next();

            if (input.equals("1")) {
                // Enter temperature for a specific day - Must be case sensitive
                System.out.print("Enter the day (e.g., Monday): ");
                String day = scanner.next();
                if (days.contains(day)) {
                    int index = days.indexOf(day);
                    System.out.print("Enter the average temperature for " + day + ": ");
                    try {
                        double temp = scanner.nextDouble();
                        temperatures.set(index, temp);
                    } catch (InputMismatchException e) {
                        System.out.println("Invalid input. Please enter a numeric value for temperature.");
                        scanner.next(); // Clear the invalid input
                    }
                } else {
                    System.out.println("Invalid day. Please try again.");
                }
            } else if (input.equals("2")) {
                // Show temperature for a specific day - Must be case sensitive
                System.out.print("Enter the day (e.g., Monday): ");
                String day = scanner.next();
                if (days.contains(day)) {
                    int index = days.indexOf(day);
                    Double temp = temperatures.get(index);
                    if (temp != null) {
                        System.out.println(day + ": " + temp + "°C");
                    } else {
                        System.out.println("Temperature for " + day + " has not been entered yet.");
                    }
                } else {
                    System.out.println("Invalid day. Please try again.");
                }
            } else if (input.equalsIgnoreCase("Week")) {
                // Show all temperatures and weekly average
                double totalTemperature = 0.0;
                int count = 0;
                System.out.println("Temperatures for the week:");
                for (int i = 0; i < days.size(); i++) {
                    Double temp = temperatures.get(i);
                    if (temp != null) {
                        System.out.println(days.get(i) + ": " + temp + "°C");
                        totalTemperature += temp;
                        count++;
                    } else {
                        System.out.println(days.get(i) + ": No data");
                    }
                }
                if (count > 0) {
                    double weeklyAverage = totalTemperature / count;
                    System.out.println("Weekly Average Temperature: " + weeklyAverage + "°C");
                } else {
                    System.out.println("No temperature data available to calculate the weekly average.");
                }
            } else if (input.equalsIgnoreCase("Exit")) {
                // Exit the program
                System.out.println("Exiting the program.");
                break;
            } else {
                System.out.println("Invalid choice. Please try again.");
            }
        }

        // Close the scanner
        scanner.close();
    }
}
