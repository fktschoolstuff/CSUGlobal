import java.util.Scanner;

public class Crit4 {
    public static void main(String[] args) {
        // Create a Scanner object for user input
        Scanner scanner = new Scanner(System.in);

        // Initialize variables to store total, maximum, minimum, and count of numbers
        double total = 0;
        double max = Double.MIN_VALUE;
        double min = Double.MAX_VALUE;
        int count = 0;

        // Loop until we have read 5 numbers
        while (count < 5) {
            // Prompt the user to enter a floating-point number
            System.out.println("Enter a floating-point number:");
            
            // Read the number from the user
            double num = scanner.nextDouble();

            // Add the number to the total
            total += num;

            // Update max and min if necessary
            max = Math.max(max, num);
            min = Math.min(min, num);

            // Increment the count
            count++;
        }

        // Calculate the average of the numbers
        double average = total / 5;

        // Calculate the interest on the total at 20%
        double interest = total * 0.20;

        // Print the results
        System.out.println("Total: " + total);
        System.out.println("Average: " + average);
        System.out.println("Maximum: " + max);
        System.out.println("Minimum: " + min);
        System.out.println("Interest on total at 20%: " + interest);

        // Close the scanner to free up resources
        scanner.close();
    }
}
