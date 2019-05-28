package Enumeration;

public enum TypesOfTransport {
    BUS ("Bus"),
    TRAIN ("Train"),
    PLANE ("Plane"),
    SHIP ("Ship");

    private String type;
    TypesOfTransport(String t) {
        this.type = t;
    }

    public String getType() {
        return type;
    }
}
