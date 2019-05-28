package Enumeration;

public enum TypesOfMeal {
    THREE ("Three meals"),
    FIVE ("Five meals"),
    THREE_PLUS ("Three meals with breakfast buffet."),
    FIVE_PLUS ("Five meals with breakfast buffet.");

    private String type;
    TypesOfMeal (String t) {
        this.type = t;
    }

    public String getType() {
        return type;
    }
}
