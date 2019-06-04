package WorkWithClient;

import Enumeration.TypesOfMeal;
import Enumeration.TypesOfTransport;
import Enumeration.VoucherType;
import TypesOfVouchers.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class WorkWithClient {
    public static void consultClient() {

        // read file
        ArrayList<ArrayList> arrayList = new ArrayList<>();
        Scanner scanner;
        try {
            scanner = new Scanner(new File("input.txt"));
            while (scanner.hasNextLine()) {
                ArrayList<String> subArray = new ArrayList<>();
                String line = scanner.nextLine();
                while (!line.trim().isEmpty()) {
                    subArray.add(line);
                    line = scanner.nextLine();
                }
                arrayList.add(subArray);
            }
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
            return;
        }
        scanner.close();

        System.out.println("Hello. Our tour company suggests you the following kinds of rest: ");
        // print the list of voucher types
        int index = 0;
        for (VoucherType vt : VoucherType.values()) {
            System.out.println(index + 1 + " - " + vt.getType());
            index++;
        }
        // client chooses the type of voucher
        System.out.println("Press the button of the number of type you prefer: ");
        Scanner sc = new Scanner(System.in);
        int typeOfVoucher = 0;
        try {
            typeOfVoucher = sc.nextInt();
            if ((typeOfVoucher < 1) || (typeOfVoucher > 5)) {
                System.out.println( "Number is out of range. Try to choose another value.");
            }
        }
        catch (InputMismatchException e) {
            System.out.println("Use numbers only.");
        }

        // print the list of meal types
        System.out.println("Choose meal you would like to see:");
        index = 0;
        System.out.println("0 - Any type");
        for (TypesOfMeal tm : TypesOfMeal.values()) {
            System.out.println(index + 1 + " - " + tm.getType());
            index++;
        }
        // client chooses the type of meal
        int chosenMeal = 0;
        try {
            chosenMeal = sc.nextInt();
            if ((chosenMeal < 0) || (chosenMeal > 5)) {
                System.out.println( "Number is out of range. Try to choose another value.");
            }
        }
        catch (InputMismatchException e) {
            System.out.println("Use numbers only.");
        }

        // print the list of transport types
        System.out.println("Choose transport you would like to go on: ");
        index = 0;
        System.out.println("0 - Any type");
        for (TypesOfTransport tt : TypesOfTransport.values()) {
            System.out.println(index + 1 + " - " + tt.getType());
            index++;
        }
        // client chooses the type of transport
        int chosenTransport = 0;
        try {
            chosenTransport = sc.nextInt();
            if ((chosenTransport < 0) || (chosenTransport > 8)) {
                System.out.println( "Number is out of range. Try to choose another value.");
            }
        }
        catch (InputMismatchException e) {
            System.out.println("Use numbers only.");
        }

        // processing of client choice
        switch (typeOfVoucher) {
            case 1:
                ExcursionTrip excursionType = new ExcursionTrip();
                excursionType.chosenType(arrayList);
                excursionType.chosenMeal(arrayList, chosenMeal);
                excursionType.chosenTransport(arrayList, chosenTransport);
                break;
            case 2:
                ShoppingTrip shoppingType = new ShoppingTrip();
                shoppingType.chosenType(arrayList);
                shoppingType.chosenMeal(arrayList, chosenMeal);
                shoppingType.chosenTransport(arrayList, chosenTransport);
                break;
            case 3:
                TreatmentTrip treatmentType = new TreatmentTrip();
                treatmentType.chosenType(arrayList);
                treatmentType.chosenMeal(arrayList, chosenMeal);
                treatmentType.chosenMeal(arrayList, chosenTransport);
                break;
            case 4:
                CruiseTrip cruiseType = new CruiseTrip();
                cruiseType.chosenType(arrayList);
                cruiseType.chosenMeal(arrayList, chosenMeal);
                cruiseType.chosenMeal(arrayList, chosenTransport);
                break;
            case 5:
                RelaxTrip relaxType = new RelaxTrip();
                relaxType.chosenType(arrayList);
                relaxType.chosenMeal(arrayList, chosenMeal);
                relaxType.chosenTransport(arrayList, chosenTransport);
                break;
            default:
                //throw new InputMismatchException("Wrong input!");
                System.out.println("Wrong input. Try again.");
                break;
        }

        System.out.println("Our company found such vouchers for you: ");
        System.out.println("Results: " + arrayList.size());
        if (arrayList.size() != 0) {
            for (int j = 0; j < arrayList.size(); j++) {
                System.out.println("The tour #" + (j + 1) + ":");
                for (int k = 0; k < arrayList.get(j).size(); k++) {
                    System.out.println(arrayList.get(j).get(k));
                }
                System.out.println();
            }
        }
        else {
            System.out.println("Unfortunately, we don't have tours with such parameters.");
            System.out.println("Could we suggest you another voucher?");
        }

        // write results to file
        FileWriter fileWriter;
        try {
            fileWriter = new FileWriter("output.txt");
            fileWriter.write("Our company found such results for you: \n");
            fileWriter.write("Results: " + arrayList.size() + "\n");
            if (arrayList.size() != 0) {
                for (int j = 0; j < arrayList.size(); j++) {
                    fileWriter.write("The tour #" + (j + 1) + ":\n");
                    for (int k = 0; k < arrayList.get(j).size(); k++) {
                        fileWriter.write(arrayList.get(j).get(k) + "\n");
                    }
                    fileWriter.write("\n");
                }
                fileWriter.close();
            } else {
                System.out.println("Unfortunately, we don't have tours with such parameters.");
                System.out.println("Could we suggest you another voucher?");
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}
