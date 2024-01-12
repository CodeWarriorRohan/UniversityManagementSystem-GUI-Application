import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class A_11_About extends JFrame implements ActionListener
{
    JButton back;
    A_11_About()
    {
        setSize(1070,600);
        setLayout(null);
        setVisible(true);
        setLocationRelativeTo(null);
        setTitle("Shobhit University Gangoh : About");
        getContentPane().setBackground(Color.WHITE);

        Container c = getContentPane();
        JLabel il = new JLabel();
//        il.setIcon(new ImageIcon("C:\\Users\\intel\\Downloads\\Mimage5.jpeg"));
        il.setIcon(new ImageIcon("src/Images/MyImage.jpeg"));
        Dimension dimension = il.getPreferredSize();
        il.setBounds(10,0, dimension.width, dimension.height);

        JLabel l1 = new JLabel();
        l1 = new JLabel("{ Scholar Sparks }");
        l1.setBounds(500, 00, 350, 40);
        l1.setFont(new Font("helvetica",Font.CENTER_BASELINE,35));
        l1.setForeground(Color.BLUE);

        JLabel l2 = new JLabel();
        l2 = new JLabel("Scholarship");
        l2.setBounds(430, 50, 250, 40);
        l2.setFont(new Font("arial",Font.CENTER_BASELINE,35));
        l2.setForeground(Color.ORANGE);

        JLabel l3 = new JLabel();
        l3 = new JLabel("Management");
        l3.setBounds(650, 50, 250, 40);
        l3.setFont(new Font("arial",Font.CENTER_BASELINE,35));
        l3.setForeground(Color.ORANGE);

        JLabel l4 = new JLabel();
        l4 = new JLabel("System");
        l4.setBounds(580, 100, 250, 40);
        l4.setFont(new Font("arial",Font.CENTER_BASELINE,35));
        l4.setForeground(Color.ORANGE);

        JLabel l5 = new JLabel();
        l5 = new JLabel("Developed by : Rohan Sinodhiya");
        l5.setBounds(380, 200, 550, 40);
        l5.setFont(new Font("arial",Font.CENTER_BASELINE,35));
        l5.setForeground(Color.RED);

        JLabel l6 = new JLabel();
        l6 = new JLabel("Roll Number : 21014168029");
        l6.setBounds(380, 300, 400, 40);
        l6.setFont(new Font("arial",Font.CENTER_BASELINE,30));
        l6.setForeground(Color.BLUE);

        JLabel l7 = new JLabel();
        l7 = new JLabel("Contact Number : 8439880085");
        l7.setBounds(380, 350, 450, 40);
        l7.setFont(new Font("arial",Font.CENTER_BASELINE,30));
        l7.setForeground(Color.BLUE);

        JLabel l8 = new JLabel();
        l8 = new JLabel("Course : B. Tech (Computer Science) 2nd Year");
        l8.setBounds(380, 400, 700, 40);
        l8.setFont(new Font("arial",Font.CENTER_BASELINE,30));
        l8.setForeground(Color.BLUE);

        JLabel l9 = new JLabel();
        l9 = new JLabel("Batch : 2021 - 2025");
        l9.setBounds(380, 450, 400, 40);
        l9.setFont(new Font("arial",Font.CENTER_BASELINE,30));
        l9.setForeground(Color.BLUE);

        back = new JButton("Back");
        back.setBounds(10,500,130,40);
        back.setFont(new Font("arial",Font.BOLD,20));
        back.setForeground(Color.WHITE);
        back.setBackground(Color.BLACK);

        add(il); add(l1);
        add(l2); add(l3);
        add(l4); add(l5);
        add(l6); add(l7);
        add(l8); add(l9);
        add(back);
        back.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == back)
        {
            setVisible(false);
            new A_11_About_Project().setVisible(true);
        }
    }

    public static void main(String[] args) {
        new A_11_About();
    }
}
