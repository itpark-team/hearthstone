package tools;

import java.util.Scanner;

public class ConsoleUtil {
    public static void println(String string) {
        System.out.println(string);
    }

    public static int inputInt(String message) {
        int number = 0;
        boolean inputResult = false;

        do {
            try {
                Scanner scanner = new Scanner(System.in);
                System.out.print(message);
                number = scanner.nextInt();
                inputResult = true;
            } catch (Exception e) {
                inputResult = false;
            }

        } while (inputResult == false);

        return number;
    }

    public static String inputString(String message) {
        Scanner scanner = new Scanner(System.in);
        System.out.print(message);
        return scanner.next();
    }

    public static void waitEnter() {
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();
    }

    public static void addVerticalWhiteSpaces() {
        for (int i = 0; i < 2; i++) {
            System.out.println();
        }
    }
}
