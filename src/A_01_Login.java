import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class A_01_Login extends JFrame implements ActionListener
{
    JButton admin; JButton user;
    A_01_Login() {
        setSize(1366,768);
        setLayout(null);
        setVisible(true);
        setLocationRelativeTo(null);
        setTitle("Shobhit University Gangoh : Login");
        getContentPane().setBackground(Color.WHITE);

        Label wel = new Label("Welcome To Shobhit University Gangoh");
        wel.setBounds(200,0,1000,100);
        wel.setFont(new Font("arial",Font.BOLD,50));

        Label choose = new Label("Please choose any account");
        choose.setBounds(480,380,550,50);
        choose.setFont(new Font("arial",Font.BOLD,30));

        Container c = getContentPane();
        JLabel il1 = new JLabel();
        il1.setIcon(new ImageIcon("src/Images/Login_logo.png"));
        Dimension size = il1.getPreferredSize();
        il1.setBounds(460,100,size.width, size.height);

        Container c1 = getContentPane();
        JLabel il2 = new JLabel();
        il2.setIcon(new ImageIcon("src/Images/Login_button.jpeg"));
        Dimension size1 = il2.getPreferredSize();
        il2.setBounds(20,495,size1.width, size1.height);

        Container c2 = getContentPane();
        JLabel il3 = new JLabel();
        il3.setIcon(new ImageIcon("src/Images/Login_button.jpeg"));
        Dimension size2 = il3.getPreferredSize();
        il3.setBounds(20,595,size2.width, size2.height);

        admin = new JButton("Admin");
        admin.setBounds(150,510,150,50);
        admin.setFont(new Font("arial",Font.BOLD,20));
        admin.setForeground(Color.WHITE);
        admin.setBackground(Color.BLACK);

        user = new JButton("User");
        user.setBounds(150,610,150,50);
        user.setFont(new Font("arial",Font.BOLD,20));
        user.setForeground(Color.WHITE);
        user.setBackground(Color.BLACK);

        add(il1);
        add(il2); add(il3); add(wel); add(choose);
        add(admin); add(user);

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
        new A_01_Login();
    }
}