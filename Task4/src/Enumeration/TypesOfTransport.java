package Enumeration;

public enum TypesOfTransport {
    BUS ("Bus"),
    TRAIN ("Train"),
    PLANE ("Plane"),
    SHIP ("Ship"),
    BUS_SHIP ("Bus + Ship"),
    TRAIN_SHIP ("Train + Ship"),
    PLANE_SHIP ("Plane + Ship"),
    BUS_PLANE ("Bus + Plane");

    private String type;
    TypesOfTransport(String t) {
        this.type = t;
    }

    public String getType() {
        return type;
    }
}
