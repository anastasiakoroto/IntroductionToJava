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

        // file input
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
        StructureOfTrip.structure(typeOfVoucher, arrayList, chosenMeal, chosenTransport);

        System.out.println("Sort by: 0 - no sort, 1 - transport, 2 - country and transport");
        int chosenSort = 0;
        try {
            chosenSort = sc.nextInt();
        }
        catch (InputMismatchException e) {
            System.out.println("Use numbers only.");
        }

        if (chosenSort == 1) {
            StructureOfTrip.sortByTransport(arrayList);
        } else if (chosenSort == 2) {
            StructureOfTrip.sortByCountryAndTransport(arrayList);
        } else if (chosenSort == 0) {
            System.out.println("Continue without sort.");
        } else {
            //throw new InputMismatchException("Wrong input.");
            System.out.println("Wrong input. Continue without sort.");
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

        FileWriter fileWriter;
        try {
            fileWriter = new FileWriter("output.txt");
            fileWriter.write("Your parameters: " + "\n");
            for (VoucherType vt : VoucherType.values()) {
                if ((vt.ordinal() + 1) == typeOfVoucher)
                    fileWriter.write(vt.getType() + "\n");
            }
            for (TypesOfTransport tt : TypesOfTransport.values()) {
                if ((tt.ordinal() + 1) == chosenTransport) {
                    fileWriter.write(tt.getType() + "\n");
                }
            }
            for (TypesOfMeal tm : TypesOfMeal.values()) {
                if ((tm.ordinal() + 1) == chosenMeal) {
                    fileWriter.write(tm.getType() + "\n");
                }
            }
            //fileWriter.write();
            fileWriter.write("\n" + "Our company found such results for you: \n");
            fileWriter.write("Results: " + arrayList.size() + "\n");
            for (int j = 0; j < arrayList.size(); j++) {
                fileWriter.write("The tour #" + (j + 1) + ":\n");
                for (int k = 0; k < arrayList.get(j).size(); k++) {
                    fileWriter.write(arrayList.get(j).get(k) + "\n");
                }
                fileWriter.write("\n");
            }
            fileWriter.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}

/*switch (typeOfVoucher) {
            case 1:
                // VoucherTest v1 = new VoucherTest(VoucherType.EXCURSION.getType(), chosenMeal, chosenTransport);
                ExcursionTrip excursionType = new ExcursionTrip();
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
        }*/