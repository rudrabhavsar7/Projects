package electricitybillsystem;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;

public class updateinformation extends JFrame implements ActionListener{
    JTextField tfaddress,tfcity,tfstate,tfemail,tfphone;
    JButton update,back;
    String meterno;
    JLabel name;
    updateinformation(String tfmeter)
    {
        meterno=tfmeter;
        setBounds(400, 200, 700, 400);
        setLayout(null);

        JLabel heading = new JLabel("Update Customer Information");
        heading.setBounds(200, 10, 500, 30);
        heading.setFont(new Font("Tahoma",Font.PLAIN,24));
        add(heading);

        JLabel lblname = new JLabel("Name");
        lblname.setBounds(30, 60, 100, 20);
        add(lblname);

        name = new JLabel("");
        name.setBounds(150, 60, 100, 20);
        add(name);

        JLabel lblmeter = new JLabel("Meter Number");
        lblmeter.setBounds(30, 100, 100, 20);
        add(lblmeter);

        JLabel meter = new JLabel("");
        meter.setText(tfmeter);
        meter.setBounds(150, 100, 100, 20);
        add(meter);

        JLabel lbladdress = new JLabel("Address");
        lbladdress.setBounds(30, 140, 100, 20);
        add(lbladdress);

        tfaddress = new JTextField();
        tfaddress.setBounds(150, 140, 200, 20);
        add(tfaddress);

        JLabel lblcity = new JLabel("City");
        lblcity.setBounds(30, 180, 100, 20);
        add(lblcity);

        tfcity = new JTextField();
        tfcity.setBounds(150, 180, 200, 20);
        add(tfcity);

        JLabel lblstate = new JLabel("State");
        lblstate.setBounds(30, 220, 100, 20);
        add(lblstate);

        tfstate = new JTextField();
        tfstate.setBounds(150, 220, 200, 20);
        add(tfstate);

        JLabel lblemail = new JLabel("Email");
        lblemail.setBounds(30, 260, 100, 20);
        add(lblemail);

        tfemail = new JTextField();
        tfemail.setBounds(150, 260, 200, 20);
        add(tfemail);

        JLabel lblphone = new JLabel("Phone");
        lblphone.setBounds(30, 300, 100, 20);
        add(lblphone);

        tfphone = new JTextField();
        tfphone.setBounds(150, 300, 200, 20);
        add(tfphone);

        update = new JButton("Update");
        update.setBounds(500, 150, 100, 20);
        update.addActionListener(this);
        add(update);

        back = new JButton("Back");
        back.setBounds(500, 180, 100, 20);
        back.addActionListener(this);
        add(back);

        try {
            conn c = new conn();

            String query = "select * from customer where meter_no = '"+meterno+"'";
            ResultSet rs = c.s.executeQuery(query);
            while(rs.next())
            {
                name.setText(rs.getString("name"));
                tfaddress.setText(rs.getString("address"));
                tfcity.setText(rs.getString("city"));
                tfstate.setText(rs.getString("state"));
                tfemail.setText(rs.getString("email"));
                tfphone.setText(rs.getString("phone"));
            }

            
        } catch (Exception e) {
            e.printStackTrace();
        }


        setVisible(true);
    }

    public void actionPerformed (ActionEvent ae)
    {
        if(ae.getSource() == update)
        {
            String address = tfaddress.getText();
            String city = tfcity.getText();
            String state = tfstate.getText();
            String email = tfemail.getText();
            String phone = tfphone.getText();

            try {
                conn c = new conn();
                c.s.executeUpdate("update customer set address = '"+address+"',city = '"+city+"',state = '"+state+"',email = '"+email+"',phone = '"+phone+"' where meter_no = '"+meterno+"'");

                JOptionPane.showMessageDialog(null, "User Information Updated Successfully");
                setVisible(false);
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
        new updateinformation("");
    }
}
