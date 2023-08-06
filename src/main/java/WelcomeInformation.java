public class WelcomeInformation {
    private final String frameBorder = "*";
    int line = 18;

    public void printInfo(String hotelName, int systemVersion, boolean isDeveloperVersion) {

        String text1 = "Witaj w systemie rezerwacji dla hotelu ";
        String text2 = "Aktualna wersja systemu: ";
        String text3 = "Wersja developerska: ";

        int hotelNameLength = text1.length() + hotelName.length();
        int systemVersionLength = text2.length() + systemVersion;
        int isDeveloperVersionLength;
        if (isDeveloperVersion) {
            isDeveloperVersionLength = text3.length() + 4;
        } else {
            isDeveloperVersionLength = text3.length() + 5;
        }

        int frameLength = hotelNameLength + line;

        printFrameBorder(frameLength);
        printFrameEmptyLine(frameLength);
        printWelcomeText(text1, text2, text3, hotelName, systemVersion, isDeveloperVersion, hotelNameLength, systemVersionLength, isDeveloperVersionLength);
        printFrameEmptyLine(frameLength);
        printFrameBorder(frameLength);
    }

    private void printFrameBorder(int length) {
        for (int i = 0; i < length; i++) {
            System.out.print(frameBorder);
        }
        System.out.println();
    }

    private void printParagraph() {
        for (int i = 0; i < (line - 2) / 2; i++) {
            System.out.print(" ");
        }
    }

    private void printFrameEmptyLine(int length) {
        for (int i = 0; i < length; i++) {
            if (i == 0 || i == length - 1) {
                System.out.print("*");
            } else {
                System.out.print(" ");
            }
        }
        System.out.println();
    }

    private void printBlankCharacter(int hotelNameLength, int text) {
        int result = hotelNameLength - text;
        for (int i = 0; i < result; i++) {
            System.out.print(" ");
        }

    }

    private void printWelcomeText(
            String text1,
            String text2,
            String text3,
            String hotelName,
            int systemVersion,
            boolean isDeveloperVersion,
            int hotelNameLength,
            int systemVersionLength,
            int isDeveloperVersionLength
    ) {
        printInformationTextLine(text1 + hotelName);
        printInformationTextLine();
        printInformationTextLine(text2 + systemVersion);
        printBlankCharacter(hotelNameLength, systemVersionLength);
        printInformationTextLine();
        printInformationTextLine(text3 + isDeveloperVersion);
        printBlankCharacter(hotelNameLength, isDeveloperVersionLength);
        printInformationTextLine();

    }

    private void printInformationTextLine() {
        printParagraph();
        System.out.println(frameBorder);
    }

    private void printInformationTextLine(String text1) {
        System.out.print(frameBorder);
        printParagraph();
        System.out.print(text1);
    }

}
