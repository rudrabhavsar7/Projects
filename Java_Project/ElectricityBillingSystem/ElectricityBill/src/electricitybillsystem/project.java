package electricitybillsystem;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class project extends JFrame implements ActionListener {
    String atype,meter;

    project(String atype,String meter) {
        this.meter=meter;
        this.atype = atype;
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/elect1.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1550, 850, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        add(image);

        // menubar

        JMenuBar mb = new JMenuBar();
        setJMenuBar(mb);

        // menu1

        JMenu master = new JMenu("Master");
        master.setForeground(Color.BLACK);

        // mastermenuitems

        JMenuItem newcustomer = new JMenuItem("New Customer");
        newcustomer.setFont(new Font("monospaced", Font.PLAIN, 12));
        newcustomer.setBackground(Color.white);
        ImageIcon icon1 = new ImageIcon(ClassLoader.getSystemResource("icon/icon1.png"));
        Image image1 = icon1.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
        newcustomer.addActionListener(this);
        newcustomer.setIcon(new ImageIcon(image1));
        newcustomer.setMnemonic('D');
        newcustomer.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_D, ActionEvent.CTRL_MASK));
        master.add(newcustomer);

        JMenuItem customerdetails = new JMenuItem("Customer Details");
        customerdetails.setFont(new Font("monospaced", Font.PLAIN, 12));
        customerdetails.setBackground(Color.white);
        ImageIcon icon2 = new ImageIcon(ClassLoader.getSystemResource("icon/icon2.png"));
        Image image2 = icon2.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
        customerdetails.setIcon(new ImageIcon(image2));
        customerdetails.addActionListener(this);
        customerdetails.setMnemonic('M');
        customerdetails.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_M, ActionEvent.CTRL_MASK));
        master.add(customerdetails);

        JMenuItem depositdetails = new JMenuItem("Deposite Details");
        depositdetails.setFont(new Font("monospaced", Font.PLAIN, 12));
        depositdetails.setBackground(Color.white);
        ImageIcon icon3 = new ImageIcon(ClassLoader.getSystemResource("icon/icon3.png"));
        Image image3 = icon3.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
        depositdetails.setIcon(new ImageIcon(image3));
        depositdetails.addActionListener(this);
        depositdetails.setMnemonic('N');
        depositdetails.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, ActionEvent.CTRL_MASK));
        master.add(depositdetails);

        JMenuItem calculatebill = new JMenuItem("Calculate Bill");
        calculatebill.setFont(new Font("monospaced", Font.PLAIN, 12));
        calculatebill.setBackground(Color.white);
        ImageIcon icon4 = new ImageIcon(ClassLoader.getSystemResource("icon/icon5.png"));
        Image image4 = icon4.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
        calculatebill.setIcon(new ImageIcon(image4));
        calculatebill.addActionListener(this);
        calculatebill.setMnemonic('B');
        calculatebill.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_B, ActionEvent.CTRL_MASK));
        master.add(calculatebill);

        // menu2

        JMenu info = new JMenu("Information");
        info.setForeground(Color.BLACK);

        // informationmenuitems

        JMenuItem updateinfo = new JMenuItem("Update Information");
        updateinfo.setFont(new Font("monospaced", Font.PLAIN, 12));
        updateinfo.setBackground(Color.white);
        ImageIcon icon5 = new ImageIcon(ClassLoader.getSystemResource("icon/icon4.png"));
        Image image5 = icon5.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
        updateinfo.setIcon(new ImageIcon(image5));
        updateinfo.setMnemonic('P');
        updateinfo.addActionListener(this);
        updateinfo.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P, ActionEvent.CTRL_MASK));
        info.add(updateinfo);

        JMenuItem viewinfo = new JMenuItem("View Information");
        viewinfo.setFont(new Font("monospaced", Font.PLAIN, 12));
        viewinfo.setBackground(Color.white);
        ImageIcon icon6 = new ImageIcon(ClassLoader.getSystemResource("icon/icon6.png"));
        Image image6 = icon6.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
        viewinfo.setIcon(new ImageIcon(image6));
        viewinfo.addActionListener(this);
        viewinfo.setMnemonic('L');
        viewinfo.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_L, ActionEvent.CTRL_MASK));
        info.add(viewinfo);

        // menu3

        JMenu user = new JMenu("User");
        user.setForeground(Color.BLACK);

        // usermenuitems

        JMenuItem paybill = new JMenuItem("Pay Bill");
        paybill.setFont(new Font("monospaced", Font.PLAIN, 12));
        paybill.setBackground(Color.white);
        ImageIcon icon7 = new ImageIcon(ClassLoader.getSystemResource("icon/icon4.png"));
        Image image7 = icon7.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
        paybill.setIcon(new ImageIcon(image7));
        paybill.addActionListener(this);
        paybill.setMnemonic('R');
        paybill.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_R, ActionEvent.CTRL_MASK));
        user.add(paybill);

        JMenuItem billdet = new JMenuItem("Bill Details");
        billdet.setFont(new Font("monospaced", Font.PLAIN, 12));
        billdet.setBackground(Color.white);
        ImageIcon icon8 = new ImageIcon(ClassLoader.getSystemResource("icon/icon6.png"));
        Image image8 = icon8.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
        billdet.setIcon(new ImageIcon(image8));
        billdet.addActionListener(this);
        billdet.setMnemonic('B');
        billdet.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_B, ActionEvent.CTRL_MASK));
        user.add(billdet);

        // menu4

        JMenu report = new JMenu("Report");
        report.setForeground(Color.BLACK);

        // reportmenuitems

        JMenuItem generatebill = new JMenuItem("Generate Bill");
        generatebill.setFont(new Font("monospaced", Font.PLAIN, 12));
        generatebill.setBackground(Color.white);
        ImageIcon icon9 = new ImageIcon(ClassLoader.getSystemResource("icon/icon7.png"));
        Image image9 = icon9.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
        generatebill.setIcon(new ImageIcon(image9));
        generatebill.addActionListener(this);
        generatebill.setMnemonic('G');
        generatebill.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_G, ActionEvent.CTRL_MASK));
        report.add(generatebill);

        // menu5

        JMenu utility = new JMenu("Utility");
        utility.setForeground(Color.BLACK);

        // utilitymenuitems

        JMenuItem notepad = new JMenuItem("Notepad");
        notepad.setFont(new Font("monospaced", Font.PLAIN, 12));
        notepad.setBackground(Color.white);
        ImageIcon icon10 = new ImageIcon(ClassLoader.getSystemResource("icon/icon12.png"));
        Image image10 = icon10.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
        notepad.setIcon(new ImageIcon(image10));
        notepad.setMnemonic('X');
        notepad.addActionListener(this);
        notepad.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X, ActionEvent.CTRL_MASK));
        utility.add(notepad);

        JMenuItem calculator = new JMenuItem("Calculator");
        calculator.setFont(new Font("monospaced", Font.PLAIN, 12));
        calculator.setBackground(Color.white);
        ImageIcon icon11 = new ImageIcon(ClassLoader.getSystemResource("icon/icon9.png"));
        Image image11 = icon11.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
        calculator.setIcon(new ImageIcon(image11));
        calculator.setMnemonic('C');
        calculator.addActionListener(this);
        calculator.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, ActionEvent.CTRL_MASK));
        utility.add(calculator);

        // menu6

        JMenu mexit = new JMenu("Exit");
        mexit.setForeground(Color.BLACK);

        // exitmenuitems

        JMenuItem exit = new JMenuItem("Exit");
        exit.setFont(new Font("monospaced", Font.PLAIN, 12));
        exit.setBackground(Color.white);
        ImageIcon icon12 = new ImageIcon(ClassLoader.getSystemResource("icon/icon11.png"));
        Image image12 = icon12.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
        exit.setIcon(new ImageIcon(image12));
        exit.setMnemonic('X');
        exit.addActionListener(this);
        exit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X, ActionEvent.CTRL_MASK));
        mexit.add(exit);

        if (atype.equals("Admin")) {
            mb.add(master);
        } else {
            mb.add(info);
            mb.add(user);
            mb.add(report);
        }
        mb.add(utility);
        mb.add(mexit);
        setLayout(new FlowLayout());

        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        String msg = ae.getActionCommand();
        if (msg.equals("New Customer")) {
            new NewCustomer();
        } else if (msg.equals("Customer Details")) {
            new customerdetails();
        } else if (msg.equals("Deposite Details")) {
            new depositedetails();
        } else if (msg.equals("Calculate Bill")) {
            new calculatebill();
        }
        else if(msg.equals("View Information"))
        {
            new viewinformation(meter);
        }
        else if(msg.equals("Update Information"))
        {
            new updateinformation(meter);
        }
        else if(msg.equals("Bill Details"))
        {
            new billdetails(meter);
        }
        else if(msg.equals("Notepad"))
        {
            try {
                Runtime.getRuntime().exec("notepad.exe");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        else if(msg.equals("Calculator"))
        {
            try {
                Runtime.getRuntime().exec("calc.exe");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        else if(msg.equals("Generate Bill"))
        {
            new generate(meter);
        }
        else if(msg.equals("Exit"))
        {
            setVisible(false);
            new Login();
        }
        else if(msg.equals("Pay Bill"))
        {
            new paybill(meter);
        }
        
    }

    public static void main(String[] args) {
        new project("","");
    }
}
