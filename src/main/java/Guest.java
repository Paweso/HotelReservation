public class Guest {
    private final String firstname;
    private final String lastname;
    private final int age;
    private final Gender gender;

    public Guest(String firstname, String lastname, int age, Gender gender) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.age = age;
        this.gender = gender;
    }

    @Override
    public String toString() {
        return String.format("Gość - %s %s (%d) (%s).", firstname, lastname, age, gender);
    }
}
