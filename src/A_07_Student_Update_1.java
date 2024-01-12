import com.toedter.calendar.JDateChooser;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.event.ActionListener;
import java.sql.*;
public class A_07_Student_Update_1 extends JFrame implements ActionListener {
    JLabel l1; JLabel l2; JLabel l3; JLabel l4; JLabel l5; JLabel l6;
    JLabel l7; JLabel l8; JLabel l9; JLabel l10; JLabel l11; JLabel l12;
    JLabel l13; JLabel l14; JLabel l15; JLabel l16; JLabel l17; JLabel l18;
    JLabel l19; JLabel l20; JLabel l21; JLabel l22; JLabel l23;

    JTextField tf1; JTextField tf2; JTextField tf3; JTextField tf4; JTextField tf5;
    JDateChooser datechooser; JTextField tf6; JTextField tf7; JTextField tf8;
    JTextField tf9; JTextField tf10; JTextField tf11; JTextField tf12;
    JRadioButton jb1; JRadioButton jb2;JRadioButton jb3; JRadioButton jb4;
    JRadioButton jb5; JRadioButton jb6; JRadioButton jb7; JRadioButton jb8;
    JRadioButton jb9; JRadioButton jb10; JRadioButton jb11; Choice crollno;

    JComboBox st; JComboBox rl; JComboBox ct; JComboBox dep; JComboBox course;
    JButton next; JButton close;
    A_07_Student_Update_1() {
        setSize(1160, 900);
        setLayout(null);
        setVisible(true);
        setLocationRelativeTo(null);
        setTitle("Shobhit University Gangoh : Update Student's Personal Details");
        getContentPane().setBackground(Color.WHITE);

        JLabel sear = new JLabel("Search by Roll no. :");
        sear.setBounds(670, 5, 180, 40);
        sear.setFont(new Font("arial", Font.BOLD, 18));
        sear.setForeground(Color.BLUE);

        crollno = new Choice();
        crollno.setBounds(850,5,200,40);
        crollno.setFont(new Font("arial",Font.BOLD,18));
        crollno.setBackground(Color.WHITE);

        try {
            Connection conn = ConnectionProvider.getConnnection();
            String q = "select * from Student_Details_1";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(q);
            while (rs.next())
            {
                crollno.add(rs.getString("Roll_no"));
            }
        }catch (Exception ex1)
        {
            ex1.printStackTrace();
        }

        crollno.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                try {
                    Connection conn = ConnectionProvider.getConnnection();
                    String q = "select * from Student_Details_1 where Roll_no ='"+ crollno.getSelectedItem() + "' ";
                    Statement stmt = conn.createStatement();
                    ResultSet rs = stmt.executeQuery(q);
                    while (rs.next())
                    {
                        tf1.setText(rs.getString("Admission_no"));
                        tf2.setText(rs.getString("Enrollment_no"));
                        tf3.setText(rs.getString("Roll_no"));
                        tf4.setText(rs.getString("First_name"));
                        tf5.setText(rs.getString("Last_name"));
                        tf6.setText(rs.getString("Email_address"));
                        tf7.setText(rs.getString("Contact_no"));
                        ((JTextField) datechooser.getDateEditor().getUiComponent()).setText(rs.getString("Date_of_Birth"));
                        tf8.setText(rs.getString("Aadhaar_no"));
                        tf9.setText(rs.getString("Address"));
                        tf10.setText(rs.getString("City"));
                        tf11.setText(rs.getString("Pin_code"));
                        tf12.setText(rs.getString("Branch"));
                    }
                }catch (Exception ex2)
                {
                    ex2.printStackTrace();
                }
            }
        });

        JLabel tittle = new JLabel("Update Student's Personal Details");
        tittle.setBounds(150, 00, 500, 40);
        tittle.setFont(new Font("arial", Font.BOLD, 30));

        l1 = new JLabel("Admission No * : ");
        l1.setBounds(50, 50, 250, 40);
        l1.setFont(new Font("arial", Font.BOLD, 18));

        tf1 = new JTextField();
        tf1.setBounds(250, 50, 300, 40);
        tf1.setFont(new Font("arial", Font.BOLD, 18));

        l2 = new JLabel("Enrollment No * : ");
        l2.setBounds(50, 100, 250, 40);
        l2.setFont(new Font("arial", Font.BOLD, 18));

        tf2 = new JTextField();
        tf2.setBounds(250, 100, 300, 40);
        tf2.setFont(new Font("arial", Font.BOLD, 18));

        l3 = new JLabel("Roll No * : ");
        l3.setBounds(50, 150, 200, 40);
        l3.setFont(new Font("arial", Font.BOLD, 18));

        tf3 = new JTextField();
        tf3.setBounds(250, 150, 300, 40);
        tf3.setFont(new Font("arial", Font.BOLD, 18));

        l4 = new JLabel("First Name * : ");
        l4.setBounds(50, 200, 150, 40);
        l4.setFont(new Font("arial", Font.BOLD, 18));

        tf4 = new JTextField();
        tf4.setBounds(250, 200, 300, 40);
        tf4.setFont(new Font("arial", Font.BOLD, 18));

        l5 = new JLabel("Last Name * : ");
        l5.setBounds(50, 250, 200, 40);
        l5.setFont(new Font("arial", Font.BOLD, 18));

        tf5 = new JTextField();
        tf5.setBounds(250, 250, 300, 40);
        tf5.setFont(new Font("arial", Font.BOLD, 18));

        l6 = new JLabel("Email Address * : ");
        l6.setBounds(50, 300, 200, 40);
        l6.setFont(new Font("arial", Font.BOLD, 18));

        tf6 = new JTextField();
        tf6.setBounds(250, 300, 300, 40);
        tf6.setFont(new Font("arial", Font.BOLD, 18));

        l7 = new JLabel("Contact No * : ");
        l7.setBounds(50, 350, 150, 40);
        l7.setFont(new Font("arial", Font.BOLD, 18));

        tf7 = new JTextField();
        tf7.setBounds(250, 350, 300, 40);
        tf7.setFont(new Font("arial", Font.BOLD, 18));

        l8 = new JLabel("Date of Birth * : ");
        l8.setBounds(50, 400, 250, 40);
        l8.setFont(new Font("arial", Font.BOLD, 18));

        datechooser = new JDateChooser();
        datechooser.setBounds(250, 400, 300, 40);
        datechooser.setFont(new Font("arial", Font.BOLD, 18));

        l9 = new JLabel("Gender * : ");
        l9.setBounds(50, 450, 100, 40);
        l9.setFont(new Font("arial", Font.BOLD, 18));

        jb1 = new JRadioButton("Male");
        jb1.setBounds(250, 450, 100, 40);
        jb1.setFont(new Font("arial", Font.BOLD, 18));
        jb1.setBackground(Color.WHITE);

        jb2 = new JRadioButton("Female");
        jb2.setBounds(350, 450, 100, 40);
        jb2.setFont(new Font("arial", Font.BOLD, 18));
        jb2.setBackground(Color.WHITE);

        jb3 = new JRadioButton("Others");
        jb3.setBounds(450, 450, 100, 40);
        jb3.setFont(new Font("arial", Font.BOLD, 18));
        jb3.setBackground(Color.WHITE);

        ButtonGroup Gendergroup = new ButtonGroup();
        Gendergroup.add(jb1);
        Gendergroup.add(jb2);
        Gendergroup.add(jb3);

        l10 = new JLabel("Aadhaar Number * : ");
        l10.setBounds(50, 500, 200, 40);
        l10.setFont(new Font("arial", Font.BOLD, 18));

        tf8 = new JTextField();
        tf8.setBounds(250, 500, 300, 40);
        tf8.setFont(new Font("arial", Font.BOLD, 18));

        l11 = new JLabel("Address * : ");
        l11.setBounds(50, 550, 150, 40);
        l11.setFont(new Font("arial", Font.BOLD, 18));

        tf9 = new JTextField();
        tf9.setBounds(250, 550, 300, 40);
        tf9.setFont(new Font("arial", Font.BOLD, 18));

        l12 = new JLabel("City * : ");
        l12.setBounds(50, 600, 100, 40);
        l12.setFont(new Font("arial", Font.BOLD, 18));

        tf10 = new JTextField();
        tf10.setBounds(250, 600, 300, 40);
        tf10.setFont(new Font("arial", Font.BOLD, 18));

        l13 = new JLabel("Pin code * : ");
        l13.setBounds(50, 650, 150, 40);
        l13.setFont(new Font("arial", Font.BOLD, 18));

        tf11 = new JTextField();
        tf11.setBounds(250, 650, 300, 40);
        tf11.setFont(new Font("arial", Font.BOLD, 18));

        l14 = new JLabel("State * : ");
        l14.setBounds(600, 50, 300, 40);
        l14.setFont(new Font("arial", Font.BOLD, 18));

        String state[] = {"Andhra Pradesh", "Arunachal Pradesh", "Assam", "Bihar", "Chhattisgarh", "Goa", "Gujarat", "Haryana", "Himachal Pradesh", "Jammu and Kashmir", "Jharkhand", "Karnataka", "Kerala", "Madhya Pradesh", "Maharashtra", "Manipur", "Meghalaya", "Mizoram", "Nagaland", "Odisha", "Punjab", "Rajasthan", "Sikkim", "Tamil Nadu", "Telangana", "Tripura", "Uttarakhand", "Utter Pradesh", "West Bengal"};
        st = new JComboBox<>(state);
        st.setBounds(750, 50, 300, 40);
        st.setFont(new Font("arial", Font.BOLD, 18));
        st.setBackground(Color.WHITE);

        l15 = new JLabel("Religion * : ");
        l15.setBounds(600, 100, 150, 40);
        l15.setFont(new Font("arial", Font.BOLD, 18));

        String rel[] = {"Hindu", "Muslim", "Sikh", "Christian", "Others"};
        rl = new JComboBox<>(rel);
        rl.setBounds(750, 100, 300, 40);
        rl.setFont(new Font("arial", Font.BOLD, 18));
        rl.setBackground(Color.WHITE);

        l16 = new JLabel("Category * : ");
        l16.setBounds(600, 150, 150, 40);
        l16.setFont(new Font("arial", Font.BOLD, 18));

        String cate[] = {"General", "OBC", "SC", "ST", "Minority"};
        ct = new JComboBox<>(cate);
        ct.setBounds(750, 150, 300, 40);
        ct.setFont(new Font("arial", Font.BOLD, 18));
        ct.setBackground(Color.WHITE);

        l17 = new JLabel("Department * : ");
        l17.setBounds(600, 200, 200, 40);
        l17.setFont(new Font("arial", Font.BOLD, 18));

        String depart[] = {"Department of Computer Science and Engineering",
                "Department of Mechanical and Engineering",
                "Department of Electronics and Electrical Engineering",
                "Department of Civil Engineering",
                "Adarsh Vijendra Institute of Pharmaceutical",
                "Kunver Shekher Vijendra Ayurvadic Medical College & Research Center",
                "Kunver Shekher Vijendra Medical College of Naturopathy and Yogic Science",
                "School of Agriculture and Environmental Sciences",
                "School of Basic and Applied Sciences",
                "School of Biological Engineering and Sience",
                "School of Business Studies and Entrepreneurship",
                "School of Education",
                "School of Law and Constitutional Studies",
                "School of Liberal Arts and Laguages",
        };
        dep = new JComboBox<>(depart);
        dep.setBounds(750, 200, 300, 40);
        dep.setFont(new Font("arial", Font.BOLD, 18));
        dep.setBackground(Color.WHITE);

        l18 = new JLabel("Course * : ");
        l18.setBounds(600, 250, 100, 40);
        l18.setFont(new Font("arial", Font.BOLD, 18));

        String cor[] = {"B.Tech", "B.Sc", "B.Com", "B.A", "B.A.B.L", "B.B.A", "B.C.A", "Polytechnic", "L.L.B", "B.A.M.S", "B.N.Y.S", "D.Pharm.", "B.Pharm.", "M.Tech", "M.Sc", "M.Com", "M.A", "M.B.A", "M.C.A", "M.Pharm.", "Ph.D"};
        course = new JComboBox<>(cor);
        course.setBounds(750, 250, 300, 40);
        course.setFont(new Font("arial", Font.BOLD, 18));
        course.setBackground(Color.WHITE);

        l19 = new JLabel("Branch * : ");
        l19.setBounds(600, 300, 100, 40);
        l19.setFont(new Font("arial", Font.BOLD, 18));

        tf12 = new JTextField();
        tf12.setBounds(750, 300, 300, 40);
        tf12.setFont(new Font("arial", Font.BOLD, 18));

        l20 = new JLabel("Admission Type * : ");
        l20.setBounds(600, 350, 200, 40);
        l20.setFont(new Font("arial", Font.BOLD, 18));

        jb4 = new JRadioButton("Regular");
        jb4.setBounds(840, 350, 100, 40);
        jb4.setFont(new Font("arial", Font.BOLD, 18));
        jb4.setBackground(Color.WHITE);

        jb5 = new JRadioButton("Lateral");
        jb5.setBounds(970, 350, 100, 40);
        jb5.setFont(new Font("arial", Font.BOLD, 18));
        jb5.setBackground(Color.WHITE);

        ButtonGroup Adtypegroup = new ButtonGroup();
        Adtypegroup.add(jb4);
        Adtypegroup.add(jb5);

        l21 = new JLabel("Admission Quota * : ");
        l21.setBounds(600, 400, 250, 40);
        l21.setFont(new Font("arial", Font.BOLD, 18));

        jb6 = new JRadioButton("Counselling");
        jb6.setBounds(840, 400, 130, 40);
        jb6.setFont(new Font("arial", Font.BOLD, 18));
        jb6.setBackground(Color.WHITE);

        jb7 = new JRadioButton("Management");
        jb7.setBounds(970, 400, 140, 40);
        jb7.setFont(new Font("arial", Font.BOLD, 18));
        jb7.setBackground(Color.WHITE);

        ButtonGroup Adquotagroup = new ButtonGroup();
        Adquotagroup.add(jb6);
        Adquotagroup.add(jb7);

        l22 = new JLabel("Transportation Required * : ");
        l22.setBounds(600, 450, 300, 40);
        l22.setFont(new Font("arial", Font.BOLD, 18));

        jb8 = new JRadioButton("Yes");
        jb8.setBounds(840, 450, 100, 40);
        jb8.setFont(new Font("arial", Font.BOLD, 18));
        jb8.setBackground(Color.WHITE);

        jb9 = new JRadioButton("No");
        jb9.setBounds(970, 450, 100, 40);
        jb9.setFont(new Font("arial", Font.BOLD, 18));
        jb9.setBackground(Color.WHITE);

        ButtonGroup transgroup = new ButtonGroup();
        transgroup.add(jb8);
        transgroup.add(jb9);

        l23 = new JLabel("Hostel Required * : ");
        l23.setBounds(600, 500, 200, 40);
        l23.setFont(new Font("arial", Font.BOLD, 18));

        jb10 = new JRadioButton("Yes");
        jb10.setBounds(840, 500, 100, 40);
        jb10.setFont(new Font("arial", Font.BOLD, 18));
        jb10.setBackground(Color.WHITE);

        jb11 = new JRadioButton("No");
        jb11.setBounds(970, 500, 100, 40);
        jb11.setFont(new Font("arial", Font.BOLD, 18));
        jb11.setBackground(Color.WHITE);

        ButtonGroup hostelgroup = new ButtonGroup();
        hostelgroup.add(jb10);
        hostelgroup.add(jb11);

        try {
            Connection conn = ConnectionProvider.getConnnection();
            String q = "select * from Student_Details_1 where Roll_no ='"+ crollno.getSelectedItem() + "' ";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(q);
            while (rs.next())
            {
                tf1.setText(rs.getString("Admission_no"));
                tf2.setText(rs.getString("Enrollment_no"));
                tf3.setText(rs.getString("Roll_no"));
                tf4.setText(rs.getString("First_name"));
                tf5.setText(rs.getString("Last_name"));
                tf6.setText(rs.getString("Email_address"));
                tf7.setText(rs.getString("Contact_no"));
                ((JTextField) datechooser.getDateEditor().getUiComponent()).setText(rs.getString("Date_of_Birth"));
                tf8.setText(rs.getString("Aadhaar_no"));
                tf9.setText(rs.getString("Address"));
                tf10.setText(rs.getString("City"));
                tf11.setText(rs.getString("Pin_code"));
                tf12.setText(rs.getString("Branch"));
            }
        }catch (Exception ex2)
        {
            ex2.printStackTrace();
        }

        next = new JButton("Update");
        next.setBounds(970, 620, 130, 40);
        next.setFont(new Font("arial", Font.BOLD, 20));
        next.setForeground(Color.WHITE);
        next.setBackground(Color.BLACK);

        close = new JButton("Close");
        close.setBounds(840, 620, 130, 40);
        close.setFont(new Font("arial", Font.BOLD, 20));
        close.setForeground(Color.WHITE);
        close.setBackground(Color.BLACK);

        add(tittle); add(l1); add(l2); add(l3); add(l4);
        add(l5); add(l6); add(l7); add(l8); add(l9);
        add(l10); add(l11); add(l12); add(l13); add(l14);
        add(l15); add(l16); add(l17); add(l18); add(l19);
        add(l20); add(l21); add(l22); add(l23);

        add(tf1); add(tf2); add(tf3); add(tf4); add(tf5);
        add(datechooser); add(tf6); add(tf7); add(tf8);
        add(tf9); add(tf10); add(tf10); add(tf11);
        add(tf12);
        add(st); add(ct); add(rl); add(dep); add(course);

        add(jb1); add(jb2); add(jb3); add(jb4);
        add(jb5); add(jb6); add(jb7); add(jb8);
        add(jb9); add(jb10); add(jb11);
        add(next); add(close);
        add(sear); add(crollno);

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
                String Admissionno = "" + tf1.getText();
                String Enrolment = "" + tf2.getText();
                String Rollno = "" + tf3.getText();
                String FirstName = "" + tf4.getText();
                String LastName = "" + tf5.getText();
                String Email = "" + tf6.getText();
                String Contactno = "" + tf7.getText();
                String DOB = ((JTextField) datechooser.getDateEditor().getUiComponent()).getText();

                String Aadhaarno = "" + tf8.getText();
                String Address = "" + tf9.getText();
                String City = "" + tf10.getText();
                String Pincode = "" + tf11.getText();
                String Branch = "" + tf12.getText();

                if (Admissionno.equals("")) {
                    JOptionPane.showMessageDialog(null, "Please fill the  Admission Number");
                }else if (Enrolment.equals("")) {
                    JOptionPane.showMessageDialog(null, "Please fill the  Enrolment Number");
                } else if (Rollno.equals("")) {
                    JOptionPane.showMessageDialog(null, "Please fill the Roll Number");
                } else if (FirstName.equals("")) {
                    JOptionPane.showMessageDialog(null, "Please fill the First name field");
                }else if (LastName.equals("")) {
                    JOptionPane.showMessageDialog(null, "Please fill the Last name field");
                }else if (Email.equals("")) {
                    JOptionPane.showMessageDialog(null, "Please fill the Email Address");
                } else if (Contactno.equals("")) {
                    JOptionPane.showMessageDialog(null, "Please fill the Contact Number");
                } else if (DOB.equals("")) {
                    JOptionPane.showMessageDialog(null, "Please fill the Date of Birth field");
                } else if (Aadhaarno.equals("")) {
                    JOptionPane.showMessageDialog(null, "Please fill the Aadhaar Number");
                } else if (Address.equals("")) {
                    JOptionPane.showMessageDialog(null, "Please fill the Address field");
                } else if (City.equals("")) {
                    JOptionPane.showMessageDialog(null, "Please fill the City field");
                } else if (Pincode.equals("")) {
                    JOptionPane.showMessageDialog(null, "Please fill the Pin Code Number");
                } else if (Branch.equals("")) {
                    JOptionPane.showMessageDialog(null, "Please Select Any Branch");
                }
                try {
                    String driver = "com.mysql.cj.jdbc.Driver";
                    String url = "jdbc:mysql://localhost:3306/schoolarshipmanagementsystem";

                    String username = "root";
                    String password = "rna@2004";
                    Class.forName(driver);
                    Connection conn = DriverManager.getConnection(url, username, password);
//                    Connection conn = ConnectionProvider.getConnnection();
                    String q = "update Student_Details_1 set Admission_no = '" + Admissionno + "',Enrollment_no = '" + Enrolment + "', First_name = '" + FirstName + "',Last_name = '" + LastName + "',Email_address = '" + Email + "', Contact_no = '" + Contactno + "',Date_of_Birth = '" + DOB + "', Aadhaar_no = '" + Aadhaarno + "',Address = '" + Address + "', City = '" + City + "', Pin_code = '" + Pincode + "', Branch = '" + Branch + "' where Roll_no = '" + Rollno + "'";
                    Statement stmt = conn.createStatement();
                    stmt.executeUpdate(q);
                    System.out.println("Database connected..");
                    System.out.println("Your data has been updated..");

                    setVisible(false);
                    new A_07_Student_Update_2(Rollno).setVisible(true);
                    JOptionPane.showMessageDialog(null, "Student's Personal Details Updated Securely");

                } catch (Exception ex1) {
                    ex1.getStackTrace();
                }
            }catch(Exception ex2)
            {
                ex2.printStackTrace();
            }
        }
    }
    public static void main(String[] args) {
        new A_07_Student_Update_1();
    }
}