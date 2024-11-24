package electricitybillsystem;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;

public class paybill extends JFrame implements ActionListener {

    Choice cmonth;
    String meter;
    JButton pay,back;
    paybill(String meter)
    {
        this.meter=meter;
        setLayout(null);
        setBounds(300,150,700,600);

        JLabel heading = new JLabel("Electricity Bill");
        heading.setFont(new Font("Tahoma",Font.BOLD,24));
        heading.setBounds(250, 5, 400, 30);
        add(heading);

        
        JLabel lblmeternumber = new JLabel("Meter Number");
        lblmeternumber.setBounds(35, 80, 200, 20);
        add(lblmeternumber);

        JLabel meternumber = new JLabel("");
        meternumber.setBounds(300, 80, 200, 20);
        add(meternumber);
        
        JLabel lblname = new JLabel("Meter Number");
        lblname.setBounds(35, 140, 200, 20);
        add(lblname);

        JLabel labelname = new JLabel("");
        labelname.setBounds(300, 140, 200, 20);
        add(labelname);

        JLabel lblmonth = new JLabel("Month");
        lblmonth.setBounds(35, 200, 200, 20);
        add(lblmonth);

        cmonth = new Choice();
        cmonth.setBounds(300, 200, 200, 20);
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
        add(cmonth);

        JLabel lblunits = new JLabel("Units");
        lblunits.setBounds(35, 260, 200, 20);
        add(lblunits);

        JLabel labelunits = new JLabel("");
        labelunits.setBounds(300, 260, 200, 20);
        add(labelunits);

        JLabel lbltotalbill = new JLabel("Total Bill");
        lbltotalbill.setBounds(35, 320, 200, 20);
        add(lbltotalbill);

        JLabel labeltotalbill = new JLabel("");
        labeltotalbill.setBounds(300, 320, 200, 20);
        add(labeltotalbill);

        JLabel lblstatus = new JLabel("Status");
        lblstatus.setBounds(35, 380, 200, 20);
        add(lblstatus);

        JLabel labelstatus = new JLabel("");
        labelstatus.setBounds(300, 380, 200, 20);
        labelstatus.setForeground(Color.red);
        add(labelstatus);

        try {
            conn c = new conn();
            ResultSet rs = c.s.executeQuery("select * from customer where meter_no = '"+meter+"'");
            while(rs.next())
            {
                meternumber.setText(meter);
                labelname.setText(rs.getString("name"));
            }

            rs = c.s.executeQuery("select * from bill where meter_no = '"+meter+"' AND month ='"+cmonth.getSelectedItem()+"'");
            while(rs.next())
            {
                labelunits.setText(rs.getString("units"));
                labeltotalbill.setText(rs.getString("totalbill"));
                labelstatus.setText(rs.getString("status"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        cmonth.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent ae)
            {
                try {
                    conn c = new conn();
                    ResultSet rs = c.s.executeQuery("select * from bill where meter_no = '"+meter+"' AND month ='"+cmonth.getSelectedItem()+"'");
                    while(rs.next())
                    {
                        labelunits.setText(rs.getString("units"));
                        labeltotalbill.setText(rs.getString("totalbill"));
                        labelstatus.setText(rs.getString("status"));
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        pay = new JButton("Pay");
        pay.setBounds(180, 460, 100, 25);
        pay.addActionListener(this);
        add(pay);

        back = new JButton("Back");
        back.setBounds(350, 460, 100, 25);
        back.addActionListener(this);
        add(back);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource()==pay)
        {
            try {
                conn c = new conn();
                c.s.executeUpdate("update bill set status = 'Paid' where meter_no = '"+meter+"'");
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
        else if(ae.getSource()==back)
        {
            setVisible(false);
        }
    }
    public static void main(String[] args) {
        new paybill("");
    }
}
