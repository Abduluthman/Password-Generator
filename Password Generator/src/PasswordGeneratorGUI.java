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
                int desiredPasswordLength = Integer.parseInt(lengthField.getText());
                Generator passwordGenerator = new Generator();
                String password = passwordGenerator.generatePassword(desiredPasswordLength);
                resultLabel.setText("Your Password Is: " + password);
            } catch (NumberFormatException ex) {
                resultLabel.setText("Please enter a valid number.");
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new PasswordGeneratorGUI());
    }
}
