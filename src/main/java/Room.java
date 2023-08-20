import java.util.Arrays;

public class Room {
    private final int number;
    private final BedType[] bedTypes;

    public Room(int number, BedType[] bedTypes) {
        this.number = number;
        this.bedTypes = bedTypes;
    }

    @Override
    public String toString() {
        return String.format("Pokój o numerze - %d (%s).", number, Arrays.toString(bedTypes));
    }
}
