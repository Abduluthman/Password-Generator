import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int desiredPasswordLength;
        Scanner in = new Scanner(System.in);
        System.out.println("This is a password generator: ");
        System.out.println("How long would you want your password to be? ");
        desiredPasswordLength = in.nextInt();

        Generator passwordGenerated = new Generator();
        String password = passwordGenerated.generatePassword(desiredPasswordLength);

        System.out.println("Your Password Is: " + password);
    }
}