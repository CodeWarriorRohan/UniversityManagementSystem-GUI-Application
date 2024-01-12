import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import net.proteanit.sql.DbUtils;
public class A_09_Generate_Certificate extends JFrame implements ActionListener
{
    Choice crollno; JTable table;
    JButton generate; JButton search;
    String Rollno;
    A_09_Generate_Certificate(String Rollno)
    {
        this.Rollno = Rollno;
        setSize(1350, 900);
        setLayout(null);
        setVisible(true);
        setLocationRelativeTo(null);
        setTitle("Shobhit University Gangoh : Certificate of Scholarship");
        getContentPane().setBackground(Color.WHITE);

        JLabel sear = new JLabel("Search by Roll no. :");
        sear.setBounds(20, 20, 200, 40);
        sear.setFont(new Font("arial", Font.BOLD, 18));

        crollno = new Choice();
        crollno.setBounds(220,20,200,40);
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

        search = new JButton("Search");
        search.setBounds(430,20,100,28);
        search.setFont(new Font("arial",Font.BOLD,18));
        search.setBackground(Color.WHITE);
        search.setForeground(Color.BLUE);
        search.addActionListener(this);

        generate = new JButton("Generate Certificate");
        generate.setBounds(1100,20,220,28);
        generate.setFont(new Font("arial",Font.BOLD,18));
        generate.setBackground(Color.WHITE);
        generate.setForeground(Color.BLUE);
        generate.addActionListener(this);

        table = new JTable();
        try {
            Connection conn = ConnectionProvider.getConnnection();
            String q1 = "select * from Student_Details_1";
            Statement stmt1 = conn.createStatement();
            ResultSet rs1 = stmt1.executeQuery(q1);
            table.setModel(DbUtils.resultSetToTableModel(rs1));
        }catch (Exception ex)
        {
            ex.printStackTrace();
        }
        JScrollPane jsp = new JScrollPane(table);
        jsp.setBounds(0,100,1350, 800);

        add(sear); add(search); add(crollno);
        add(jsp); add(generate);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == search)
        {
            String q2 = "select * from Student_Details_1 where Roll_no = '"+crollno.getSelectedItem()+"'";
            try {
                Connection conn = ConnectionProvider.getConnnection();
                Statement stmt2 = conn.createStatement();
                ResultSet rs2 = stmt2.executeQuery(q2);
                table.setModel(DbUtils.resultSetToTableModel(rs2));
            }catch (Exception ex)
            {
                ex.printStackTrace();
            }
        }

        if (e.getSource() == generate)
        {
            try {
                Connection conn = ConnectionProvider.getConnnection();
                JOptionPane.showMessageDialog(null, "Your Scholarship Certificate Generated (View Certificate)");
                new A_09_Generated_Certificate(Rollno).setVisible(true);
            }catch (Exception ex2)
            {
                ex2.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        new A_09_Generate_Certificate("");
    }
}