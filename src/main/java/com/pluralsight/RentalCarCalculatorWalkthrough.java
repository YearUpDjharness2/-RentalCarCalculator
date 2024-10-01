package com.pluralsight;
import java.util.*;
public class RentalCarCalculatorWalkthrough {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        //known Values
        double priceOfCarRentalPerDay = 29.99;
        double priceOfTollTagPerDay = 3.95;
        double priceOfGPSPerDay = 2.95;
        double priceOfRoadsideAssistancePerDay = 3.95;
        float underageSurchargePercentage = 0.30f;
        int underageSurchargeCutOffAge =25;



        //est. known values
        String pickupDate = PromptForString("When will you pick this up? (Ex. YYYY/MM/DD): ");
        short numberOfDays = PromptForShort("How many days will you need this car?: ");
        boolean needsTollTag = PromptForYesNo("Do you need a Toll Tag?: ");
        boolean needsGPS = PromptForYesNo("Do you need a GPS?: ");
        boolean needsRoadsideAssistance = PromptForYesNo("Do you need Roadside Assistance?: ");
        byte age = PromptForByte("How old are you?: ");


        //calculate unknown values
        double basicCarRentalFee = numberOfDays * priceOfCarRentalPerDay;
        double costOfTollTag = (needsTollTag) ? (numberOfDays * priceOfTollTagPerDay) : 0;
        double costOfGPS = (needsGPS) ? (numberOfDays * priceOfGPSPerDay) : 0;
        double costOfRoadsideAssistance = (needsRoadsideAssistance) ? (numberOfDays * priceOfRoadsideAssistancePerDay) : 0;
        double optionsTotalFee = costOfTollTag + costOfGPS + costOfRoadsideAssistance;
        double underageSurcharge = (age < underageSurchargeCutOffAge) ? basicCarRentalFee * underageSurchargePercentage : 0;
        double totalCost = basicCarRentalFee + optionsTotalFee + underageSurcharge;




        //calculate results

        double optionscost = 0.0;

      if (needsTollTag){
          optionscost += priceOfTollTagPerDay * numberOfDays;
      }
      if (needsGPS){
          optionscost += priceOfGPSPerDay * numberOfDays;
      }
      if (needsRoadsideAssistance){
          optionscost += priceOfRoadsideAssistancePerDay * numberOfDays;
      }
      //Add underage surcharge
        double underageRate  = (age < 25) ? (basicCarRentalFee * underageSurcharge) : 0.0;
      //total cost
        totalCost = basicCarRentalFee + optionscost + underageSurcharge;

        //display results
        System.out.printf("Basic Car Rental Fee:   %.2f\n", basicCarRentalFee);
        System.out.printf("Options Fee:            %.2f\n", optionsTotalFee);
        System.out.printf("Underage Surcharge Fee: %.2f\n", underageSurcharge);
        System.out.println("-------------------------------------");
        System.out.printf("Total:                   %.2f\n", totalCost);

        System.out.println("Pickup Date");
    }


    public static String PromptForString(String prompt) {
        System.out.print(prompt);
        return scanner.nextLine();
    }

    public static boolean PromptForYesNo(String prompt){
        System.out.print(prompt + " ( Y for yes N for No) ?");
        String userinput = scanner.nextLine();

        return (userinput.equalsIgnoreCase("Y")
                || userinput.equalsIgnoreCase("YES"));
    }
    public static short PromptForShort(String prompt){
        System.out.print(prompt);
        short userinput = scanner.nextShort();
        scanner.nextLine();
        return  userinput;
    }
    public static byte PromptForByte(String prompt){
        System.out.print(prompt);
        byte userinput =scanner.nextByte();
        return userinput;
    }



}