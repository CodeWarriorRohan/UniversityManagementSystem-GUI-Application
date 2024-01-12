import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.event.ActionListener;
import java.sql.*;

public class A_05_Student_Details_2 extends JFrame implements ActionListener {
    JLabel l1; JLabel l2; JLabel l3; JLabel l4; JLabel l5;
    JTextField tf1; JTextField tf4; JTextField tf5;
    JComboBox occ; JComboBox inco;
    JButton next; JButton back;
    String Rollno;
    A_05_Student_Details_2(String Rollno) {
        this.Rollno = Rollno;
        setSize(1150, 900);
        setLayout(null);
        setVisible(true);
        setLocationRelativeTo(null);
        setTitle("Shobhit University Gangoh : Parents Details");
        getContentPane().setBackground(Color.WHITE);

        JLabel tittle = new JLabel("New Student's Parents Details");
        tittle.setBounds(350, 50, 500, 40);
        tittle.setFont(new Font("arial", Font.BOLD, 30));

        l1 = new JLabel("Father's Name * : ");
        l1.setBounds(100, 200, 250, 40);
        l1.setFont(new Font("arial", Font.BOLD, 18));

        tf1 = new JTextField();
        tf1.setBounds(350, 200, 300, 40);
        tf1.setFont(new Font("arial", Font.BOLD, 18));

        l2 = new JLabel("Father's Occupation * : ");
        l2.setBounds(100, 250, 300, 40);
        l2.setFont(new Font("arial", Font.BOLD, 18));

        String occupation[] = {"Farmer", "Businessman", "Army", "Government Sector Job", "Private Sector Job", "Others"};
        occ = new JComboBox<>(occupation);
        occ.setBounds(350, 250, 300, 40);
        occ.setFont(new Font("arial", Font.BOLD, 18));
        occ.setBackground(Color.WHITE);

        l3 = new JLabel("Income * : ");
        l3.setBounds(100, 300, 150, 40);
        l3.setFont(new Font("arial", Font.BOLD, 18));

        String inc[] = {"< 1,50,000", "< 2,50,000", "< 5,00,000", "Upto 10,00,000", "None"};
        inco = new JComboBox<>(inc);
        inco.setBounds(350, 300, 300, 40);
        inco.setFont(new Font("arial", Font.BOLD, 18));
        inco.setBackground(Color.WHITE);

        l4 = new JLabel("Contact No * : ");
        l4.setBounds(100, 350, 200, 40);
        l4.setFont(new Font("arial", Font.BOLD, 18));

        tf4 = new JTextField();
        tf4.setBounds(350, 350, 300, 40);
        tf4.setFont(new Font("arial", Font.BOLD, 18));

        l5 = new JLabel("Mother's Name * : ");
        l5.setBounds(100, 400, 150, 40);
        l5.setFont(new Font("arial", Font.BOLD, 18));

        tf5 = new JTextField();
        tf5.setBounds(350, 400, 300, 40);
        tf5.setFont(new Font("arial", Font.BOLD, 18));

        next = new JButton("Next");
        next.setBounds(970, 620, 130, 40);
        next.setFont(new Font("arial", Font.BOLD, 20));
        next.setForeground(Color.WHITE);
        next.setBackground(Color.BLACK);

        back = new JButton("Back");
        back.setBounds(840, 620, 130, 40);
        back.setFont(new Font("arial", Font.BOLD, 20));
        back.setForeground(Color.WHITE);
        back.setBackground(Color.BLACK);

        add(tittle); add(l1); add(l2); add(l3);
        add(l4); add(l5);

        add(tf1); add(occ); add(inco);
        add(tf4); add(tf5);

        add(next); add(back);
        next.addActionListener(this);
        back.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == back) {
            setVisible(false);
            new A_05_Student_Details_1().setVisible(true);
        }

        if (e.getSource() == next) {
            try {
                String F_name = "" + tf1.getText();
                String F_occu = (String) occ.getSelectedItem();
                String income = (String) inco.getSelectedItem();
                String Cont_no = "" + tf4.getText();
                String M_name = "" + tf5.getText();

                if (F_name.equals("")) {
                    JOptionPane.showMessageDialog(null, "Please fill the Father's Name field");
                } else if (F_occu.equals("")) {
                    JOptionPane.showMessageDialog(null, "Please Select Any Occupation Option");
                } else if (income.equals("")) {
                    JOptionPane.showMessageDialog(null, "Please Select Any Income Option");
                } else if (Cont_no.equals("")) {
                    JOptionPane.showMessageDialog(null, "Please fill the Contact Number field");
                } else if (M_name.equals("")) {
                    JOptionPane.showMessageDialog(null, "Please fill the Mother's Name field");
                }
                try {
//                    String driver = "com.mysql.cj.jdbc.Driver";schoolarshipmanagementsystem";
//
//                    String username = "root";
//                    String password = "rna@2004";
//                    Class.forName(driver);
//                    Connection conn = DriverManager.getConnection(url, username, password);
                    Connection conn = ConnectionProvider.getConnnection();
                    String q1 = "insert into Student_Details_2 value('" + Rollno + "','" + F_name + "','" + F_occu + "','" + income + "','" + Cont_no + "','" + M_name + "')";
                    Statement stmt = conn.createStatement();
                    stmt.executeUpdate(q1);
                    System.out.println("Database connected..");
                    System.out.println("Your data has been inserted..");
                    setVisible(false);
                    new A_05_Student_Details_3(Rollno).setVisible(true);
                    JOptionPane.showMessageDialog(null, "Student's Parents Details Stored Securely");
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
        new A_05_Student_Details_2("");
    }
}