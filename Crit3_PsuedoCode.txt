import java.util.Scanner;

public class Crit3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Prompt for the coupon amount as a decimal
        System.out.print("Enter the coupon amount as a decimal (e.g., 0.10 for 10%): ");
        double coupon = scanner.nextDouble();

        // Ensure the coupon value is set to 10% if it exceeds 100% or is less than or equal to zero
        if (coupon <= 0 || coupon > 1) {
            coupon = 0.10;
        }

        double[] weeklyBills = new double[4];
        double totalBill = 0;

        // Prompt the user for weeks 1-4 grocery bills
        for (int i = 0; i < 4; i++) {
            System.out.print("Enter the grocery bill for week " + (i + 1) + ": ");
            weeklyBills[i] = scanner.nextDouble();
            totalBill += weeklyBills[i];
        }

        // Calculate the monthly and weekly avg for groceries
        double monthlyTotal = totalBill;
        double weeklyAverage = monthlyTotal / 4;

        // Display monthly total and weekly avg without the coupon
        System.out.println("Monthly total without coupon: $" + String.format("%.2f", monthlyTotal));
        System.out.println("Weekly average without coupon: $" + String.format("%.2f", weeklyAverage));

        // Calculate and display monthly total and weekly avg with the coupon
        double monthlyTotalWithCoupon = monthlyTotal * (1 - coupon);
        double weeklyAverageWithCoupon = monthlyTotalWithCoupon / 4;

        System.out.println("Monthly total with coupon: $" + String.format("%.2f", monthlyTotalWithCoupon));
        System.out.println("Weekly average with coupon: $" + String.format("%.2f", weeklyAverageWithCoupon));

        scanner.close();
    }
}
