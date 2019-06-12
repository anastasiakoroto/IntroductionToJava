package TypesOfVouchers;

import Enumeration.VoucherType;

import java.util.ArrayList;

public class StructureOfTrip {
    public static void structure(int typeOfVoucher, ArrayList<ArrayList> arrayList,
                                 int chosenMeal, int chosenTransport) {
        switch (typeOfVoucher) {
            case 1:
                Trip excursionType =
                        new ExcursionTrip(VoucherType.EXCURSION.getType(), chosenMeal, chosenTransport);
                //ExcursionTrip excursionType = new ExcursionTrip();
                excursionType.chosenType(arrayList);
                excursionType.chosenMeal(arrayList);
                excursionType.chosenTransport(arrayList);

                break;
            case 2:
                Trip shoppingType =
                        new ShoppingTrip(VoucherType.SHOPPING.getType(), chosenMeal, chosenTransport);
                //ShoppingTrip shoppingType = new ShoppingTrip();
                shoppingType.chosenType(arrayList);
                shoppingType.chosenMeal(arrayList);
                shoppingType.chosenTransport(arrayList);
                break;
            case 3:
                Trip treatmentType =
                        new TreatmentTrip(VoucherType.TREATMENT.getType(), chosenMeal, chosenTransport);
                //TreatmentTrip treatmentType = new TreatmentTrip();
                treatmentType.chosenType(arrayList);
                treatmentType.chosenMeal(arrayList);
                treatmentType.chosenTransport(arrayList);
                break;
            case 4:
                Trip cruiseType =
                        new CruiseTrip(VoucherType.CRUISE.getType(), chosenMeal, chosenTransport);
                //CruiseTrip cruiseType = new CruiseTrip();
                cruiseType.chosenType(arrayList);
                cruiseType.chosenMeal(arrayList);
                cruiseType.chosenTransport(arrayList);
                break;
            case 5:
                Trip relaxType =
                        new RelaxTrip(VoucherType.RELAX.getType(), chosenMeal, chosenTransport);
                //RelaxTrip relaxType = new RelaxTrip();
                relaxType.chosenType(arrayList);
                relaxType.chosenMeal(arrayList);
                relaxType.chosenTransport(arrayList);
                break;
            default:
                //throw new InputMismatchException("Wrong input!");
                System.out.println("Wrong input. Try again.");
                break;
        }
    }

    public static ArrayList sortByTransport(ArrayList<ArrayList> array) {
        for (int i = 0; i < array.size(); i++) {
            for (int j = 0; j < array.size() - 1; j++) {
                if (array.get(j).get(2).toString().compareTo(array.get(j + 1).get(2).toString()) > 0) {
                    ArrayList<ArrayList> arr = new ArrayList<>();
                    arr.add(array.get(j));
                    array.set(j, array.get(j + 1));
                    array.set(j + 1, arr.get(0));
                    arr.remove(0);
                }
            }
        }
        return array;
    }

    public static ArrayList sortByCountryAndTransport(ArrayList<ArrayList> array) {
        for (int i = 0; i < array.size(); i++) {
            for (int j = 0; j < array.size() - 1; j++) {
                if (array.get(j).get(1).toString().compareTo(array.get(j + 1).get(1).toString()) > 0
                        && array.get(j).get(2).toString().compareTo(array.get(j + 1).get(2).toString()) >= 0) {
                    ArrayList<ArrayList> arr = new ArrayList<>();
                    arr.add(array.get(j));
                    array.set(j, array.get(j + 1));
                    array.set(j + 1, arr.get(0));
                    arr.remove(0);
                }
                else if (array.get(j).get(1).toString().compareTo(array.get(j + 1).get(1).toString()) == 0
                        && array.get(j).get(2).toString().compareTo(array.get(j + 1).get(2).toString()) > 0) {
                    ArrayList<ArrayList> arr = new ArrayList<>();
                    arr.add(array.get(j));
                    array.set(j, array.get(j + 1));
                    array.set(j + 1, arr.get(0));
                    arr.remove(0);
                }
            }
        }
        return array;
    }
}
