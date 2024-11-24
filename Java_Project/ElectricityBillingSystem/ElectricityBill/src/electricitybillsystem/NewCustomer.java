package electricitybillsystem;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

class InvalidNumberLengthException extends Exception {
    InvalidNumberLengthException(String s) {
        super(s);
        JOptionPane.showMessageDialog(null, s);
    }
}

class InvalidEmailException extends Exception {
    InvalidEmailException(String s) {
        super(s);
        JOptionPane.showMessageDialog(null, s);
    }
}

public class NewCustomer extends JFrame implements ActionListener {

    int phoneCheck(String s) {
        try {
            if (s.length() != 10) {
                throw new InvalidNumberLengthException("Check Your Phone Number");
            } else {
                return 1;
            }
        } catch (Exception e) {
            return 0;
        }
        
    }

    int emailCheck(String s) {
        int count = 0;
        for (char e : s.toCharArray()) {
            if (e == '@') {
                count++;
            }
        }
        try {
            if (count == 0) {
                throw new InvalidEmailException("Check Your Email.\n'i.e \"xyz@gmail.com\"");
            } else {
                return 1;
            }
        } catch (Exception e) {
            return 0;
        }
        
    }

    JTextField tfname, tfaddress, tfcity, tfstate, tfemail, tfphoneno;
    JButton next, cancel;
    JLabel lblmeter;

    NewCustomer() {
        setSize(700, 500);
        setLocation(400, 200);

        JPanel p = new JPanel();
        p.setLayout(null);
        p.setBackground(new Color(173, 216, 230));
        add(p);

        JLabel heading = new JLabel("New Customer");
        heading.setBounds(270, 15, 200, 20);
        heading.setFont(new Font("Tahoma", Font.PLAIN, 24));
        p.add(heading);

        JLabel lblname = new JLabel("Customer Name");
        lblname.setBounds(170, 80, 100, 20);
        p.add(lblname);

        tfname = new JTextField();
        tfname.setBounds(310, 80, 200, 20);
        p.add(tfname);

        JLabel lblmeterno = new JLabel("Meter Number");
        lblmeterno.setBounds(170, 120, 100, 20);
        p.add(lblmeterno);

        lblmeter = new JLabel("");
        lblmeter.setBounds(310, 120, 200, 20);
        p.add(lblmeter);

        Random ran = new Random();
        long number = ran.nextLong() % 1000000;
        lblmeter.setText("" + Math.abs(number));

        JLabel lbladdress = new JLabel("Address");
        lbladdress.setBounds(170, 160, 100, 20);
        p.add(lbladdress);

        tfaddress = new JTextField();
        tfaddress.setBounds(310, 160, 200, 20);
        p.add(tfaddress);

        JLabel lblcity = new JLabel("City");
        lblcity.setBounds(170, 200, 100, 20);
        p.add(lblcity);

        tfcity = new JTextField();
        tfcity.setBounds(310, 200, 200, 20);
        p.add(tfcity);

        JLabel lblstate = new JLabel("State");
        lblstate.setBounds(170, 240, 100, 20);
        p.add(lblstate);

        tfstate = new JTextField();
        tfstate.setBounds(310, 240, 200, 20);
        p.add(tfstate);

        JLabel lblemail = new JLabel("Email");
        lblemail.setBounds(170, 280, 100, 20);
        p.add(lblemail);

        tfemail = new JTextField();
        tfemail.setBounds(310, 280, 200, 20);
        p.add(tfemail);

        JLabel lblphone = new JLabel("Phone Number");
        lblphone.setBounds(170, 320, 100, 20);
        p.add(lblphone);

        tfphoneno = new JTextField();
        tfphoneno.setBounds(310, 320, 200, 20);
        p.add(tfphoneno);

        next = new JButton("Next");
        next.setBounds(220, 380, 100, 20);
        next.addActionListener(this);
        p.add(next);

        cancel = new JButton("Cancel");
        cancel.setBounds(350, 380, 100, 20);
        cancel.addActionListener(this);
        p.add(cancel);

        setLayout(new BorderLayout());
        add(p, "Center");
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == next) {
            String name = tfname.getText();
            String meter = lblmeter.getText();
            String address = tfaddress.getText();
            String city = tfcity.getText();
            String state = tfstate.getText();
            String email = tfemail.getText();
            String phone = tfphoneno.getText();
            if (emailCheck(email) == 1 && phoneCheck(phone) == 1) {
                String query1 = "insert into customer values('" + name + "','" + meter + "','" + address + "','" + city
                        + "','" + state + "','" + email + "','" + phone + "')";
                String query2 = "insert into login values('" + meter + "','','" + name + "','','')";
                
                try {
                    conn c = new conn();
                    c.s.executeUpdate(query1);
                    c.s.executeUpdate(query2);

                    JOptionPane.showMessageDialog(null, "Customer Details Added Successfully");
                    setVisible(false);
                    new Meterinfo(meter);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

        } else {
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new NewCustomer();
    }

}
