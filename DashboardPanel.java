import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.net.URI;

public class DashboardPanel extends JPanel {
    private DataManager historyDb = new DataManager("qr_history.txt");
    private boolean isDarkMode = false;
    private JPanel listPanel;
    private JFrame parent;

    public DashboardPanel(JFrame frame, CardLayout cl, JPanel container) {
        this.parent = frame;
        setLayout(new BorderLayout());
        refreshUI();
    }

    private void refreshUI() {
        removeAll();
        setBackground(isDarkMode ? new Color(30, 30, 30) : Color.WHITE);

        // Header
        JPanel header = new JPanel();
        header.setLayout(new BoxLayout(header, BoxLayout.Y_AXIS));
        header.setOpaque(false);
        header.setBorder(new EmptyBorder(20, 20, 20, 20));

        JLabel logo = new JLabel("Online QR Generator");
        logo.setFont(new Font("Arial", Font.BOLD, 22));
        logo.setForeground(new Color(11, 169, 110));
        logo.setAlignmentX(CENTER_ALIGNMENT);
        
        JButton themeBtn = new JButton(isDarkMode ? "Switch to Light Mode" : "Switch to Dark Mode");
        themeBtn.setAlignmentX(CENTER_ALIGNMENT);
        themeBtn.addActionListener(e -> { isDarkMode = !isDarkMode; refreshUI(); });

        header.add(logo);
        header.add(Box.createVerticalStrut(10));
        header.add(themeBtn);
        add(header, BorderLayout.NORTH);

        // List
        listPanel = new JPanel();
        listPanel.setLayout(new BoxLayout(listPanel, BoxLayout.Y_AXIS));
        listPanel.setBackground(isDarkMode ? new Color(40, 40, 40) : new Color(245, 248, 246));
        listPanel.setBorder(new EmptyBorder(10, 20, 10, 20));

        String[][] types = {{"Website", "🌐"}, {"PDF", "📄"}, {"vCard", "📇"}, {"Social", "📱"}};
        for(String[] t : types) {
            listPanel.add(new ModernCard(t[0], "Create " + t[0] + " QR", t[1], this, isDarkMode));
            listPanel.add(Box.createVerticalStrut(10));
        }

        add(new JScrollPane(listPanel), BorderLayout.CENTER);
        revalidate(); repaint();
    }

    public void onCardClick(String type) {
        String data = JOptionPane.showInputDialog(parent, "Enter " + type + " URL/Data:");
        // Input Validation
        if (data != null && !data.isEmpty()) {
            if (type.equals("Website") && !data.startsWith("http")) {
                JOptionPane.showMessageDialog(parent, "Warning: Link should start with http:// or https://");
            }
            try {
                String api = "https://api.qrserver.com/v1/create-qr-code/?size=300x300&data=" + data;
                Desktop.getDesktop().browse(new URI(api));
                historyDb.writeData("[" + type + "] " + data);
            } catch (Exception ex) { ex.printStackTrace(); }
        }
    }
}
