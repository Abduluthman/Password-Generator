import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
//      Variable to store the length of password the user wishes to generate
        int desiredPasswordLength;
//      Creating a scanner to accept user input
        Scanner in = new Scanner(System.in);
        System.out.println("This is a password generator: ");
//      Prompting the user for the desired length of password
        System.out.println("How long would you want your password to be? ");
//      Storing the user input in the variable 
        desiredPasswordLength = in.nextInt();
//      An object for the generator class
        Generator passwordGenerated = new Generator();
//      Invoking the method in class passwordGenerator to generate a password based on user provided length
        String password = passwordGenerated.generatePassword(desiredPasswordLength);

//      Outputing the generated password
        System.out.println("Your Password Is: " + password);
    }
}
