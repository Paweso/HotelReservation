public class GuestRepository {
    public GuestRepository() {
    }

    public Guest createNewGuest(String firstName, String lastName, int age, Gender gender) {
        return new Guest(firstName, lastName, age, gender);

    }
}
