import javax.swing.*;
import java.awt.*;

public class QRSystemPro extends JFrame {
    private CardLayout cardLayout = new CardLayout();
    private JPanel mainContainer = new JPanel(cardLayout);
    private AuthService authService = new SimpleAuth();

    public QRSystemPro() {
        setTitle("QR Pro - Secure & Modern");
        setSize(430, 750); 
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        DashboardPanel dash = new DashboardPanel(this, cardLayout, mainContainer);
        LoginPanel login = new LoginPanel(cardLayout, mainContainer, authService);

        mainContainer.add(login, "LOGIN");
        mainContainer.add(dash, "DASH");

        add(mainContainer);
        setVisible(true);
    }

    public static void main(String[] args) {
        try { UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName()); } catch (Exception e) {}
        SwingUtilities.invokeLater(QRSystemPro::new);
    }
}
