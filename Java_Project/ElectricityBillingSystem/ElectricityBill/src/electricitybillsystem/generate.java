package electricitybillsystem;

import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
import javax.swing.*;

public class generate extends JFrame implements ActionListener {
    String meter;
    Choice cmonth;
    JButton bill;
    JLabel heading,tfname, tfaddress, tfcity, tfstate, tfemail, tfphoneno,blank,blank2,blank3,blank4,blank5,meterlocation,metertype,phasecode,billtype,days,cost_per_unit,meterrent,service_charge,service_tax,swacchbharat,fixedtax,month,units,total;
    JLabel name, address, city, state, email, phoneno,location,typemeter,code,typebill,day,cost,rent,charge,tax,swacchbharat_tax,fixed_tax,monthinfo,consumedunit,totalbill;

    generate(String meter) {
        this.meter = meter;
        setLayout(null);
        setBounds(550, 30, 500, 800);

        heading = new JLabel("Generate Bill");
        heading.setBounds(140, 5, 140, 20);
        heading.setFont(new Font("Tahoma", Font.BOLD, 20));
        add(heading);

        JLabel meternumber = new JLabel("Meter Number : " + meter);
        meternumber.setBounds(10, 50, 500,20);
        meternumber.setFont(new Font("Tahoma", Font.BOLD, 14));
        add(meternumber);

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
        cmonth.setBounds(280, 5, 100, 20);
        add(cmonth);

        blank = new JLabel("---------------------------------------------------------------------------------------------------------------------");
        blank.setBounds(10, 70, 500, 20);
        add(blank);

        tfname = new JLabel("Name");
        tfname.setBounds(10, 90, 500,20);
        tfname.setFont(new Font("Tahoma", Font.BOLD, 14));
        add(tfname);

        name = new JLabel("");
        name.setBounds(180, 90, 500,20);
        name.setFont(new Font("SansSarif", Font.BOLD, 14));
        add(name);

        tfaddress = new JLabel("Address");
        tfaddress.setBounds(10, 110, 500,20);
        tfaddress.setFont(new Font("Tahoma", Font.BOLD, 14));
        add(tfaddress);

        address = new JLabel("");
        address.setBounds(180, 110, 500,20);
        address.setFont(new Font("SansSarif", Font.BOLD, 14));
        add(address);

        tfcity = new JLabel("City");
        tfcity.setBounds(10, 130, 500,20);
        tfcity.setFont(new Font("Tahoma", Font.BOLD, 14));
        add(tfcity);

        city = new JLabel("");
        city.setBounds(180, 130, 500,20);
        city.setFont(new Font("SansSarif", Font.BOLD, 14));
        add(city);

        tfstate = new JLabel("State");
        tfstate.setBounds(10, 150, 500,20);
        tfstate.setFont(new Font("Tahoma", Font.BOLD, 14));
        add(tfstate);

        state = new JLabel("");
        state.setBounds(180, 150, 500,20);
        state.setFont(new Font("SansSarif", Font.BOLD, 14));
        add(state);

        tfemail = new JLabel("Email");
        tfemail.setBounds(10, 170, 500,20);
        tfemail.setFont(new Font("Tahoma", Font.BOLD, 14));
        add(tfemail);

        email = new JLabel("");
        email.setBounds(180, 170, 500,20);
        email.setFont(new Font("SansSarif", Font.BOLD, 14));
        add(email);

        tfphoneno = new JLabel("Phone No");
        tfphoneno.setBounds(10, 190, 500,20);
        tfphoneno.setFont(new Font("Tahoma", Font.BOLD, 14));
        add(tfphoneno);

        phoneno = new JLabel("");
        phoneno.setBounds(180, 190, 500,20);
        phoneno.setFont(new Font("SansSarif", Font.BOLD, 14));
        add(phoneno);

        blank2 = new JLabel("---------------------------------------------------------------------------------------------------------------------");
        blank2.setBounds(10, 210, 500, 20);
        add(blank2);
        
        meterlocation = new JLabel("Meter Location");
        meterlocation.setBounds(10, 230, 500,20);
        meterlocation.setFont(new Font("Tahoma", Font.BOLD, 14));
        add(meterlocation);

        location = new JLabel("");
        location.setBounds(180, 230, 500,20);
        location.setFont(new Font("SansSarif", Font.BOLD, 14));
        add(location);

        metertype = new JLabel("Meter Type");
        metertype.setBounds(10, 250, 500,20);
        metertype.setFont(new Font("Tahoma", Font.BOLD, 14));
        add(metertype);

        typemeter = new JLabel("");
        typemeter.setBounds(180, 250, 500,20);
        typemeter.setFont(new Font("SansSarif", Font.BOLD, 14));
        add(typemeter);

        phasecode = new JLabel("Phase Code");
        phasecode.setBounds(10, 270, 500,20);
        phasecode.setFont(new Font("Tahoma", Font.BOLD, 14));
        add(phasecode);

        code = new JLabel("");
        code.setBounds(180, 270, 500,20);
        code.setFont(new Font("SansSarif", Font.BOLD, 14));
        add(code);

        billtype = new JLabel("Bill Type");
        billtype.setBounds(10, 290, 500,20);
        billtype.setFont(new Font("Tahoma", Font.BOLD, 14));
        add(billtype);

        typebill = new JLabel("");
        typebill.setBounds(180, 290, 500,20);
        typebill.setFont(new Font("SansSarif", Font.BOLD, 14));
        add(typebill);

        days = new JLabel("Days");
        days.setBounds(10, 310, 500,20);
        days.setFont(new Font("Tahoma", Font.BOLD, 14));
        add(days);

        day = new JLabel("");
        day.setBounds(180, 310, 500,20);
        day.setFont(new Font("SansSarif", Font.BOLD, 14));
        add(day);
        
        blank3 = new JLabel("--------------------------------------------------------------------------------------------------------------------");
        blank3.setBounds(10, 330, 500, 20);
        add(blank3);

        cost_per_unit = new JLabel("Cost Per Unit");
        cost_per_unit.setBounds(10, 350, 500,20);
        cost_per_unit.setFont(new Font("Tahoma", Font.BOLD, 14));
        add(cost_per_unit);

        cost = new JLabel("");
        cost.setBounds(180, 350, 500,20);
        cost.setFont(new Font("SansSarif", Font.BOLD, 14));
        add(cost);

        meterrent = new JLabel("Meter Rent");
        meterrent.setBounds(10, 370, 500,20);
        meterrent.setFont(new Font("Tahoma", Font.BOLD, 14));
        add(meterrent);

        rent = new JLabel("");
        rent.setBounds(180, 370, 500,20);
        rent.setFont(new Font("SansSarif", Font.BOLD, 14));
        add(rent);

        service_charge = new JLabel("Service Charge");
        service_charge.setBounds(10, 390, 500,20);
        service_charge.setFont(new Font("Tahoma", Font.BOLD, 14));
        add(service_charge);

        charge = new JLabel("");
        charge.setBounds(180, 390, 500,20);
        charge.setFont(new Font("SansSarif", Font.BOLD, 14));
        add(charge);

        service_tax = new JLabel("Service Tax");
        service_tax.setBounds(10, 410, 500,20);
        service_tax.setFont(new Font("Tahoma", Font.BOLD, 14));
        add(service_tax);

        tax = new JLabel("");
        tax.setBounds(180, 410, 500,20);
        tax.setFont(new Font("SansSarif", Font.BOLD, 14));
        add(tax);

        swacchbharat = new JLabel("Swacch Bharat CESS");
        swacchbharat.setBounds(10, 430, 500,20);
        swacchbharat.setFont(new Font("Tahoma", Font.BOLD, 14));
        add(swacchbharat);

        swacchbharat_tax = new JLabel("");
        swacchbharat_tax.setBounds(180, 430, 500,20);
        swacchbharat_tax.setFont(new Font("SansSarif", Font.BOLD, 14));
        add(swacchbharat_tax);

        fixedtax = new JLabel("Fixed Tax");
        fixedtax.setBounds(10, 450, 500,20);
        fixedtax.setFont(new Font("Tahoma", Font.BOLD, 14));
        add(fixedtax);

        fixed_tax = new JLabel("");
        fixed_tax.setBounds(180, 450, 500,20);
        fixed_tax.setFont(new Font("SansSarif", Font.BOLD, 14));
        add(fixed_tax);

        blank4 = new JLabel("--------------------------------------------------------------------------------------------------------------------");
        blank4.setBounds(10, 470, 500, 20);
        add(blank4);

        month = new JLabel("Month");
        month.setBounds(10, 490, 500,20);
        month.setFont(new Font("Tahoma", Font.BOLD, 14));
        add(month);

        monthinfo = new JLabel("");
        monthinfo.setBounds(180, 490, 500,20);
        monthinfo.setFont(new Font("SansSarif", Font.BOLD, 14));
        add(monthinfo);

        units = new JLabel("Consumed Units");
        units.setBounds(10, 510, 500,20);
        units.setFont(new Font("Tahoma", Font.BOLD, 14));
        add(units);

        consumedunit = new JLabel("");
        consumedunit.setBounds(180, 510, 500,20);
        consumedunit.setFont(new Font("SansSarif", Font.BOLD, 14));
        add(consumedunit);

        blank5 = new JLabel("--------------------------------------------------------------------------------------------------------------------");
        blank5.setBounds(10, 530, 500, 20);
        add(blank5);

        total = new JLabel("Total Bill");
        total.setBounds(10, 550, 500,20);
        total.setFont(new Font("Tahoma", Font.BOLD, 14));
        add(total);

        totalbill = new JLabel("");
        totalbill.setBounds(180, 550, 500,20);
        totalbill.setFont(new Font("SansSarif", Font.BOLD, 14));
        add(totalbill);

        bill = new JButton("Generate Bill");
        bill.setBounds(0,730, 500, 30);
        bill.addActionListener(this);
        add(bill);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        try {
            heading.setText("MGVCL");
            heading.setBounds(200, 5, 140, 20);
            cmonth.hide();
            conn c = new conn();
            
            String month = cmonth.getSelectedItem();

            ResultSet rs = c.s.executeQuery("select * from customer where meter_no = '"+meter+"'");
            while(rs.next())
            {
                name.setText(" : "+rs.getString("name"));
                address.setText(" : "+rs.getString("address"));
                city.setText(" : "+rs.getString("city"));
                state.setText(" : "+rs.getString("state"));
                email.setText(" : "+rs.getString("email"));
                phoneno.setText(" : "+rs.getString("phone"));
            }
            
            rs = c.s.executeQuery("select * from meter_info where meter_no = '"+meter+"'");
            while(rs.next())
            {
                location.setText(" : "+rs.getString("meter_location"));
                typemeter.setText(" : "+rs.getString("meter_type"));
                code.setText(" : "+rs.getString("phase_code"));
                typebill.setText(" : "+rs.getString("bill_type"));
                day.setText(" : "+rs.getString("days"));
            }

            rs = c.s.executeQuery("select * from tax");
            while(rs.next())
            {
                cost.setText(" : "+rs.getString("cost_per_unit"));
                rent.setText(" : "+rs.getString("meter_rent"));
                charge.setText(" : "+rs.getString("service_charge"));
                tax.setText(" : "+rs.getString("service_tax"));
                swacchbharat_tax.setText(" : "+rs.getString("swacch_bharat_cess"));
                fixed_tax.setText(" : "+rs.getString("fixed_tax"));
            }

            rs = c.s.executeQuery("select * from bill where meter_no = '"+meter+"'");
            while(rs.next())
            {
                monthinfo.setText(" : "+rs.getString("month"));
                consumedunit.setText(" : "+rs.getString("units"));
                totalbill.setText(" : "+rs.getString("totalbill"));
            }
            bill.hide();

            }
         catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        new generate("");
    }
}

