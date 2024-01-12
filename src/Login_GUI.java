import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class Login_GUI extends JFrame implements ActionListener
{
    JButton admin; JButton user;
    Login_GUI() {
        setSize(1366,768);
        setLayout(null);
        setVisible(true);
        setLocationRelativeTo(null);
        setTitle("Shobhit University Gangoh : Login");
        getContentPane().setBackground(Color.WHITE);

        Container c = getContentPane();
        JLabel il1 = new JLabel();
        il1.setIcon(new ImageIcon("src/Images/Login_page.png"));
        Dimension size = il1.getPreferredSize();
        il1.setBounds(0,0,size.width, size.height);

        ImageIcon Admin = new ImageIcon("src/Images/Admin_Button.jpeg");
        admin = new JButton(Admin);
        admin.setBounds(160,515,150,50);
        admin.setFont(new Font("arial",Font.BOLD,20));
        admin.setBackground(Color.WHITE);

        ImageIcon User = new ImageIcon("src/Images/User_Button.jpeg");
        user = new JButton(User);
        user.setBounds(160,620,150,50);
        user.setFont(new Font("arial",Font.BOLD,20));
        user.setBackground(Color.WHITE);

        add(il1);
        il1.add(admin); il1.add(user);

        admin.addActionListener(this);
        user.addActionListener(this);
    }
    public void actionPerformed(ActionEvent e)
    {
        if (e.getSource() == admin)
        {
            setVisible(false);
            new A_02_AdminLogin().setVisible(true);
        }
        if (e.getSource() == user)
        {
            setVisible(false);
            new A_02_UserLogin().setVisible(true);
        }
    }
    public static void main(String[] args) {
        new Login_GUI();
    }
}

