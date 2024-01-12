import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
public class A_07_Student_Update_3 extends JFrame implements ActionListener {
    JLabel lh; JLabel l1; JLabel l2; JLabel l3; JLabel l4; JLabel li; JLabel l5;
    JLabel l6; JLabel l7; JLabel l8; JLabel l9; JLabel ld; JLabel l10; JLabel l11;
    JLabel l12; JLabel lgp; JLabel l13; JLabel l14; JLabel l15;
    JTextField tf1; JTextField tf2; JComboBox tenpy; JTextField tf4;
    JTextField tf5; JTextField tf6; JTextField tf7; JTextField tf8;
    JComboBox twlpy; JComboBox j12s; JComboBox jdip; JComboBox dpy;
    JComboBox gpy; JComboBox course; JComboBox un; JButton submit; JButton close;Choice crollno;
    String Rollno; JTextField tf3;
    A_07_Student_Update_3(String Rollno) {
        this.Rollno = Rollno;
        setSize(1220, 900);
        setLayout(null);
        setVisible(true);
        setLocationRelativeTo(null);
        setTitle("Shobhit University Gangoh : Update Student's Educational Details");
        getContentPane().setBackground(Color.WHITE);

        JLabel sear = new JLabel("Search by Roll no. :");
        sear.setBounds(810, 20, 170, 40);
        sear.setFont(new Font("arial", Font.BOLD, 18));
        sear.setForeground(Color.BLUE);

        crollno = new Choice();
        crollno.setBounds(1000,20,200,40);
        crollno.setFont(new Font("arial",Font.BOLD,18));
        crollno.setBackground(Color.WHITE);

        try {
            Connection conn = ConnectionProvider.getConnnection();
            String q = "select * from Student_Details_3";

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
                    String q = "select * from Student_Details_3 where Roll_no ='"+ crollno.getSelectedItem() + "' ";
                    Statement stmt = conn.createStatement();
                    ResultSet rs = stmt.executeQuery(q);
                    while (rs.next())
                    {
                        tf1.setText(rs.getString("10th_Obtained_Marks"));
                        tf2.setText(rs.getString("10th_Board"));
                        tf4.setText(rs.getString("12th_Obtained_Marks"));
                        tf5.setText(rs.getString("12th_Board"));
                        tf6.setText(rs.getString("Diploma_Branch"));
                        tf7.setText(rs.getString("Diploma_Obtained_Marks"));
                        tf8.setText(rs.getString("Graduation_Obtained_Marks"));
                    }
                }catch (Exception ex2)
                {
                    ex2.printStackTrace();
                }
            }
        });

        JLabel tittle = new JLabel("Update Student's Educational Details");
        tittle.setBounds(150, 20, 550, 40);
        tittle.setFont(new Font("arial", Font.BOLD, 30));

        lh = new JLabel("* High School Details");
        lh.setBounds(30, 50, 500, 100);
        lh.setFont(new Font("arial", Font.BOLD, 25));

        l1 = new JLabel("10th Obtained Marks (%) * : ");
        l1.setBounds(50, 130, 250, 40);
        l1.setFont(new Font("arial", Font.BOLD, 18));

        tf1 = new JTextField();
        tf1.setBounds(300, 130, 300, 40);
        tf1.setFont(new Font("arial", Font.BOLD, 18));

        l2 = new JLabel("10th Passing Year * : ");
        l2.setBounds(50, 180, 300, 40);
        l2.setFont(new Font("arial", Font.BOLD, 18));

        Integer year[] = {2023, 2022, 2021, 2020, 2019, 2018, 2017, 2016, 2015, 2014, 2013, 2012, 2011, 2010, 2009, 2008, 2007,
                2006, 2005, 2004, 2003, 2002, 2001, 2000, 1999, 1998, 1997, 1996, 1995, 1994, 1993, 1992, 1991, 1990,
                1989, 1988, 1987, 1986, 1985, 1984, 1983, 1982, 1981, 1980, 1979, 1978, 1977, 1976, 1975, 1974, 1973,
                1972, 1971, 1970, 1969, 1968, 1967, 1966, 1965, 1964, 1963, 1962, 1961, 1960, 1959, 1958, 1957, 1956,
                1955, 1954, 1953, 1952, 19591, 1950,};

        tenpy = new JComboBox<>(year);
        tenpy.setBounds(300, 180, 300, 40);
        tenpy.setFont(new Font("arial", Font.BOLD, 18));
        tenpy.setBackground(Color.WHITE);

        l3 = new JLabel("10th Board * : ");
        l3.setBounds(50, 230, 250, 40);
        l3.setFont(new Font("arial", Font.BOLD, 18));

        tf2 = new JTextField();
        tf2.setBounds(300, 230, 300, 40);
        tf2.setFont(new Font("arial", Font.BOLD, 18));

        li = new JLabel("* Intermediate Details");
        li.setBounds(30, 280, 500, 100);
        li.setFont(new Font("arial", Font.BOLD, 25));

        l4 = new JLabel("12th Obtained Marks (%) * : ");
        l4.setBounds(50, 360, 250, 40);
        l4.setFont(new Font("arial", Font.BOLD, 18));

        tf4 = new JTextField();
        tf4.setBounds(300, 360, 300, 40);
        tf4.setFont(new Font("arial", Font.BOLD, 18));

        l5 = new JLabel("12th Passing Year * : ");
        l5.setBounds(50, 410, 250, 40);
        l5.setFont(new Font("arial", Font.BOLD, 18));

        Integer tyear[] = {2023, 2022, 2021, 2020, 2019, 2018, 2017, 2016, 2015, 2014, 2013, 2012, 2011, 2010, 2009, 2008, 2007,
                2006, 2005, 2004, 2003, 2002, 2001, 2000, 1999, 1998, 1997, 1996, 1995, 1994, 1993, 1992, 1991, 1990,
                1989, 1988, 1987, 1986, 1985, 1984, 1983, 1982, 1981, 1980, 1979, 1978, 1977, 1976, 1975, 1974, 1973,
                1972, 1971, 1970, 1969, 1968, 1967, 1966, 1965, 1964, 1963, 1962, 1961, 1960, 1959, 1958, 1957, 1956,
                1955, 1954, 1953, 1952, 19591, 1950,};

        twlpy = new JComboBox<>(tyear);
        twlpy.setBounds(300, 410, 300, 40);
        twlpy.setFont(new Font("arial", Font.BOLD, 18));
        twlpy.setBackground(Color.WHITE);

        l6 = new JLabel("12th Board * : ");
        l6.setBounds(50, 460, 300, 40);
        l6.setFont(new Font("arial", Font.BOLD, 18));

        tf5 = new JTextField();
        tf5.setBounds(300, 460, 300, 40);
        tf5.setFont(new Font("arial", Font.BOLD, 18));

        l7 = new JLabel("12th Stream * :");
        l7.setBounds(50, 510, 300, 40);
        l7.setFont(new Font("arial", Font.BOLD, 18));

        String tstream[] = {"PCM", "PCB", "Commerce", "Arts", "Agriculture"};
        j12s = new JComboBox<>(tstream);

        j12s = new JComboBox<>(tstream);
        j12s.setBounds(300, 510, 300, 40);
        j12s.setFont(new Font("arial", Font.BOLD, 18));
        j12s.setBackground(Color.WHITE);

        ld = new JLabel("* Diploma Details");
        ld.setBounds(610, 50, 400, 100);
        ld.setFont(new Font("arial", Font.BOLD, 25));

        l8 = new JLabel("Diploma * : ");
        l8.setBounds(620, 130, 150, 40);
        l8.setFont(new Font("arial", Font.BOLD, 18));

        String diploma[] = {"Polytechnic", "D.Pharma.", "B.Pharma", "M.Pharma", "D.in Yoga", "Others"};
        jdip = new JComboBox<>(diploma);

        jdip = new JComboBox<>(diploma);
        jdip.setBounds(900, 130, 300, 40);
        jdip.setFont(new Font("arial", Font.BOLD, 18));
        jdip.setBackground(Color.WHITE);

        l9 = new JLabel("Branch * : ");
        l9.setBounds(620, 180, 150, 40);
        l9.setFont(new Font("arial", Font.BOLD, 18));

        tf6 = new JTextField();
        tf6.setBounds(900, 180, 300, 40);
        tf6.setFont(new Font("arial", Font.BOLD, 18));

        l10 = new JLabel("Diploma Obtained Marks (%) * :");
        l10.setBounds(620, 230, 300, 40);
        l10.setFont(new Font("arial", Font.BOLD, 18));

        tf7 = new JTextField();
        tf7.setBounds(900, 230, 300, 40);
        tf7.setFont(new Font("arial", Font.BOLD, 18));

        l11 = new JLabel("Diploma Passing Year * : ");
        l11.setBounds(620, 280, 300, 40);
        l11.setFont(new Font("arial", Font.BOLD, 18));

        Integer dyear[] = {2023, 2022, 2021, 2020, 2019, 2018, 2017, 2016, 2015, 2014, 2013, 2012, 2011, 2010, 2009, 2008, 2007,
                2006, 2005, 2004, 2003, 2002, 2001, 2000, 1999, 1998, 1997, 1996, 1995, 1994, 1993, 1992, 1991, 1990,
                1989, 1988, 1987, 1986, 1985, 1984, 1983, 1982, 1981, 1980, 1979, 1978, 1977, 1976, 1975, 1974, 1973,
                1972, 1971, 1970, 1969, 1968, 1967, 1966, 1965, 1964, 1963, 1962, 1961, 1960, 1959, 1958, 1957, 1956,
                1955, 1954, 1953, 1952, 19591, 1950,};

        dpy = new JComboBox<>(dyear);
        dpy.setBounds(900, 280, 300, 40);
        dpy.setFont(new Font("arial", Font.BOLD, 18));
        dpy.setBackground(Color.WHITE);

        lgp = new JLabel("* Graduation  Details");
        lgp.setBounds(610, 330, 400, 100);
        lgp.setFont(new Font("arial", Font.BOLD, 25));

        l12 = new JLabel("Graduation * :");
        l12.setBounds(620, 410, 250, 40);
        l12.setFont(new Font("arial", Font.BOLD, 18));

        String cor[] = {"B.Tech", "B.Sc", "B.Com", "B.A", "B.A.B.L", "B.B.A", "B.C.A", "Polytechnic", "L.L.B", "B.A.M.S", "B.N.Y.S", "D.Pharm.", "B.Pharm."};
        course = new JComboBox<>(cor);

        course = new JComboBox<>(cor);
        course.setBounds(900, 410, 300, 40);
        course.setFont(new Font("arial", Font.BOLD, 18));
        course.setBackground(Color.WHITE);

        l13 = new JLabel("Graduation University * : ");
        l13.setBounds(620, 460, 300, 40);
        l13.setFont(new Font("arial", Font.BOLD, 18));

        String university[] = {"1.Shobhit University Gangoh", "7.Vellore Institute of Technology Vellore",
                "8.SRM Institute of Science and Technology	Chennai",
                "9.Manipal Academy of Higher Education	Manipal",
                "10.Narsee Monjee Institute of Management and Higher Studies Mumbai",
                "13.Amrita Vishwa Vidyapeetham	Coimbatore",
                "15.International Institute of Information Technology, Hyderabad Hyderabad",
                "16.Lovely Professional University	Phagwara",
                "17.Amity University Noida",
                "19.Birla Institute of Technology and Science Pilani",
                "26.Chandigarh University Mohali",
                "29.Christ University Bangalore",
                "41.Chitkara University Punjab",
                "51.Gandhi Institute of Technology and Management Visakhapatnam",
                "53.Jain University	Bangalore",
                "61.University of Petroleum and Energy Studies	Dehradun",
                "62.O.P. Jindal Global University	Sonipat",
                "63.Thapar Institute of Engineering and Technology	Patiala",
                "64.Chennai Mathematical Institute	Chennai",
                "65.SASTRA University Thanjavur",
                "66.Azim Premji University	Bangalore",
                "71.Shiv Nadar University	Dadri",
                "73.University of Engineering and Management, Kolkata",
                "74.Ashoka University Sonipat",
                "83.International Institute of Information Technology Bangalore	Bangalore",
                "84.KIIT University	Bhubaneswar",
                "90.Indira Gandhi Institute of Development Research	Mumbai",
                "96.BML Munjal University	Gurgaon",
                "10.Sharda University	Greater Noid",
                "10.Dr. Vishwanath Karad MIT World Peace University	Pune",
                "11.K L University	Vaddeswaram",
                "12.ITM University Raipur	Raipur",
                "12.Nirma University	Ahmedabad",
                "12.Bennett University	Greater Noida",
                "13.CEPT University	Ahmedabad",
                "13.Vel Tech Rangarajan Dr. Sagunthala R&D Institute of Science and Technology	Chennai",
                "13.Symbiosis International University	Pune",
                "14.Dhirubhai Ambani Institute of Information and Communication Technology	Gandhinagar",
                "15.Sathyabama Institute of Science and Technology	Chennai",
                "15.Karunya Institute of Technology and Sciences	Coimbatore",
                "155.Ahmedabad University	Ahmedabad",
                "156.Sri Ramachandra Institute of Higher Education and Research	Chennai",
                "162.Alliance University	Bangalore",
                "164.NITTE University	Mangalore",
                "165.Hindustan Institute of Technology and Science	Chennai",
                "172.Graphic Era University	Dehradun",
                "173.Flame University	Pune",
                "176.Parul University	Waghodia",
                "181.PES University	Bangalore",
                "185.Bharati Vidyapeeth Deemed University	Pune",
                "194.KLE Technological University	Hubli",
                "203.Shoolini University of Biotechnology and Management Sciences	Solan",
                "210.Invertis University	Bareilly",
                "213.Galgotias University	Noida",
                "216.Padmashree Dr. D.Y. Patil Vidyapith	Navi Mumbai",
                "218.Sikkim Manipal University	Gangtok",
                "220.ITM University Gwalior	Gwalior",
                "221.Banasthali Vidyapith	Banasthali ...",
                "224.TERI School of Advanced Studies	New Delhi",
                "234.Jaypee Institute of Information Technology	Noida",
                "238.REVA University	Bangalore",
                "241.Pandit Deendayal Petroleum University	Gandhinagar",
                "242.The LNM Institute of Information Technology	Jaipur",
                "244.Siksha 'O' Anusandhan	Bhubaneswar",
                "249.Assam Don Bosco University	Guwahati",
                "251.DIT University	Dehradun",
                "252.Motherhood University	Bhagwanpur",
                "257.NIIT University	Neemrana",
                "263.Vels University	Chennai",
                "265.Ganpat University	Mehsana",
                "266.The IIS University	Jaipur",
                "268.Vinayaka Mission's Research Foundation	Salem",
                "269.Jaipur National University	Jaipur",
                "272.Jaypee University of Information Technology	Waknaghat",
                "273.XIM University	Harirajpur",
                "274.The Northcap University	Gurgaon",
                "277.Dr. D.Y. Patil Vidyapeeth Pune",
                "280.K.R. Mangalam University Gurgaon",
                "282.JSS Academy of Higher Education and Research Mysore",
                "284.Ramaiah University of Applied Sciences	Bangalore",
                "287.Yenepoya University	Mangalore",
                "289.Brainware University Barasat",
                "294.Maharishi Markandeshwar University, Mullana	Mullana",
                "296.Bharath Institute of Higher Education and Research	Chennai",
                "300.Assam Down Town University	Guwahati",
                "305.Sri Sathya Sai Institute of Higher Learning	Anantapur",
                "310.Rama University	Kanpur",
                "321.Saveetha Institute of Medical and Technical Sciences	Chennai",
                "328.Integral University	Lucknow",
                "330.Presidency University	Bangalore",
                "334.B.S. Abdur Rahman Crescent Institute of Science and Technology	Chennai",
                "338.Pravara Institute of Medical Sciences	Loni",
                "343.Mody University of Science and Technology	Lakshmangarh",
                "348.Centurion University of Technology and Management	Bhubaneswar",
                "350.Madhav University	Pindwara",
                "354.VIT Bhopal University	Bhopal",
                "355.Teerthanker Mahaveer University	Moradabad",
                "359.Swami Vivekanand Subharti University	Meerut",
                "364.MIT Art Design and Technology University	Pune",
                "366.Apeejay Stya University	Gurgaon",
                "367.SRM University Haryana	Sonipat",
                "368.CMR University	Bangalore",
                "371.JK Lakshmipat University	Jaipur",
                "372.GD Goenka University	Gurgaon",
                "373.Noida International University	Greater Noida",
                "376.Kalasalingam Academy of Research and Education	Krishnankoil",
                "379.IFHE Hyderabad	Hyderabad",
                "380.Adamas University	Barasat",
                "389.NIMS University	Jaipur",
                "394.Avantika University	Ujjain",
                "395.GLA University	Chaumuhan",
                "397.JECRC University	Jaipur",
                "400.Suresh Gyan Vihar University	Jaipur",
                "410.Dayananda Sagar University	Bangalore",
                "417.Vignan University	Guntur",
                "419.Dr. M.G.R. Educational and Research Institute	Chennai",
                "420.Karnavati University	Gandhinagar",
                "436.Marwadi University	Rajkot",
                "438.Quantum University	Roorkee",
                "440.Prof. Rajendra Singh (Rajju Bhaiya) University	Allahabad",
                "443.KLE University	Belgaum ...",
                "445.Charotar University of Science and Technology	Anand",
                "447.Graphic Era Hill University	Clement Town",
                "448.Sri Chandrasekharendra Saraswathi Viswa Mahavidyalaya	Kanchipuram",
                "450.Swami Vivekananda Yoga Anusandhana Samsthana	Bangalore",
                "451.Tilak Maharashtra Vidyapeeth	Pune",
                "454.Uttaranchal University	Dehradun",
                "455.Dev Sanskriti Vishwavidyalaya	Shantikunj",
                "465.RK University	Rajkot",
                "471.Sri Sri University	Cuttack",
                "472.Kalinga University	Raipur",
                "473.Garden City University	Bangalore",
                "474.Sri Balaji Vidyapeeth	Puducherry",
                "476.Singhania University	Jhunjhunu",
                "477.Ajeenkya D.Y. Patil University	Pune",
                "478.Lingaya's University	Faridabad",
                "484.ICFAI University, Tripura	Agartala ...",
                "486.Sandip University	Nashik ...",
                "487.IEC University	Kalujhanda",
                "505.Anant National University	Ahmedabad",
                "508.Techno India University	Kolkata",
                "512.Jagannath University	Jaipur",
                "516.Rishihood University	Sonipat",
                "518.Dr. C.V. Raman University	Bilaspur",
                "520.Deccan College Post-Graduate and Research Institute	Pune",
                "525.Shobhit Institute of Engineering and Technology	Meerut",
                "526.Vivekananda Global University	Jaipur",
                "530.G.L.S. University	Ahmedabad",
                "533.IIMT University	Meerut",
                "534.Poornima University	Jaipur",
                "536.Jain Vishva Bharati Institute	Ladnun",
                "537.Chitkara University, Himachal Pradesh	Kalujhanda",
                "543.Babu Banarasi Das University	Lucknow",
                "545.IIHMR University	Jaipur",
                "546.Himalayan University	Itanagar",
                "547.Uka Tarsadia University	Bardoli ...",
                "549.Vishwakarma University	Pune",
                "551.Rai University	Ahmedabad",
                "554.Datta Meghe Institute of Medical Sciences	Nagpur",
                "559.Jagran Lakecity University	Bhopal",
                "562.DAV University	Jalandhar",
                "563.Sanskriti University	Mathura",
                "564.Indus University	Ahmedabad",
                "566.Himgiri ZEE University	Dehradun",
                "569.Karpagam Academy of Higher Education	Coimbatore",
                "574.St. Xavier's University	Kolkata",
                "576.ICFAI University, Dehradun	Dehradun",
                "580.Sir Padampat Singhania University	Udaipur",
                "581.MATS University	Aarang",
                "584.Mewar University	Chittorgarh",
                "585.People's University	Bhopal",
                "586.MIT University	Shillong",
                "587.Jaypee University of Engineering and Technology	Raghogarh",
                "588.Kaziranga University	Jorhat",
                "589.Glocal University	Saharanpur",
                "590.Jharkhand Rai University	Ranchi",
                "591.Jayoti Vidyapeeth Women's University	Jaipur",
                "593.Mangalayatan University	Aligarh",
                "596.Medi-Caps University	Indore",
                "599.AURO University	Surat",
                "604.University of Trans-Disciplinary Health Sciences and Technology	Bangalore",
                "605.Periyar Maniammai Institute of Science and Technology	Vallam ...",
                "607.RKDF University	Bhopal",
                "612.Maharishi Mahesh Yogi Vedic Vishwavidyalaya	Katni ...",
                "614.Swami Rama Himalayan University	Dehradun",
                "615.Sri Guru Granth Sahib World University	Fatehgarh Sahib",
                "616.JIS University	Agarpara",
                "618.Sushant University	Gurgaon",
                "619.Career Point University	Hamirpur ...",
                "621.Ponnaiyan Ramajayam Institute of Science and Technology	Thanjavur",
                "623.BLDE University	Bijapur",
                "626.Krishna Institute of Medical Sciences	Karad",
                "627.Shri Venkateshwara University	Gajraula",
                "630.RIMT University	Mandi Gobindgarh",
                "633.Mahatma Gandhi University, Meghalaya	Khanapara",
                "637.GNA University	Phagwara",
                "641.OPJS University	Churu",
                "646.LNCT University	Bhopal",
                "647.Pacific University, India	Udaipur",
                "650.Navrachana University	Vadodara",
                "652.Maharishi University of Management and Technology	Bilaspur",
                "654.MGM Institute of Health Sciences	Navi Mumbai",
                "659.Rabindranath Tagore University	Mendua Village",
                "660.Shri Vaishnav Vidyapeeth Vishwavidyalaya	Indore",
                "661.Indian Institute of Public Health	Gandhinagar",
                "663.Symbiosis University of Applied Sciences	Indore",
                "664.Sangam University	Bhilwara",
                "666.ICFAI University, Jharkhand	Ranchi",
                "670.IMS Unison University	Dehradun",
                "673.Dr K.N. Modi University	Newai",
                "674.Arunachal University of Studies	Namsai",
                "678.Suamandeep Vidyapeeth	Vadodara",
                "681.University of Science and Technology, Meghalaya	Baridua",
                "682.Santosh University	Ghaziabad",
                "683.Bhagwant University	Ajmer",
                "684.Mahatma Jyoti Rao Phoole University	Jaipur",
                "685.Alakh Prakash Goyal Shimla University	Shimla",
                "686.Jodhpur National University	Jodhpur",
                "687.University of Technology	Jaipur",
                "688.Desh Bhagat University	Mandi Gobindgarh",
                "689.Institute of Advanced Studies in Education	Sardarshahr",
                "691.Maharishi University	Lucknow",
                "692.Shri Ramswaroop Memorial University	Barabanki",
                "695.ISBM University	Gariyaband",
                "696.PDM University	Bahadurgarh",
                "699.Oriental University	Indore",
                "702.O.P. Jindal University	Raigarh",
                "715.University of Patanjali	Haridwar",
                "716.Sri Devaraj Urs Academy of Higher Education and Research	Kolar",
                "720.Jagan Nath University	Jhajjar",
                "721.ICFAI University, Sikkim	Gangtok",
                "724.St. Peter's Institute of Higher Education and Research	Chennai",
                "725.EIILM University	Jorethang",
                "728.IFTM University	Moradabad",
                "730.Shridhar University	Pilani",
                "733.P P Savani University	Kosamba",
                "737.Mahatma Gandhi University of Medical Sciences and Technology	Jaipur",
                "738.Rayat-Bahra University	Kharar",
                "742.AKS University	Satna",
                "743.MVN University	Palwal",
                "744.Sri Siddhartha Academy of Higher Education	Tumkur",
                "745.Sri Satya Sai University of Technology and Medical Sciences	Sehore",
                "746.JSS Science and Technology University	Mysore",
                "748.Sabarmati University	Ahmedabad",
                "749.ITM Vocational University	Waghodia",
                "751.Himalayan Garhwal University	Pokhara Village",
                "752.Adesh University	Bathinda",
                "753.ICFAI University, Jaipur	Jaipur",
                "754.Jagadguru Rambhadracharya Handicapped University	Chitrakoot",
                "755.Eternal University	Baru Sahib",
                "756.Kadi Sarva Vishwavidyalaya	Gandhinagar",
                "757.Srinivas University	Mangalore",
                "760.Bhartiya Skill Development University	Jaipur",
                "761.Martin Luther Christian University	Shillong",
                "762.Raffles University	Neemrana",
                "766.Baddi University of Emerging Sciences and Technologies	Baddi",
                "769.Manav Bharti University	Solan",
                "771.G.H. Raisoni University	Saikheda",
                "772.Mohammad Ali Jauhar University	Rampur",
                "773.Sunrise University	Alwar",
                "774.Mandsaur University	Mandsaur",
                "775.The Neotia University	Sarisha ...",
                "776.Monad University	Hapur",
                "777.Meenakshi Academy of Higher Education and Research	Chennai",
                "779.Dr. A.P.J Abdul Kalam University	Indore",
                "780.Atmiya University	Rajkot",
                "782.Swami Vivekanand University	Sagar",
                "783.Spicer Adventist University	Pune",
                "784.Apex University	Jaipur",
                "785.Maharishi Markandeshwar University, Solan	Solan ...",
                "786.Seacom Skills University	Bolpur",
                "787.Sanjay Ghodawat University	Kolhapur",
                "790.Apex Professional University	Pasighat",
                "791.ICFAI University, Raipur	Durg",
                "794.Guru Kashi University	Talwandi Sabo",
                "796.JS University	Shikohabad",
                "797.GSFC University	Vadodara",
                "798.Arni University	Kathgarh",
                "799.North East Frontier Technical University	Aalo",
                "800.Baba Mastnath University	Rohtak",
                "801.Madhyanchal Professional University	Bhopal",
                "802.Sai Nath University	Ranchi",
                "803.Indrashil University	Rajpur",
                "805.NIILM University	Kaithal",
                "806.Swarnim Startup and Innovation University	Gandhinagar",
                "807.Sankalchand Patel University	Visnagar",
                "808.Shri Jagdishprasad Jhabrmal Tibrewala University	Jhunjhunu",
                "809.Pratap University	Jaipur",
                "811.Era University	Lucknow",
                "812.ICFAI University, Mizoram	Aizawl",
                "813.C.U. Shah University	Wadhwan",
                "815.TeamLease Skills University	Tarsali",
                "817.Institute of Advanced Research	Gandhinagar",
                "818.Sri Sai University	Palampur",
                "821.Sarvepalli Radhakrishnan University	Bhopal",
                "822.Arka Jain University	Gamharia",
                "823.Tantia University	Sri Ganganagar",
                "824.BAHRA University	Waknaghat ...",
                "828.Sarala Birla University	Ranchi",
                "830.Maharaja Agrasen University	Baddi",
                "831.Al-Falah University	Faridabad",
                "832.Akal University	Bathinda",
                "834.ICFAI University, Meghalaya	Tura",
                "835.ICFAI University, Himachal Pradesh	Baddi",
                "836.Mahapurusha Srimanta Sankaradeva Viswavidyalaya	Nagaon",
                "837.Sant Baba Bhag Singh University	Jalandhar",
                "838.Starex University	Gurgaon",
                "840.Bhupal Nobles University	Udaipur",
                "841.Indus International University	Bathu",
                "842.ICFAI University, Nagaland	Dimapur",
                "843.Rai Technology University	Doddaballapura",
                "845.Usha Martin University	Ranchi",
                "846.Nehru Gram Bharati Vishwavidyalaya	Allahabad",
                "847.Bareilly International University	Bareilly",
                "848.Pacific Medical University	Udaipur",
                "849.Sri Guru Ram Das University of Health Sciences	Qila Jiwan Singh",
                "850.Maharishi Arvind University, Jaipur	Mundiya Purohitan",
                "852.Shri Guru Ram Rai University	Dehradun",
                "854.Maharishi Markandeshwar University, Sadopur	Ambala",
                "855.Jaypee University Anoopshahr	Anupshahr",
                "856.Vinayaka Missions Sikkim University	Gangtok",
                "857.William Carey University, Meghalaya	Shillong",
                "858.Malwanchal University	Indore",
                "859.K.K. University	Biharsharif",
                "860.Pragyan International University	Ranchi",
                "861.Plastindia International University	Vapi",
                "863.Sharnbasva University	Gulbarga",
                "864.SRM University, Sikkim	Gangtok",
                "866.YBN University	Ranchi",
                "867.Geetanjali University	Udaipur",
                "869.Lakulish Yoga University	Ahmedabad",
                "870.St. Joseph University	Dimapur",
                "871.P.K. University	Village Thanara",
                "872.Abhilashi University	Chailchowk",
                "874.Sangai International University	Churachandpur",
                "875.Sai Tirupati University	Udaipur",
                "877.Arunodaya University	Itanagar",
                "878.CMJ University	Jorabat",
                "879.Indira Gandhi Technological and Medical Sciences University Ziro",
                "880.Ras Bihari Bose Subharti University Dehradun",
                "881.Maulana Azad University, Jodhpur",
                "886.Shri Guru Ram Rai Education Mission	Dehradun ",
        };

        un = new JComboBox<>(university);
        un.setBounds(900, 460, 300, 40);
        un.setFont(new Font("arial", Font.BOLD, 18));
        un.setBackground(Color.WHITE);

        l14 = new JLabel("Grad. Obtained Marks (%) * :");
        l14.setBounds(620, 510, 300, 40);
        l14.setFont(new Font("arial", Font.BOLD, 18));

        tf8 = new JTextField();
        tf8.setBounds(900, 510, 300, 40);
        tf8.setFont(new Font("arial", Font.BOLD, 18));

        l15 = new JLabel("Graduation Passing Year * : ");
        l15.setBounds(620, 560, 300, 40);
        l15.setFont(new Font("arial", Font.BOLD, 18));

        Integer gyear[] = {2023, 2022, 2021, 2020, 2019, 2018, 2017, 2016, 2015, 2014, 2013, 2012, 2011, 2010, 2009, 2008, 2007,
                2006, 2005, 2004, 2003, 2002, 2001, 2000, 1999, 1998, 1997, 1996, 1995, 1994, 1993, 1992, 1991, 1990,
                1989, 1988, 1987, 1986, 1985, 1984, 1983, 1982, 1981, 1980, 1979, 1978, 1977, 1976, 1975, 1974, 1973,
                1972, 1971, 1970, 1969, 1968, 1967, 1966, 1965, 1964, 1963, 1962, 1961, 1960, 1959, 1958, 1957, 1956,
                1955, 1954, 1953, 1952, 19591, 1950,};

        gpy = new JComboBox<>(gyear);
        gpy.setBounds(900, 560, 300, 40);
        gpy.setFont(new Font("arial", Font.BOLD, 18));
        gpy.setBackground(Color.WHITE);

        try {
            Connection conn = ConnectionProvider.getConnnection();
            String q = "select * from Student_Details_3 where Roll_no ='"+ crollno.getSelectedItem() + "' ";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(q);
            while (rs.next())
            {
                tf1.setText(rs.getString("10th_Obtained_Marks"));
                tf2.setText(rs.getString("10th_Board"));
                tf4.setText(rs.getString("12th_Obtained_Marks"));
                tf5.setText(rs.getString("12th_Board"));
                tf6.setText(rs.getString("Diploma_Branch"));
                tf7.setText(rs.getString("Diploma_Obtained_Marks"));
                tf8.setText(rs.getString("Graduation_Obtained_Marks"));
            }

        }catch (Exception ex2)
        {
            ex2.printStackTrace();
        }

        submit = new JButton("Submit");
        submit.setBounds(1050, 640, 150, 40);
        submit.setForeground(Color.WHITE);
        submit.setBackground(Color.BLACK);
        submit.setFont(new Font("arial", Font.BOLD, 20));

        close = new JButton("Close");
        close.setBounds(900, 640, 150, 40);
        close.setForeground(Color.WHITE);
        close.setBackground(Color.BLACK);
        close.setFont(new Font("arial", Font.BOLD, 20));

        add(tittle); add(lh); add(li); add(l1); add(l2);
        add(l3); add(l4); add(l5); add(l6); add(l7);
        add(l8); add(l9); add(l10); add(l11); add(l12);
        add(l13); add(l14); add(l15);
        add(tf1); add(tf2); add(tenpy); add(tf4); add(tf5);
        add(tf6); add(tf7); add(twlpy); add(tf8); add(dpy);
        add(course); add(un); add(gpy); add(j12s); add(ld);
        add(jdip); add(lgp);
        add(submit); add(close);
        add(sear); add(crollno); //  add(search);

        submit.addActionListener(this);
        close.addActionListener(this);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == close) {
            setVisible(false);
        }
        if (e.getSource() == submit) {
            try {
                String tenMarks = "" + tf1.getText();
                String tenBoard = "" + tf2.getText();
                String twlMarks = "" + tf4.getText();
                String twlBoard = "" + tf5.getText();
                String dipbranch = "" + tf6.getText();
                String dipMarks = "" + tf7.getText();
                String graduMarks = "" + tf8.getText();

                if (tenMarks.equals("")) {
                    JOptionPane.showMessageDialog(null, "Please fill 10th Marks");
                } else if (tenBoard.equals("")) {
                    JOptionPane.showMessageDialog(null, "Please fill 10th Board field");
                }else if (twlMarks.equals("")) {
                    JOptionPane.showMessageDialog(null, "Please fill 12th Marks");
                } else if (twlBoard.equals("")) {
                    JOptionPane.showMessageDialog(null, "Please fill 10th Board field");
                } else if (dipbranch.equals("")) {
                    JOptionPane.showMessageDialog(null, "Please Select Any Diploma");
                } else if (dipMarks.equals("")) {
                    JOptionPane.showMessageDialog(null, "Please fill Diploma Marks");
                } else if (graduMarks.equals("")) {
                    JOptionPane.showMessageDialog(null, "Please fill Graduation Marks");
                }
                try {
                    String driver = "com.mysql.cj.jdbc.Driver";
                    String url = "jdbc:mysql://localhost:3306/schoolarshipmanagementsystem";

                    String username = "root";
                    String password = "rna@2004";
                    Class.forName(driver);
                    Connection conn = DriverManager.getConnection(url, username, password);
//                    Connection conn = ConnectionProvider.getConnnection();
                    String q2 = "update Student_Details_3 set 10th_Obtained_Marks = '" + tenMarks + "',10th_Board = '" + tenBoard + "',12th_Obtained_Marks = '" + twlMarks + "',12th_Board = '" + twlBoard + "',Diploma_Branch = '" + dipbranch +"',Diploma_Obtained_Marks = '" + dipMarks + "',Graduation_Obtained_Marks = '" + graduMarks + "'  where Roll_no = '" + Rollno + "'";
                    Statement stmt = conn.createStatement();
                    stmt.executeUpdate(q2);
                    System.out.println("Database connected..");
                    System.out.println("Your data has been updated..");

                    JOptionPane.showMessageDialog(null, "Student's Educational Details Updated Securely");
                    setVisible(false);
                    new A_04_UserAuthority().setVisible(true);
                } catch (Exception ex1) {
                    ex1.getStackTrace();
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }
    public static void main(String[] args) {
        new A_07_Student_Update_3("");
    }
}