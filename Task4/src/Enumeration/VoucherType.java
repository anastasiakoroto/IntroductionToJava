package Enumeration;

public enum VoucherType {
    EXCURSION ("Excursion"),
    SHOPPING ("Shopping"),
    TREATMENT ("Treatment"),
    CRUISE ("Cruise"),
    RELAX  ("Relax");

    private String type;
    VoucherType(String t) {
        this.type = t;
    }
    public String getType() {
        return type;
    }
}
