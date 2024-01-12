import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.event.ActionListener;
import java.sql.*;
public class A_07_User_Update extends JFrame implements ActionListener {
    JLabel l1; JLabel l2; JLabel l3; JLabel l4; JLabel l5; JLabel l6; JLabel l7;
    JTextField tf1; JTextField tf2; JTextField tf3; JTextField tf4; JTextField tf5;
    JButton next; JButton close; Choice cId;
    A_07_User_Update() {
        setSize(750,768);
        setLayout(null);
        setVisible(true);
        setLocationRelativeTo(null);
        setTitle("Shobhit University Gangoh : Update user's Details");
        getContentPane().setBackground(Color.WHITE);

        JLabel sear = new JLabel("Search by User ID. :");
        sear.setBounds(100, 120, 180, 40);
        sear.setFont(new Font("arial", Font.BOLD, 18));
        sear.setForeground(Color.BLUE);

        cId = new Choice();
        cId.setBounds(350,120,200,40);
        cId.setFont(new Font("arial",Font.BOLD,18));
        cId.setBackground(Color.WHITE);

        try {
            Connection conn = ConnectionProvider.getConnnection();
            String q = "select * from UserSignUp";

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(q);
            while (rs.next())
            {
                cId.add(rs.getString("User_ID"));
            }
        }catch (Exception ex1)
        {
            ex1.printStackTrace();
        }

        cId.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                try {
                    Connection conn = ConnectionProvider.getConnnection();
                    String q = "select * from UserSignUp where User_ID ='"+ cId.getSelectedItem() + "' ";
                    Statement stmt = conn.createStatement();
                    ResultSet rs = stmt.executeQuery(q);
                    while (rs.next())
                    {
                        l2.setText(rs.getString("User_ID"));
                        tf1.setText(rs.getString("Name"));
                        tf2.setText(rs.getString("Email_address"));
                        tf3.setText(rs.getString("Contact_no"));
                        tf4.setText(rs.getString("Password"));
                        tf5.setText(rs.getString("Confirmed_password"));
                    }
                }catch (Exception ex2)
                {
                    ex2.printStackTrace();
                }
            }
        });

        JLabel tittle = new JLabel("Update User's Details");
        tittle.setBounds(250, 40, 500, 40);
        tittle.setFont(new Font("arial", Font.BOLD, 30));

        Container c = getContentPane();
        JLabel il1 = new JLabel();
        il1.setIcon(new ImageIcon("src/Images/User_update.png"));
        Dimension size = il1.getPreferredSize();
        il1.setBounds(100,20,size.width, size.height);

        l1 = new JLabel("User ID * : ");
        l1.setBounds(100, 200, 250, 40);
        l1.setFont(new Font("arial", Font.BOLD, 18));

        l2 = new JLabel();
        l2.setBounds(350,200,200,40);
        l2.setFont(new Font("arial",Font.BOLD,24));

        l3 = new JLabel("User Name * : ");
        l3.setBounds(100, 250, 150, 40);
        l3.setFont(new Font("arial", Font.BOLD, 18));

        tf1 = new JTextField();
        tf1.setBounds(350, 250, 300, 40);
        tf1.setFont(new Font("arial", Font.BOLD, 18));

        l4 = new JLabel("Email Address * : ");
        l4.setBounds(100, 300, 300, 40);
        l4.setFont(new Font("arial", Font.BOLD, 18));

        tf2 = new JTextField();
        tf2.setBounds(350, 300, 300, 40);
        tf2.setFont(new Font("arial", Font.BOLD, 18));

        l5 = new JLabel("Contact No * : ");
        l5.setBounds(100, 350, 200, 40);
        l5.setFont(new Font("arial", Font.BOLD, 18));

        tf3 = new JTextField();
        tf3.setBounds(350, 350, 300, 40);
        tf3.setFont(new Font("arial", Font.BOLD, 18));

        l6 = new JLabel("Created Password * : ");
        l6.setBounds(100, 400, 200, 40);
        l6.setFont(new Font("arial", Font.BOLD, 18));

        tf4 = new JTextField();
        tf4.setBounds(350, 400, 300, 40);
        tf4.setFont(new Font("arial", Font.BOLD, 18));

        l7 = new JLabel("Confirmed Password * :");
        l7.setBounds(100,450,250,40);
        l7.setFont(new Font("arial",Font.BOLD,18));

        tf5 = new JTextField();
        tf5.setBounds(350, 450, 300, 40);
        tf5.setFont(new Font("arial", Font.BOLD, 18));

        try {
            Connection conn = ConnectionProvider.getConnnection();
            String q = "select * from UserSignUp where User_ID ='"+ cId.getSelectedItem() + "' ";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(q);
            while (rs.next())
            {
                l2.setText(rs.getString("User_ID"));
                tf1.setText(rs.getString("Name"));
                tf2.setText(rs.getString("Email_address"));
                tf3.setText(rs.getString("Contact_no"));
                tf4.setText(rs.getString("Password"));
                tf5.setText(rs.getString("Confirmed_password"));
            }
        }catch (Exception ex2)
        {
            ex2.printStackTrace();
        }

        next = new JButton("Update");
        next.setBounds(520, 620, 130, 40);
        next.setFont(new Font("arial", Font.BOLD, 18));
        next.setForeground(Color.WHITE);
        next.setBackground(Color.BLACK);

        close = new JButton("Close");
        close.setBounds(350, 620, 130, 40);
        close.setFont(new Font("arial", Font.BOLD, 18));
        close.setForeground(Color.WHITE);
        close.setBackground(Color.BLACK);

        add(il1); add(tittle); add(l1); add(l2); add(l3);
        add(l4); add(l5); add(l6); add(l7);

        add(tf1); add(tf2); add(tf3); add(tf4); add(tf5);
        add(sear); add(cId);

        add(next); add(close);
        next.addActionListener(this);
        close.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == close) {
            setVisible(false);
        }

        if (e.getSource() == next) {
            try {
                String ID = "" + l2.getText();
                String name = "" + tf1.getText();
                String email = "" + tf2.getText();
                String cont_no = "" + tf3.getText();
                String password = "" + tf4.getText();
                String con_pass = "" + tf5.getText();

                try {
//                    String driver = "com.mysql.cj.jdbc.Driver";schoolarshipmanagementsystem";
//
//                    String username = "root";
//                    String password = "rna@2004";
//                    Class.forName(driver);
//                    Connection conn = DriverManager.getConnection(url, username, password);
                    Connection conn = ConnectionProvider.getConnnection();
                    String q1 = "update UserSignUp set Name = '" + name + "', Email_address = '" + email + "', Contact_no = '" + cont_no + "', Password = '" + password + "', Confirmed_password = '" + con_pass + "' where User_ID = '" + ID + "'";
                    Statement stmt = conn.createStatement();
                    stmt.executeUpdate(q1);
                    System.out.println("Database connected..");
                    System.out.println("Your data has been updated..");

                    setVisible(false);
                    new A_04_AdminAuthority().setVisible(true);
                    JOptionPane.showMessageDialog(null, "User's Details Updated Securely");
                }catch (Exception ex)
                {
                    ex.printStackTrace();
                }
            } catch (Exception ex1) {
                ex1.getStackTrace();
            }
        }
    }
    public static void main(String[] args) {
        new A_07_User_Update();
    }
}