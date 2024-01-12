import java.awt.*;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
public class A_12_Forget_Password_U extends JFrame implements ActionListener
{
    JLabel l1; JLabel l2; JLabel l3; JLabel l4; JLabel l5; JLabel l6;
    JTextField tf1; JTextField tf2; JTextField tf3; JTextField tf4; JPasswordField pf5; JPasswordField pf6;
    JButton back; JButton submit;
    A_12_Forget_Password_U()
    {
        setSize(750,768);
        setLayout(null);
        setVisible(true);
        setLocationRelativeTo(null);
        setTitle("Shobhit University Gangoh : User Re-SignUp Page");
        getContentPane().setBackground(Color.WHITE);

        JLabel tittle = new JLabel("Re-Create User Account");
        tittle.setBounds(150, 40, 500, 40);
        tittle.setFont(new Font("arial", Font.BOLD, 40));

        l1 = new JLabel("User ID * : ");
        l1.setBounds(100, 200, 250, 40);
        l1.setFont(new Font("arial",Font.BOLD,18));

        tf1 = new JTextField();
        tf1.setBounds(350, 200, 300, 40);
        tf1.setFont(new Font("arial",Font.BOLD,18));

        l2 = new JLabel("Admin Name * : ");
        l2.setBounds(100, 250, 200, 40);
        l2.setFont(new Font("arial",Font.BOLD,18));

        tf2 = new JTextField();
        tf2.setBounds(350, 250, 300, 40);
        tf2.setFont(new Font("arial",Font.BOLD,18));

        l3 = new JLabel("Email Address  * : ");
        l3.setBounds(100, 300, 170, 40);
        l3. setFont(new Font("arial",Font.BOLD,18));

        tf3 = new JTextField();
        tf3.setBounds(350, 300, 300, 40);
        tf3.setFont(new Font("arial",Font.BOLD,18));

        l4 = new JLabel("Contact No * : ");
        l4.setBounds(100, 350, 200, 40);
        l4. setFont(new Font("arial",Font.BOLD,18));

        tf4 = new JTextField();
        tf4.setBounds(350, 350, 300, 40);
        tf4.setFont(new Font("arial",Font.BOLD,18));

        l5 = new JLabel("Re-Create Password * : ");
        l5.setBounds(100, 400, 220, 40);
        l5.setFont(new Font("arial",Font.BOLD,18));

        pf5 = new JPasswordField();
        pf5.setBounds(350, 400, 300, 40);
        pf5.setFont(new Font("arial",Font.BOLD,20));

        l6 = new JLabel("Confirm Password * : ");
        l6.setBounds(100, 450, 250, 40);
        l6. setFont(new Font("arial",Font.BOLD,18));

        pf6 = new JPasswordField();
        pf6.setBounds(350, 450, 300, 40);
        pf6.setFont(new Font("arial",Font.BOLD,20));

        submit = new JButton("Submit");
        submit.setBounds(520,620,130,40);
        submit.setFont(new Font("arial",Font.BOLD,20));
        submit.setForeground(Color.WHITE);
        submit.setBackground(Color.BLACK);

        back = new JButton("Back");
        back.setBounds(350,620,130,40);
        back.setFont(new Font("arial",Font.BOLD,20));
        back.setForeground(Color.WHITE);
        back.setBackground(Color.BLACK);

        add(tittle); add(l1); add(l2); add(l3); add(l4); add(l5); add(l6);
        add(tf1); add(tf2); add(tf3); add(tf4); add(pf5);  add(pf6);
        add(submit); add(back);

        submit.addActionListener(this);
        back.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        if (e.getSource() == back) {
            setVisible(false);
            new A_02_UserLogin().setVisible(true);
        }
        if (e.getSource() == submit) {
            try {

                String ID = "" + tf1.getText();
                String Name = "" + tf2.getText();
                String Email = "" + tf3.getText();
                String Contact = "" + tf4.getText();
                String Password = "" + pf5.getText();
                String Conpassword = "" + pf6.getText();

                if (ID.equals("")) {
                    JOptionPane.showMessageDialog(null, "Please fill the  Unique ID");
                } else if (Name.equals("")) {
                    JOptionPane.showMessageDialog(null, "Please fill the Name field");
                } else if (Email.equals("")) {
                    JOptionPane.showMessageDialog(null, "Please fill the Email Address");
                } else if (Contact.equals("")) {
                    JOptionPane.showMessageDialog(null, "Please fill the Contact Number");
                } else if (Password.equals("")) {
                    JOptionPane.showMessageDialog(null, "Please Create a strong password");
                }else if (Conpassword.equals("")) {
                    JOptionPane.showMessageDialog(null, "Please Confirm your password");
                    if (Password != Conpassword)
                    {
                        JOptionPane.showMessageDialog(null, "Your confirm password not match \n Please Check");
                    }
                }
                try {
//                    String driver = "com.mysql.cj.jdbc.Driver";
//                    String url = "jdbc:mysql://localhost:3306/studentmanagementsystem";
//
//                    String username = "root";
//                    String password = "rna@2004";
//                    Class.forName(driver);
//                    Connection conn = DriverManager.getConnection(url,username,password);
                    Connection conn = ConnectionProvider.getConnnection();
                    String q = "insert into AdminSignUp value('" +ID+ "','" + Name + "','" + Email + "','" + Contact + "','" + Password + "','" + Conpassword + "')";
                    Statement stmt = conn.createStatement();
                    stmt.executeUpdate(q);
                    System.out.println("Database connected..");
                    System.out.println("Your data has been inserted..");

                    JOptionPane.showMessageDialog(null, "Your admin account is created successfully");
                    setVisible(false);
                    new A_04_AdminAuthority().setVisible(true);
                } catch (Exception ex1) {
                    ex1.getStackTrace();
                }
            }catch(Exception ex2)
            {
                ex2.printStackTrace();
            }
        }
    }



    public static void main(String[] args)
    {
        new A_12_Forget_Password_U();
    }
}


