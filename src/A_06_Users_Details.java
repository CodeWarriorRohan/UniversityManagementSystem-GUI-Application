import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import net.proteanit.sql.DbUtils;

public class A_06_Users_Details extends JFrame implements ActionListener
{
    Choice cid; JTable table;
    JButton print; JButton search;
    A_06_Users_Details()
    {
        setSize(1150, 900);
        setLayout(null);
        setVisible(true);
        setLocationRelativeTo(null);
        setTitle("Shobhit University Gangoh : All Users Details");
        getContentPane().setBackground(Color.WHITE);

        JLabel sear = new JLabel("Search by User ID :");
        sear.setBounds(20, 20, 200, 40);
        sear.setFont(new Font("arial", Font.BOLD, 18));

        cid = new Choice();
        cid.setBounds(220,20,200,40);
        cid.setFont(new Font("arial",Font.BOLD,18));
        cid.setBackground(Color.WHITE);

        try {
            Connection conn = ConnectionProvider.getConnnection();
            String q = "select * from UserSignUp";

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(q);
            while (rs.next())
            {
                cid.add(rs.getString("User_ID"));
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

        print = new JButton("Print");
        print.setBounds(1020,20,100,28);
        print.setFont(new Font("arial",Font.BOLD,18));
        print.setBackground(Color.WHITE);
        print.setForeground(Color.BLUE);
        print.addActionListener(this);

        table = new JTable();

        try {

            Connection conn = ConnectionProvider.getConnnection();
            String q = "select * from UserSignUp";

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(q);
            table.setModel(DbUtils.resultSetToTableModel(rs));

        }catch (Exception ex)
        {
            ex.printStackTrace();
        }

        JScrollPane jsp = new JScrollPane(table);
        jsp.setBounds(0,100,1150, 800);

        add(sear);
        add(search);
        add(cid);
        add(jsp);
        add(print);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == print)
        {
            try {
                table.print();

            }catch (Exception ex)
            {
                ex.printStackTrace();
            }
        }
        if (e.getSource() == search)
        {
            String q = "select * from UserSignUp where User_ID = '"+cid.getSelectedItem()+"'";
            try {

                Connection conn = ConnectionProvider.getConnnection();

                Statement stmt = conn.createStatement();
                ResultSet rs1 = stmt.executeQuery(q);
                table.setModel(DbUtils.resultSetToTableModel(rs1));

            }catch (Exception ex)
            {
                ex.printStackTrace();
            }

        }
    }

    public static void main(String[] args) {
        new A_06_Users_Details();
    }
}

