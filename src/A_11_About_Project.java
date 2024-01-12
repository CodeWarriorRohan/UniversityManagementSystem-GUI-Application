import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class A_11_About_Project extends JFrame implements ActionListener
{
    JButton about;
    A_11_About_Project() {
        setSize(1366,768);
        setLayout(null);
        setVisible(true);
        setLocationRelativeTo(null);
        setTitle("Shobhit University Gangoh : About Project");
        getContentPane().setBackground(Color.WHITE);

        Container c = getContentPane();
        JLabel il1 = new JLabel();
        il1.setIcon(new ImageIcon("src/Images/About_project1.png"));
        Dimension size = il1.getPreferredSize();
        il1.setBounds(0,0,size.width, size.height);

        Container c1 = getContentPane();
        JLabel il2 = new JLabel();
        il2.setIcon(new ImageIcon("src/Images/about.png"));
        Dimension size1 = il2.getPreferredSize();
        il2.setBounds(1100,630,size1.width, size1.height);

        about = new JButton("About");
        about.setBounds(1175,630,150,50);
        about.setFont(new Font("arial",Font.BOLD,24));
        about.setBackground(Color.DARK_GRAY);
        about.setForeground(Color.WHITE);

        add(il1); il1.add(about); il1.add(il2);

        about.addActionListener(this);
    }
    public void actionPerformed(ActionEvent e)
    {
        if (e.getSource() == about)
        {
            setVisible(false);
            new A_11_About().setVisible(true);
        }
    }
    public static void main(String[] args) {
        new A_11_About_Project();
    }
}


