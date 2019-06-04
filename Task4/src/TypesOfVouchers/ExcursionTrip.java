package TypesOfVouchers;

import Enumeration.TypesOfMeal;
import Enumeration.TypesOfTransport;
import Enumeration.VoucherType;

import java.util.ArrayList;
import java.util.List;

public class ExcursionTrip extends TripCharacteristic {

    @Override
    public void chosenType(ArrayList<ArrayList> listAr) {

        for (int i = 0; i < listAr.size(); i++) {
            List<String> f = listAr.get(i);
            String s = f.get(0);
            if (!s.equals(VoucherType.EXCURSION.getType())) {
                listAr.remove(i);
                i--;
            }
        }
    }

    @Override
    public void chosenMeal(ArrayList<ArrayList> arr, int chosen) {
        for (int i = 0; i < arr.size(); i++) {
            List<String> vouchers = arr.get(i);
            String meal = vouchers.get(4);
            if (chosen == 1) {
                if (!meal.equals(TypesOfMeal.TWO.getType())) {
                    arr.remove(i);
                    i--;
                }
            }
            else if (chosen == 2) {
                if (!meal.equals(TypesOfMeal.THREE.getType())) {
                    arr.remove(i);
                    i--;
                }
            }
            else if (chosen == 4) {
                if (!meal.equals(TypesOfMeal.THREE_PLUS.getType())) {
                    arr.remove(i);
                    i--;
                }
            }
        }
    }

    @Override
    public void chosenTransport(ArrayList<ArrayList> arrayList, int chosenTr) {
        for (int i = 0; i < arrayList.size(); i++) {
            List<String> vouchers = arrayList.get(i);
            String transport = vouchers.get(2);
            if (chosenTr == 1) {
                if (!transport.equals(TypesOfTransport.BUS.getType())) {
                    arrayList.remove(i);
                    i--;
                }
            }
            else if (chosenTr == 4) {
                if (!transport.equals(TypesOfTransport.SHIP.getType())) {
                    arrayList.remove(i);
                    i--;
                }
            }
            else if (chosenTr == 5) {
                if (!transport.equals(TypesOfTransport.BUS_SHIP.getType())) {
                    arrayList.remove(i);
                    i--;
                }
            }
            else if (chosenTr == 6) {
                if (!transport.equals(TypesOfTransport.TRAIN_SHIP.getType())) {
                    arrayList.remove(i);
                    i--;
                }
            }
            else if (chosenTr == 8) {
                if (!transport.equals(TypesOfTransport.BUS_PLANE.getType())) {
                    arrayList.remove(i);
                    i--;
                }
            }
        }
    }
}
