package TypesOfVouchers;

import Enumeration.VoucherType;

import java.util.ArrayList;
import java.util.Comparator;

public class Trip {
    private String voucher;
    private int mealType;
    private int transportType;
    //Trip() {}
    Trip(String typeOfV, int meal, int transport) {
        this.voucher = typeOfV;
        this.mealType = meal;
        this.transportType = transport;
    }

    public int getMealType() {
        return mealType;
    }

    public int getTransportType() {
        return transportType;
    }

    public String getVoucher() {
        return voucher;
    }

    public void chosenType(ArrayList<ArrayList> arrayList) {

    }
    public void chosenMeal(ArrayList<ArrayList> arrayList) {

    }
    public void chosenTransport(ArrayList<ArrayList> arrayList) {

    }
}
