package electricitybillsystem;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Meterinfo extends JFrame implements ActionListener {
    JButton submit;
    JLabel lblmeter;
    Choice meterlocation, metertype, phasecode, billtype;
    String meterno;

    Meterinfo(String meter) {
        meterno = meter;
        setSize(700, 500);
        setLocation(400, 200);

        JPanel p = new JPanel();
        p.setLayout(null);
        p.setBackground(new Color(173, 216, 230));
        add(p);

        JLabel heading = new JLabel("Meter Information");
        heading.setBounds(270, 15, 200, 20);
        heading.setFont(new Font("Tahoma", Font.PLAIN, 24));
        p.add(heading);

        JLabel lblmeterno = new JLabel("Meter Number");
        lblmeterno.setBounds(170, 80, 100, 20);
        p.add(lblmeterno);

        lblmeter = new JLabel(meter);
        lblmeter.setBounds(310, 80, 200, 20);
        p.add(lblmeter);

        JLabel lblmeterloc = new JLabel("Meter Location");
        lblmeterloc.setBounds(170, 120, 100, 20);
        p.add(lblmeterloc);

        meterlocation = new Choice();
        meterlocation.add("Outside");
        meterlocation.add("Inside");
        meterlocation.setBounds(310, 120, 200, 20);
        p.add(meterlocation);

        JLabel lblmetertype = new JLabel("Meter Type");
        lblmetertype.setBounds(170, 160, 100, 20);
        p.add(lblmetertype);

        metertype = new Choice();
        metertype.add("Electric Meter");
        metertype.add("Solar Meter");
        metertype.add("Smart Meter");
        metertype.setBounds(310, 160, 200, 20);
        p.add(metertype);

        JLabel lblphasecode = new JLabel("Phase Code");
        lblphasecode.setBounds(170, 200, 100, 20);
        p.add(lblphasecode);

        phasecode = new Choice();
        phasecode.add("011");
        phasecode.add("022");
        phasecode.add("033");
        phasecode.add("044");
        phasecode.add("055");
        phasecode.add("066");
        phasecode.add("077");
        phasecode.add("088");
        phasecode.add("099");

        phasecode.setBounds(310, 200, 200, 20);
        p.add(phasecode);

        JLabel lblbilltype = new JLabel("Bill Type");
        lblbilltype.setBounds(170, 240, 100, 20);
        p.add(lblbilltype);

        billtype = new Choice();
        billtype.add("Normal");
        billtype.add("Industrial");
        billtype.setBounds(310, 240, 200, 20);
        p.add(billtype);

        JLabel lbldays = new JLabel("Days");
        lbldays.setBounds(170, 280, 100, 20);
        p.add(lbldays);

        JLabel days = new JLabel("30 Days");
        days.setBounds(310, 280, 100, 20);
        p.add(days);

        JLabel lblnote = new JLabel("Note");
        lblnote.setBounds(170, 320, 100, 20);
        p.add(lblnote);

        JLabel note = new JLabel("By Default Bill Is Calculated For 30 Days Only");
        note.setBounds(310, 320, 400, 20);
        p.add(note);

        submit = new JButton("Submit");
        submit.setBounds(310, 380, 100, 20);
        submit.addActionListener(this);
        p.add(submit);

        setLayout(new BorderLayout());
        add(p, "Center");
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == submit) {
            String meter = meterno;
            String location = meterlocation.getSelectedItem();
            String type = metertype.getSelectedItem();
            String code = phasecode.getSelectedItem();
            String typebill = billtype.getSelectedItem();
            String days = "30";

            String query = "insert into meter_info values('" + meter + "','" + location + "','" + type + "','" + code + "','" + typebill + "','" + days + "')";

            try {
                conn c = new conn();
                c.s.executeUpdate(query);

                JOptionPane.showMessageDialog(null, "Meter Information Added Successfully");
                setVisible(false);

            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new Meterinfo("");
    }

}
