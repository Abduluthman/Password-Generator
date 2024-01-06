import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PasswordGeneratorGUI extends JFrame implements ActionListener {
    private JTextField lengthField;
    private JButton generateButton;
    private JLabel resultLabel;

    public PasswordGeneratorGUI() {
        setTitle("Password Generator");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 200);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        lengthField = new JTextField(10);
        panel.add(new JLabel("Desired Password Length:"));
        panel.add(lengthField);

        generateButton = new JButton("Generate Password");
        generateButton.addActionListener(this);
        panel.add(generateButton);

        resultLabel = new JLabel("");
        panel.add(resultLabel);

        add(panel);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == generateButton) {
            try {
//              Get the desired password length from the text field
                int desiredPasswordLength = Integer.parseInt(lengthField.getText());
//              Create an instance of the Generator class
                Generator passwordGenerator = new Generator();
 //             Generate the password based on the desired length
                String password = passwordGenerator.generatePassword(desiredPasswordLength);
 //             Display the generated password in the result label
                resultLabel.setText("Your Password Is: " + password);
            } catch (NumberFormatException ex) {
 //             Handle the case when a non-numeric value is entered                
                resultLabel.setText("Please enter a valid number.");
            }
        }
    }

    public static void main(String[] args) {
// Run the GUI on the Event Dispatch Thread (EDT) using SwingUtilities.invokeLater
        SwingUtilities.invokeLater(() -> new PasswordGeneratorGUI());
    }
}
