package com.pluralsight;
import java.util.Scanner;
public class RentalCarCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Constants for pricing
        final double BASE_RENTAL_RATE = 29.99;
        final double TOLL_TAG_COST = 3.95;
        final double GPS_COST = 2.95;
        final double ROADSIDE_ASSISTANCE_COST = 3.95;
        final double UNDERAGE_SURCHARGE_RATE = 0.30;

        //rental details
        System.out.print("Enter pickup date (ex.YYYY/MM/DD): ");
        String pickupDate = scanner.nextLine();

        System.out.print("Enter number of days for the rental: ");
        int rentalDays = scanner.nextInt();

        // Options
        System.out.print("Do you want an electronic toll tag? (yes/no): ");
        boolean tollTag = scanner.next().equalsIgnoreCase("yes");

        System.out.print("Do you want GPS? (yes/no): ");
        boolean gps = scanner.next().equalsIgnoreCase("yes");

        System.out.print("Do you want roadside assistance? (yes/no): ");
        boolean roadsideAssistance = scanner.next().equalsIgnoreCase("yes");

        System.out.print("Enter your age: ");
        int age = scanner.nextInt();

        //Calculate costs
        double basicCarRentalCost = BASE_RENTAL_RATE * rentalDays;

        //Calculate Costs
        double optionsCost = 0.0;


        if (tollTag){
            optionsCost += TOLL_TAG_COST * rentalDays;
        }
        if (gps){
            optionsCost += GPS_COST * rentalDays;
        }
        if (roadsideAssistance){
            optionsCost += ROADSIDE_ASSISTANCE_COST * rentalDays;
        }

        //Calculate underage driver charge
        double underageSurcharge = (age < 25) ? (basicCarRentalCost * UNDERAGE_SURCHARGE_RATE ) : 0.0;

        //Total cost
        double totalCost = basicCarRentalCost + optionsCost + underageSurcharge;

        // Step 3: Display the costs
        System.out.printf("Basic car rental cost: $%.2f%n", basicCarRentalCost);
        System.out.printf("Options cost: $%.2f%n", optionsCost);
        System.out.printf("Underage driver surcharge: $%.2f%n", underageSurcharge);
        System.out.printf("Total cost: $%.2f%n", totalCost);
    }
}