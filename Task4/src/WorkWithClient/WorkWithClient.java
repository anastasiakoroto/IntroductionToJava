package WorkWithClient;

import Enumeration.TypesOfMeal;
import Enumeration.TypesOfTransport;
import Enumeration.VoucherType;
import TypesOfVouchers.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class WorkWithClient {
    public static void consultClient() {
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
        int index = 0;
        for (VoucherType vt : VoucherType.values()) {
            System.out.println(index + 1 + " " + vt.getType());
            index++;
        }

        System.out.println("Press the button of the number of voucher you like: ");
        Scanner sc = new Scanner(System.in);
        int typeOfVoucher = sc.nextInt();

        System.out.println("Choose meal you would like to see:");
        index = 0;
        for (TypesOfMeal tm : TypesOfMeal.values()) {
            System.out.println(index + 1 + " " + tm.getType());
            index++;
        }
        int chosenMeal = sc.nextInt();

        System.out.println("Choose transport you would like to go on: ");
        index = 0;
        for (TypesOfTransport tt : TypesOfTransport.values()) {
            System.out.println(index + 1 + " " + tt.getType());
            index++;
        }
        int chosenTransport = sc.nextInt();


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
                System.out.println("Wrong input.");
                break;
        }

        System.out.println("Our company found such results for you: ");
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

        /*FileWriter fileWriter;
        try {
            fileWriter = new FileWriter("output.txt");
            fileWriter.write("Our company found such results for you: \n");
            fileWriter.write("Results: " + arrayList.size() + "\n");
            for (int j = 0; j < arrayList.size(); j++) {
                System.out.println("The tour #" + (j + 1) + ":");
                fileWriter.write("The tour #" + (j + 1) + ":\n");
                for (int k = 0; k < arrayList.get(j).size(); k++) {
                    System.out.println(arrayList.get(j).get(k));
                    fileWriter.write(arrayList.get(j).get(k) + "\n");
                }
                fileWriter.write("\n");
                System.out.println();
            }
            fileWriter.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }*/
    }
}
