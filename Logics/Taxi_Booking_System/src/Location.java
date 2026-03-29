public enum Location {
    A(0), B(1), C(2), D(3), E(4), F(5);

    private final int index;

    Location(int index) {
        this.index = index;
    }

    public int distanceTo(Location location) {
        return Math.abs(this.index - location.index) * 15;
    }

    public int travelTimeTo(Location location) {
        return Math.abs(this.index - location.index);
    }

    public int getIndex() {
        return index;
    }
}
