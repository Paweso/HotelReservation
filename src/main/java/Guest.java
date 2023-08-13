public class Guest {
    private final String firstname;
    private final String lastname;
    private final int age;

    public Guest(String firstname, String lastname, int age) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.age = age;
    }

    @Override
    public String toString() {
        return String.format("Gość - %s %s (%d).", firstname, lastname, age);
    }
}
