import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class A_04_AdminAuthority extends JFrame implements ActionListener
{
    JMenuBar mb = new JMenuBar();
    JMenu Home, add, remove, update, view, about, exit, vstudent, ustudent, gc, Check;
    JMenuItem nstudent, nuser, rstudent, vuser, ruser, uuser, logout, home, ab, stu1, stu2, stu3, st1, st2, st3, ss, check;
    JLabel runsug; JLabel proname; Timer time;
    A_04_AdminAuthority()
    {
        setSize(1366,768);
        setLayout(null);
        setVisible(true);
        setLocationRelativeTo(null);
        setTitle("Shobhit University Gangoh : Admin Working Portal");
        getContentPane().setBackground(Color.WHITE);

        Container c = getContentPane();
        JLabel il = new JLabel();
        il.setIcon(new ImageIcon("src/Images/Admin_User_Working.png"));
        Dimension dimension = il.getPreferredSize();
        il.setBounds(0,0, dimension.width, dimension.height);

        mb.setBackground(Color.BLACK);

        Home = new JMenu("Home");
        Home.setFont(new Font("arial",Font.BOLD,16));
        Home.setForeground(Color.WHITE);

        home = new JMenuItem("Home");
        home.setFont(new Font("arial",Font.BOLD,14));
        home.setBackground(Color.BLACK);
        home.setForeground(Color.WHITE);
        home.addActionListener(this);

        add = new JMenu("New Details");
        add.setFont(new Font("arial",Font.BOLD,16));
        add.setForeground(Color.WHITE);

        nstudent = new JMenuItem("New Student");
        nstudent.setFont(new Font("arial",Font.BOLD,14));
        nstudent.setBackground(Color.BLACK);
        nstudent.setForeground(Color.WHITE);
        nstudent.addActionListener(this);

        nuser = new JMenuItem("New User");
        nuser.setFont(new Font("arial",Font.BOLD,14));
        nuser.setBackground(Color.BLACK);
        nuser.setForeground(Color.WHITE);
        nuser.addActionListener(this);

        view = new JMenu("View Details");
        view.setFont(new Font("arial",Font.BOLD,16));
        view.setForeground(Color.WHITE);

        vstudent = new JMenu("View Student");
        vstudent.setFont(new Font("arial",Font.BOLD,14));
//        vstudent.setBackground(Color.BLACK);
//        vstudent.setForeground(Color.WHITE);
        vstudent.addActionListener(this);

        stu1 = new JMenuItem("Student's Personal Details");
        stu1.setFont(new Font("arial",Font.BOLD,14));
        stu1.setBackground(Color.BLACK);
        stu1.setForeground(Color.WHITE);
        stu1.addActionListener(this);

        stu2 = new JMenuItem("Student's Parents Details");
        stu2.setFont(new Font("arial",Font.BOLD,14));
        stu2.setBackground(Color.BLACK);
        stu2.setForeground(Color.WHITE);
        stu2.addActionListener(this);

        stu3 = new JMenuItem("Student's Educational Details");
        stu3.setFont(new Font("arial",Font.BOLD,14));
        stu3.setBackground(Color.BLACK);
        stu3.setForeground(Color.WHITE);
        stu3.addActionListener(this);

        vuser = new JMenuItem("View Users");
        vuser.setFont(new Font("arial",Font.BOLD,14));
        vuser.setBackground(Color.BLACK);
        vuser.setForeground(Color.WHITE);
        vuser.addActionListener(this);

        update = new JMenu("Update Details");
        update.setFont(new Font("arial",Font.BOLD,16));
        update.setForeground(Color.WHITE);

        ustudent = new JMenu("Update Student");
        ustudent.setFont(new Font("arial",Font.BOLD,14));
//        ustudent.setBackground(Color.BLACK);
//        ustudent.setForeground(Color.WHITE);
        ustudent.addActionListener(this);

        uuser = new JMenuItem("Update User");
        uuser.setFont(new Font("arial",Font.BOLD,14));
        uuser.setBackground(Color.BLACK);
        uuser.setForeground(Color.WHITE);
        uuser.addActionListener(this);

        st1 = new JMenuItem("Update student's Personal Details");
        st1.setFont(new Font("arial",Font.BOLD,14));
        st1.setBackground(Color.BLACK);
        st1.setForeground(Color.WHITE);
        st1.addActionListener(this);

        st2 = new JMenuItem("Update student's Parents Details");
        st2.setFont(new Font("arial",Font.BOLD,14));
        st2.setBackground(Color.BLACK);
        st2.setForeground(Color.WHITE);
        st2.addActionListener(this);

        st3 = new JMenuItem("Update student's Educational Details");
        st3.setFont(new Font("arial",Font.BOLD,14));
        st3.setBackground(Color.BLACK);
        st3.setForeground(Color.WHITE);
        st3.addActionListener(this);

        remove = new JMenu("Remove Details");
        remove.setFont(new Font("arial",Font.BOLD,16));
        remove.setForeground(Color.WHITE);

        rstudent = new JMenuItem("Remove Student");
        rstudent.setFont(new Font("arial",Font.BOLD,14));
        rstudent.setBackground(Color.BLACK);
        rstudent.setForeground(Color.WHITE);
        rstudent.addActionListener(this);

        ruser = new JMenuItem("Remove User");
        ruser.setFont(new Font("arial",Font.BOLD,14));
        ruser.setBackground(Color.BLACK);
        ruser.setForeground(Color.WHITE);
        ruser.addActionListener(this);

        gc = new JMenu("Generate Certificate");
        gc.setFont(new Font("arial",Font.BOLD,16));
        gc.setForeground(Color.WHITE);

        ss = new JMenuItem("Select Student");
        ss.setFont(new Font("arial",Font.BOLD,14));
        ss.setBackground(Color.BLACK);
        ss.setForeground(Color.WHITE);
        ss.addActionListener(this);

        Check = new JMenu("Check for Scholarships");
        Check.setFont(new Font("arial",Font.BOLD,16));
        Check.setForeground(Color.WHITE);

        check = new JMenuItem("Check for students Scholarships");
        check.setFont(new Font("arial",Font.BOLD,14));
        check.setBackground(Color.BLACK);
        check.setForeground(Color.WHITE);
        check.addActionListener(this);

        about = new JMenu("About");
        about.setFont(new Font("arial",Font.BOLD,16));
        about.setForeground(Color.WHITE);

        ab = new JMenuItem("About");
        ab.setFont(new Font("arial",Font.BOLD,14));
        ab.setBackground(Color.BLACK);
        ab.setForeground(Color.WHITE);
        ab.addActionListener(this);

        exit = new JMenu("Exit");
        exit.setFont(new Font("arial",Font.BOLD,16));
        exit.setForeground(Color.WHITE);

        logout = new JMenuItem("Log out");
        logout.setFont(new Font("arial",Font.BOLD,16));
        logout.setBackground(Color.BLACK);
        logout.setForeground(Color.WHITE);
        logout.addActionListener(this);

        runsug = new JLabel("Shobhit University Gangoh");
        runsug.setFont(new Font("arial",Font.BOLD,50));
        runsug.setForeground(Color.ORANGE);

        proname = new JLabel("        ScholasticLink        ");
        proname.setFont(new Font("arial",Font.BOLD,50));
        proname.setForeground(Color.BLUE);

        time = new Timer(10, new ActionListener() {
            int x = 100;
            int dx = 1;
            public void actionPerformed(ActionEvent e) {
                x += dx;

                runsug.setBounds(x, 100, 700, 70);
                proname.setBounds(x, 180, 700, 70);
                if (x + runsug.getWidth() >= getContentPane().getWidth()) {
                    dx = -1;
                }if (x + proname.getWidth() >= getContentPane().getWidth()) {
                    dx = -1;
                }
                if (x <= 0) {
                    dx = 1;
                }
            }
        });
        time.start();



        add(il);
        setJMenuBar(mb); il.add(runsug); il.add(proname);
        mb.add(Home); mb.add(add); mb.add(view); mb.add(update);
        mb.add(remove); mb.add(gc); mb.add(Check); mb.add(about); mb.add(exit);

        add.add(nuser); view.add(vuser); update.add(uuser); remove.add(ruser);
        add.add(nstudent); view.add(vstudent); update.add(ustudent); remove.add(rstudent); vstudent.add(stu1); vstudent.add(stu2); vstudent.add(stu3);
        ustudent.add(st1); ustudent.add(st2); ustudent.add(st3);
        exit.add(logout); Home.add(home); about.add(ab); gc.add(ss); Check.add(check);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String msg = e.getActionCommand();
        if (msg.equals("Log out")) {
            setVisible(false);
        } else if (msg.equals("Home")) {
            JOptionPane.showMessageDialog(null, "You are already at home page \n Thankyou!");
        } else if (msg.equals("New Student")) {
            new A_05_Student_Details_1();
        } else if(msg.equals("New User")) {
            new A_03_UserSignUp();
        } else if (msg.equals("Student's Personal Details")) {
            new A_06_Students_Personal_Details();
        }else if (msg.equals("Student's Parents Details")) {
            new A_06_Students_Parents_Details();
        }else if (msg.equals("Student's Educational Details")) {
            new A_06_Students_Educational_Details();
        } else if(msg.equals("View Users")) {
            new A_06_Users_Details();
        }else if (msg.equals("Update student's Personal Details")) {
            new A_07_Student_Update_1();
        }else if (msg.equals("Update student's Parents Details")) {
            new A_07_Student_Update_2("");
        }else if (msg.equals("Update student's Educational Details")) {
            new A_07_Student_Update_3("");
        } else if(msg.equals("Update User")) {
            new A_07_User_Update();
        }else if (msg.equals("Select Student")) {
            new A_09_Generate_Certificate("");
        } else if (msg.equals("Check for students Scholarships")) {
            new A_10_Check_for_Scholarships();
        } else if (msg.equals("About")) {
            new A_11_About_Project();
        }else if (msg.equals("Remove Student")) {
            new A_08_Student_Delete();
        }else if (msg.equals("Remove User")) {
            new A_08_User_Delete();
        }
    }
    public static void main(String[] args) {
        new A_04_AdminAuthority();
    }

}
