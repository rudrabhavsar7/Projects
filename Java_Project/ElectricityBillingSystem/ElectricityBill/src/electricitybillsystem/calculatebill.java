package electricitybillsystem;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;

public class calculatebill extends JFrame implements ActionListener {
    JButton submit, cancel;
    Choice meterno, cmonth;
    JLabel lblmeteraddress, lblmetername;
    JTextField tfunit;
    conn c;  // Central conn object

    calculatebill() {
        setSize(700, 500);
        setLocation(400, 200);

        JPanel p = new JPanel();
        p.setLayout(null);
        p.setBackground(new Color(173, 216, 230));
        add(p);

        JLabel heading = new JLabel("Calculate Electricity Bill");
        heading.setBounds(220, 15, 500, 30);
        heading.setFont(new Font("Tahoma", Font.PLAIN, 24));
        p.add(heading);

        JLabel lblmeterno = new JLabel("Meter Number");
        lblmeterno.setBounds(170, 80, 100, 20);
        p.add(lblmeterno);

        meterno = new Choice();
        c = new conn();  // Create conn object here

        try {
            String query = "select * from customer";
            ResultSet rs = c.s.executeQuery(query);

            while (rs.next()) {
                meterno.add(rs.getString("meter_no"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        meterno.setBounds(310, 80, 200, 20);
        p.add(meterno);

        JLabel lblname = new JLabel("Name");
        lblname.setBounds(170, 120, 100, 20);
        p.add(lblname);

        lblmetername = new JLabel("");
        lblmetername.setBounds(310, 120, 100, 20);
        p.add(lblmetername);

        JLabel lbladdress = new JLabel("Address");
        lbladdress.setBounds(170, 160, 100, 20);
        p.add(lbladdress);

        lblmeteraddress = new JLabel("");
        lblmeteraddress.setBounds(310, 160, 100, 20);
        p.add(lblmeteraddress);

        meterno.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent ie) {
                try {
                    String query = "select * from customer where meter_no = '" + meterno.getSelectedItem() + "'";
                    ResultSet rs = c.s.executeQuery(query);
                    if (rs.next()) {
                        lblmetername.setText(rs.getString("name"));
                        lblmeteraddress.setText(rs.getString("address"));
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        JLabel lblunit = new JLabel("Unit Consumed");
        lblunit.setBounds(170, 200, 100, 20);
        p.add(lblunit);

        tfunit = new JTextField();
        tfunit.setBounds(310, 200, 200, 20);
        p.add(tfunit);

        JLabel lblmonth = new JLabel("Month");
        lblmonth.setBounds(170, 240, 100, 20);
        p.add(lblmonth);

        cmonth = new Choice();
        cmonth.add("January");
        cmonth.add("February");
        cmonth.add("March");
        cmonth.add("April");
        cmonth.add("May");
        cmonth.add("June");
        cmonth.add("July");
        cmonth.add("August");
        cmonth.add("September");
        cmonth.add("October"); 
        cmonth.add("November");
        cmonth.add("December");
        cmonth.setBounds(310, 240, 200, 20);
        p.add(cmonth);

        submit = new JButton("Submit");
        submit.setBounds(220, 380, 100, 20);
        submit.addActionListener(this);
        p.add(submit);

        cancel = new JButton("Cancel");
        cancel.setBounds(350, 380, 100, 20);
        cancel.addActionListener(this);
        p.add(cancel);

        setLayout(new BorderLayout());
        add(p, "Center");
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == submit) {
            String meter = meterno.getSelectedItem();
            String units = tfunit.getText();
            String month = cmonth.getSelectedItem();

            int totalbill = 0;

            // Validate units input
            int unit_consumed;
            try {
                unit_consumed = Integer.parseInt(units);
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Please enter a valid number for units consumed.");
                return; // Stop further execution
            }

            String query = "select * from tax";

            try {
                ResultSet rs = c.s.executeQuery(query);

                while (rs.next()) {
                    totalbill += unit_consumed * Integer.parseInt(rs.getString("cost_per_unit"));
                    totalbill += Integer.parseInt(rs.getString("meter_rent"));
                    totalbill += Integer.parseInt(rs.getString("service_charge"));
                    totalbill += Integer.parseInt(rs.getString("service_tax"));
                    totalbill += Integer.parseInt(rs.getString("swacch_bharat_cess"));
                    totalbill += Integer.parseInt(rs.getString("fixed_tax"));
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

            String query2 = "insert into bill values('" + meter + "','" + month + "','" + units + "','" + totalbill + "','Not Paid')";
            try {
                c.s.executeUpdate(query2);
                JOptionPane.showMessageDialog(null, "Customer Bill Updated Successfully");
                // Provide an option to either close or enter another bill
                int input = JOptionPane.showOptionDialog(null, "Do you want to enter another bill?", "Choose",
                        JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, null);
                if (input == JOptionPane.NO_OPTION) {
                    setVisible(false);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new calculatebill();
    }

}
