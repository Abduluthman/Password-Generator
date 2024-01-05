import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.security.SecureRandom;

public class PasswordGeneratorGUI extends JFrame implements ActionListener {
    private final JTextField lengthTextField;
    private final JCheckBox upperCaseCheckBox;
    private final JCheckBox lowerCaseCheckBox;
    private final JCheckBox numbersCheckBox;
    private final JCheckBox specialCharsCheckBox;
    private final JButton generateButton;
    private final JTextField resultTextLabel;

    public PasswordGeneratorGUI() {
        setTitle("Password Generator");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 250);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        lengthTextField = new JTextField(6);
        panel.add(new JLabel("Password Length: "));
        panel.add(lengthTextField);

        upperCaseCheckBox = new JCheckBox("Include Uppercase");
        lowerCaseCheckBox = new JCheckBox("Include Lowercase");
        numbersCheckBox = new JCheckBox("Include Numbers");
        specialCharsCheckBox = new JCheckBox("Include Special Characters");

        panel.add(upperCaseCheckBox);
        panel.add(lowerCaseCheckBox);
        panel.add(numbersCheckBox);
        panel.add(specialCharsCheckBox);

        generateButton = new JButton("Generate Password");
        generateButton.addActionListener(this);
        panel.add(generateButton);


        resultTextLabel = new JTextField("", 25);
        resultTextLabel.setEditable(false); // Prevents manual editing
        panel.add(resultTextLabel);

        add(panel);
        setVisible(true);
    }

    @SuppressWarnings("SpellCheckingInspection")
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == generateButton) {
            try {
                // Fetch desired password length from the text field
                int desiredPasswordLength = Integer.parseInt(lengthTextField.getText());

                // Check if the entered length is a non-negative number
                if (desiredPasswordLength <= 0) {
                    resultTextLabel.setText("Please enter a positive number.");
                    return;
                }

                // Initialize StringBuilder to collect chosen character sets
                StringBuilder allCharacters = new StringBuilder();

                // Check the selected checkboxes to determine the character sets to include
                if (upperCaseCheckBox.isSelected()) allCharacters.append("ABCDEFGHIJKLMNOPQRSTUVWXYZ");
                if (lowerCaseCheckBox.isSelected()) allCharacters.append("abcdefghijklmnopqrstuvwxyz");
                if (numbersCheckBox.isSelected()) allCharacters.append("0123456789");
                if (specialCharsCheckBox.isSelected()) allCharacters.append("!@#$%^&*()_+-=[]{};:,.<>?");

                // Check if any character set is selected
                if (allCharacters.isEmpty()) {
                    resultTextLabel.setText("Please select at least one character set.");
                    return;
                }

                // Generate the password based on selected character sets and desired length
                String password = generatePassword(desiredPasswordLength, allCharacters.toString());
                // Display the generated password in the result label
                resultTextLabel.setText("Your Password Is: " + password);
            } catch (NumberFormatException ex) {
                // Handle the case when a non-numeric value is entered in the length field
                resultTextLabel.setText("Please enter a valid number.");
            }
        }
    }

    // Method to generate a password using the chosen character sets and desired length
    private String generatePassword(int sizeOfPassword, String characterSet) {
        SecureRandom random = new SecureRandom();
        StringBuilder password = new StringBuilder();

        for (int i = 0; i < sizeOfPassword; i++) {
            int randomIndex = random.nextInt(characterSet.length());
            password.append(characterSet.charAt(randomIndex));
        }
        return password.toString();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(PasswordGeneratorGUI::new);
    }
}