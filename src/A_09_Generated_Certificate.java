import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
public class A_09_Generated_Certificate extends JFrame implements ActionListener
{
    JLabel l1; JLabel l2; JLabel l3; JLabel l4; JLabel l5; JLabel il;
    JButton print; JButton not; String crollno;
    PrinterJob job;
    A_09_Generated_Certificate(String crollno)
    {
        this.crollno = crollno;
        setSize(1360,760);
        setLayout(null);
        setLocationRelativeTo(null);
        setTitle("Shobhit University Gangoh : Scholarship Certificate");
        getContentPane().setBackground(Color.WHITE);
        setUndecorated(true);
        setVisible(true);

        Container c = getContentPane();
        JLabel il = new JLabel();
        il.setIcon(new ImageIcon("src/Images/Certificate.png"));
        Dimension dimension = il.getPreferredSize();
        il.setBounds(0,0, dimension.width, dimension.height);

        l1 = new JLabel("");
        l1.setBounds(700,425,150,30);
        l1.setFont(new Font("arial",Font.BOLD,22));

        l2 = new JLabel("");
        l2.setBounds(850,425,200,30);
        l2.setFont(new Font("arial",Font.BOLD,22));

        l3 = new JLabel("");
        l3.setBounds(200,460,290,30);
        l3.setFont(new Font("arial",Font.BOLD,22));

        l4 = new JLabel("");
        l4.setBounds(590,460,250,30);
        l4.setFont(new Font("arial",Font.BOLD,22));

        l5 = new JLabel("");
        l5.setBounds(940,460,280,30);
        l5.setFont(new Font("arial",Font.BOLD,22));

        try {
            Connection conn = ConnectionProvider.getConnnection();
            String q = "select * from Student_Details_1 where Roll_no ='"+ crollno + "' ";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(q);
            while (rs.next())
            {
                l1.setText(rs.getString("First_name"));
                l2.setText(rs.getString("Last_name"));
                l4.setText(rs.getString("Course"));
                l5.setText(rs.getString("Branch"));
            }
        }catch (Exception ex2)
        {
            ex2.printStackTrace();
        }
        try {
            Connection conn = ConnectionProvider.getConnnection();
            String q1 = "select * from Student_Details_2 where Roll_no ='"+crollno+"' ";
            Statement stmt1 = conn.createStatement();
            ResultSet rs1 = stmt1.executeQuery(q1);
            while (rs1.next())
            {
                l3.setText(rs1.getString("Father_Name"));
            }
        }catch (Exception ex2)
        {
            ex2.printStackTrace();
        }

        print = new JButton("Print");
        print.setBounds(1240,650,110,30);
        print.setFont(new Font("arial",Font.BOLD,18));
        print.setBackground(Color.WHITE);
        print.setForeground(Color.BLACK);
        print.addActionListener(this);

        not = new JButton("Not Now");
        not.setBounds(1240,690,110,30);
        not.setFont(new Font("arial",Font.BOLD,18));
        not.setBackground(Color.WHITE);
        not.setForeground(Color.BLACK);
        not.addActionListener(this);

        add(il); il.add(l1); il.add(l2);
        il.add(l3); il.add(l4); il.add(l5);
        il.add(print); il.add(not);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == print)
        {
            try
            {
                job = PrinterJob.getPrinterJob();
                job.setJobName("Print Data");

                job.setPrintable(new Printable(){
                    public int print(Graphics pg, PageFormat pf, int pageNum){
                        pf.setOrientation(PageFormat.LANDSCAPE);
                        if(pageNum > 0){
                            return Printable.NO_SUCH_PAGE;
                        }

                        Graphics2D g2 = (Graphics2D)pg;
                        g2.translate(pf.getImageableX(), pf.getImageableY());
                        g2.scale(0.50,0.50);
                        il.print(g2);
                        return Printable.PAGE_EXISTS;
                    }
                });
                boolean ok = job.printDialog();
                if(ok){
                    try{
                        job.print();
                    }
                    catch (PrinterException ex){
                        ex.printStackTrace();
                    }
                }
            }catch (Exception ex)
            {
                ex.printStackTrace();
            }
        }
        if (e.getSource() == not)
        {
            setVisible(false);
        }
    }
    public static void main(String[] args) {
        new A_09_Generated_Certificate("");
    }
}