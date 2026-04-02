package model;

public class Address {
    private String id;
    private String place;

    public Address(String id, String place) {
        this.id = id;
        this.place = place;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    @Override
    public String toString() {
        return "Address{" +
                "id='" + id + '\'' +
                ", place='" + place + '\'' +
                '}';
    }
}
