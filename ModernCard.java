import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;

public class ModernCard extends JPanel {
    private Color bg = Color.WHITE;
    private Color borderCol = new Color(230, 230, 230);

    public ModernCard(String title, String desc, String icon, DashboardPanel dash, boolean isDarkMode) {
        updateTheme(isDarkMode);
        setLayout(new BorderLayout(15, 0));
        setCursor(new Cursor(Cursor.HAND_CURSOR));

        JLabel iconLbl = new JLabel(icon);
        iconLbl.setFont(new Font("Segoe UI Emoji", Font.PLAIN, 30));
        add(iconLbl, BorderLayout.WEST);

        JPanel text = new JPanel(new GridLayout(2, 1));
        text.setOpaque(false);
        JLabel t = new JLabel(title); t.setFont(new Font("Arial", Font.BOLD, 16));
        JLabel d = new JLabel(desc); d.setFont(new Font("Arial", Font.PLAIN, 12));
        
        if(isDarkMode) {
            t.setForeground(Color.WHITE);
            d.setForeground(Color.LIGHT_GRAY);
        } else {
            d.setForeground(Color.GRAY);
        }

        text.add(t); text.add(d);
        add(text, BorderLayout.CENTER);

        addMouseListener(new MouseAdapter() {
            @Override public void mouseClicked(MouseEvent e) { dash.onCardClick(title); }
            @Override public void mouseEntered(MouseEvent e) { 
                setBackground(isDarkMode ? new Color(60, 60, 60) : new Color(245, 255, 250));
                setBorder(new LineBorder(new Color(11, 169, 110), 1, true));
            }
            @Override public void mouseExited(MouseEvent e) { 
                updateTheme(isDarkMode);
            }
        });
    }

    private void updateTheme(boolean dark) {
        setBackground(dark ? new Color(45, 45, 45) : Color.WHITE);
        setBorder(new LineBorder(dark ? new Color(70, 70, 70) : new Color(230, 230, 230), 1, true));
    }
}
