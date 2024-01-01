import java.util.Random;

public class Generator {
//    Creating Arrays with the values that would be used in the password
//    Numerical Values
    private final String[] numbers = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "0"};
//    Lowercase Alphabets
    private final String[] lowerCase = {"a","b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"};
//    Uppercase Alphabets
    private final String[] upperCase = {"A" ,"B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};
//    Special Characters
    private final String[] special = {"!", "£", "$", "%", "^", "&", "*", "#", "/", "?", "@"};
//    A 2-D array that combines all the above arrays together
    private final String[][] allArrays = {numbers, lowerCase, upperCase, special};
//  generatePasswordString a method that generates the password
    public String generatePasswordString(int sizeOfPassword, String[][] arrays){
        Random random = new Random();
        StringBuilder password = new StringBuilder();
        int counter = 0;
        while(counter < sizeOfPassword){
            String[] StringArray = arrays[random.nextInt(arrays.length)];
            String randomString = StringArray[random.nextInt(arrays.length)];
            password.append(randomString);
            counter++;
        }
        return password.toString();
    }
//  generatePassword a method invoked in the main method that recursively calls the generatePasswordString method
    public String generatePassword(int sizeOfPassword){
        return generatePasswordString(sizeOfPassword, allArrays);
    }
}
