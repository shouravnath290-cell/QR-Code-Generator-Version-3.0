import javax.swing.*;
import java.awt.*;

public class LoginPanel extends JPanel {
    public LoginPanel(CardLayout cl, JPanel container, AuthService auth) {
        setBackground(Color.WHITE);
        setLayout(new GridBagLayout());
        GridBagConstraints g = new GridBagConstraints();
        g.insets = new Insets(10, 30, 10, 30);
        g.fill = GridBagConstraints.HORIZONTAL;

        JLabel title = new JLabel("Online QR Generator", JLabel.CENTER);
        title.setFont(new Font("Arial", Font.BOLD, 26));
        title.setForeground(new Color(11, 169, 110));

        JTextField uField = new JTextField(15);
        JPasswordField pField = new JPasswordField(15);
        JButton lBtn = new JButton("Login");
        lBtn.setBackground(new Color(11, 169, 110));
        lBtn.setForeground(Color.WHITE);
        JButton rBtn = new JButton("Register New Account");

        g.gridx = 0; g.gridy = 0; g.gridwidth = 2; add(title, g);
        g.gridy = 1; g.gridwidth = 1; add(new JLabel("Username:"), g);
        g.gridx = 1; add(uField, g);
        g.gridx = 0; g.gridy = 2; add(new JLabel("Password:"), g);
        g.gridx = 1; add(pField, g);
        g.gridx = 0; g.gridy = 3; g.gridwidth = 2; add(lBtn, g);
        g.gridy = 4; add(rBtn, g);

        lBtn.addActionListener(e -> {
            if (auth.authenticate(uField.getText(), new String(pField.getPassword()))) {
                cl.show(container, "DASH");
            } else {
                JOptionPane.showMessageDialog(this, "Error: Invalid Input or User not found!");
            }
        });

        rBtn.addActionListener(e -> {
            if(uField.getText().length() < 3) {
                JOptionPane.showMessageDialog(this, "Username must be 3+ chars!");
            } else {
                auth.register(uField.getText(), new String(pField.getPassword()));
                JOptionPane.showMessageDialog(this, "Success! Account Encrypted & Saved.");
            }
        });
    }
}
