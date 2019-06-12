package TypesOfVouchers;

import Enumeration.TypesOfMeal;
import Enumeration.TypesOfTransport;
import Enumeration.VoucherType;

import java.util.ArrayList;
import java.util.List;

public class CruiseTrip extends Trip {

    CruiseTrip(String typeVoucher, int meals, int transport) {
        super(typeVoucher, meals, transport);
    }

    @Override
    public void chosenType(ArrayList<ArrayList> listAr) {
        for (int i = 0; i < listAr.size(); i++) {
            List<String> f = listAr.get(i);
            String s = f.get(0);
            if (!s.equals(VoucherType.CRUISE.getType())) {
                listAr.remove(i);
                i--;
            }
        }
    }

    @Override
    public void chosenMeal(ArrayList<ArrayList> arr) {
        for (int i = 0; i < arr.size(); i++) {
            List<String> vouchers = arr.get(i);
            String meal = vouchers.get(4);
            if (getMealType() == 2) {
                if (!meal.equals(TypesOfMeal.THREE.getType())) {
                    arr.remove(i);
                    i--;
                }
            }
            else if (getMealType() == 3) {
                if (!meal.equals(TypesOfMeal.FIVE.getType())) {
                    arr.remove(i);
                    i--;
                }
            }
            else if (getMealType() == 4) {
                if (!meal.equals(TypesOfMeal.THREE_PLUS.getType())) {
                    arr.remove(i);
                    i--;
                }

            }
            else if (getMealType() == 5) {
                if (!meal.equals(TypesOfMeal.FIVE_PLUS.getType())) {
                    arr.remove(i);
                    i--;
                }
            }

        }
    }

    @Override
    public void chosenTransport (ArrayList<ArrayList> arrayList) {
        for (int i = 0; i < arrayList.size(); i++) {
            List<String> vouchers = arrayList.get(i);
            String transport = vouchers.get(2);
            if (getTransportType() == 4) {
                if (!transport.equals(TypesOfTransport.SHIP.getType())) {
                    arrayList.remove(i);
                    i--;
                }
            }
            else if (getTransportType() == 5) {
                if (!transport.equals(TypesOfTransport.BUS_SHIP.getType())) {
                    arrayList.remove(i);
                    i--;
                }
            }
            else if (getTransportType() == 6) {
                if (!transport.equals(TypesOfTransport.TRAIN_SHIP.getType())) {
                    arrayList.remove(i);
                    i--;
                }
            }
            else if (getTransportType() == 7) {
                if (!transport.equals(TypesOfTransport.PLANE_SHIP.getType())) {
                    arrayList.remove(i);
                    i--;
                }
            }
        }
    }
}
