public class GuestService {
    GuestRepository repository = new GuestRepository();

    public Guest createNewGuest(String firstName, String lastName, int age, int genderOption) {

        Gender gender = switch (genderOption) {
            case 1 -> Gender.MALE;
            case 2 -> Gender.FEMALE;
            default -> throw new IllegalStateException("Unexpected value: " + genderOption);
        };
        return repository.createNewGuest(firstName, lastName, age, gender);
    }
}
