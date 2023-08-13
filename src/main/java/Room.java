public class Room {
    private final int number;
    private final BedType bedType;

    public Room(int number, BedType bedType) {
        this.number = number;
        this.bedType = bedType;
    }

    @Override
    public String toString() {
        return String.format("Pokój o numerze - %d (%s).", number, bedType);
    }
}
