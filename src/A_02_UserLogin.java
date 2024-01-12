import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class A_02_UserLogin extends JFrame implements ActionListener
{
    JButton login; JButton edit; JButton back; JButton signup; JButton forget;
    JTextField tf1; JPasswordField pf2;
    A_02_UserLogin()
    {
        setSize(1366,768);
        setLayout(null);
        setVisible(true);
        setLocationRelativeTo(null);
        setTitle("Shobhit University Gangoh : Login page");
        getContentPane().setBackground(Color.WHITE);

        Container c = getContentPane();
        JLabel il1 = new JLabel();
        il1.setIcon(new ImageIcon("src/Images/Admin_User_Login.jpg"));
        Dimension size = il1.getPreferredSize();
        il1.setBounds(0,0,size.width, size.height);

        JLabel jl2 = new JLabel("User ID * : ");
        jl2.setFont(new Font("arial",Font.BOLD,25));
        jl2.setBounds(300,450,150,40);

        JLabel jl3 = new JLabel("Password * : ");
        jl3.setFont(new Font("arial",Font.BOLD,25));
        jl3.setBounds(300,500,170,40);

        tf1 = new JTextField();
        tf1.setBounds(500,450,300,40);
        tf1.setFont(new Font("arial",Font.BOLD,20));

        pf2 = new JPasswordField();
        pf2.setBounds(500,500,300,40);
        pf2.setFont(new Font("arial",Font.BOLD,20));

        login = new JButton("SIGN IN");
        login.setBounds(350,600,130,40);
        login.setFont(new Font("arial",Font.BOLD,20));
        login.setBackground(Color.BLACK);
        login.setForeground(Color.WHITE);

        edit = new JButton("EDIT");
        edit.setBounds(500,600,130,40);
        edit.setFont(new Font("arial",Font.BOLD,20));
        edit.setBackground(Color.BLACK);
        edit.setForeground(Color.WHITE);

        back = new JButton("BACK");
        back.setBounds(350,650,130,40);
        back.setFont(new Font("arial",Font.BOLD,20));
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);

        signup = new JButton("SIGN UP");
        signup.setBounds(500,650,130,40);
        signup.setFont(new Font("arial",Font.BOLD,20));
        signup.setBackground(Color.BLACK);
        signup.setForeground(Color.WHITE);

        forget = new JButton("FORGET PASSWORD");
        forget.setBounds(1100,650,250,40);
        forget.setFont(new Font("arial",Font.BOLD,20));
//        forget.setBackground(Color.BLACK);
        forget.setForeground(Color.BLUE);

        add(il1); il1.add(jl2); il1.add(jl3);
        il1.add(tf1); il1.add(pf2); il1.add(login); il1.add(edit);
        il1.add(back); il1.add(signup); il1.add(forget);

        login.addActionListener(this);
        edit.addActionListener(this);
        back.addActionListener(this);
        signup.addActionListener(this);
        forget.addActionListener(this);
    }
    @Override
    public void actionPerformed(ActionEvent e)
    {
        if (e.getSource() == login)
        {
            try {
                Connection conn = ConnectionProvider.getConnnection();
                String ID = "" + tf1.getText();
                String password = "" + pf2.getText();
                String q = "select * from UserSignUp where User_ID = '"+ID+"' and Password = '"+password+"'";

                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(q);
                if (rs.next())
                {
                    setVisible(false);
                    new A_04_UserAuthority().setVisible(true);
                }
                else
                {
                    JOptionPane.showMessageDialog(null,"Incorrect Admin ID or Password");
                }

            }catch (Exception ex)
            {
                ex.printStackTrace();
            }
        }
        if (e.getSource() == edit)
        {
            tf1.setText(null);
            pf2.setText(null);
        }
        if (e.getSource() == back)
        {
            setVisible(false);
            new A_01_Login().setVisible(true);
        }
        if (e.getSource() == signup)
        {
            new A_03_UserSignUp().setVisible(true);
        }
        if (e.getSource() == forget)
        {
            setVisible(false);
            new A_12_Forget_Password_U().setVisible(true);
        }
    }
    public static void main(String[] args)
    {
        new A_02_UserLogin();
    }
}