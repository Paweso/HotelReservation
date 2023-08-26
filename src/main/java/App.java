public class App {
    private static final TextUI textUI = new TextUI();

    public static void main(String[] args) {


        String hotelName = "Overlook";
        int systemVersion = 1;
        boolean isDeveloperVersion = false;

        textUI.showWelcomeInformationSystem(hotelName, systemVersion, isDeveloperVersion);

        textUI.showMainMenu();
    }


}
