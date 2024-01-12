import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import net.proteanit.sql.DbUtils;

public class A_06_Students_Personal_Details extends JFrame implements ActionListener
{
    Choice crollno; JTable table;
    JButton print; JButton search; JButton excel;
    A_06_Students_Personal_Details()
    {
        setSize(1350, 900);
        setLayout(null);
        setVisible(true);
        setLocationRelativeTo(null);
        setTitle("Shobhit University Gangoh : All Student's Personal Details");
        getContentPane().setBackground(Color.WHITE);

        Container c = getContentPane();
        JLabel il1 = new JLabel();
        il1.setIcon(new ImageIcon("src/Images/Search.jpg"));
        Dimension size = il1.getPreferredSize();
        il1.setBounds(540,0,size.width, size.height);

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

        print = new JButton("Print");
        print.setBounds(1220,20,100,28);
        print.setFont(new Font("arial",Font.BOLD,18));
        print.setBackground(Color.WHITE);
        print.setForeground(Color.BLUE);
        print.addActionListener(this);

        Container c1 = getContentPane();
        JLabel il2 = new JLabel();
        il2.setIcon(new ImageIcon("src/Images/print.jpg"));
        Dimension size1 = il2.getPreferredSize();
        il2.setBounds(1150,0,size.width, size.height);

        excel = new JButton("Export Excel");
        excel.setBounds(990,20,150,28);
        excel.setFont(new Font("arial",Font.BOLD,18));
        excel.setBackground(Color.WHITE);
        excel.setForeground(Color.BLUE);
        excel.addActionListener(this);

        table = new JTable();
        try {

            Connection conn = ConnectionProvider.getConnnection();
            String q = "select * from Student_Details_1";

            Statement stmt = conn.createStatement();
            ResultSet rs1 = stmt.executeQuery(q);
            table.setModel(DbUtils.resultSetToTableModel(rs1));

        }catch (Exception ex)
        {
            ex.printStackTrace();
        }

        JScrollPane jsp = new JScrollPane(table);
        jsp.setBounds(0,100,1350, 800);

        add(sear); add(search); add(crollno); add(il1); add(il2);
        add(jsp); add(print); add(excel);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == search)
        {
            String q = "select * from Student_Details_1 where Roll_no = '"+crollno.getSelectedItem()+"'";
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

        if (e.getSource() == print)
        {
            try {
                table.print();
            }catch (Exception ex)
            {
                ex.printStackTrace();
            }
        }
        if (e.getSource() == excel)
        {
            try
            {
//              Choose location for saving Excel files
                JFileChooser excelfile = new JFileChooser();
//              Onliny filter files with these extensions "xls","xlsx","xlsm".
                FileNameExtensionFilter fnex = new FileNameExtensionFilter("Excel Files","xls","xlsx","xlsm");
                excelfile.showSaveDialog(null);


            }catch (Exception ex)
            {
                ex.printStackTrace();
            }
        }
    }
    public static void main(String[] args) {
        new A_06_Students_Personal_Details();
    }
}
