public class Room {
    private int number;
    private int beds;

    public Room(int number, int beds) {
        this.number = number;
        this.beds = beds;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getBeds() {
        return beds;
    }

    public void setBeds(int beds) {
        this.beds = beds;
    }

    @Override
    public String toString() {
        return String.format("Pokój o numerze - %d, w którym znajduje się %d łóżek/łóżka.", number, beds);
    }
}
