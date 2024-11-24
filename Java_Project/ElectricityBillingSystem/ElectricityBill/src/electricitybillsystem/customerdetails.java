package electricitybillsystem;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;
import net.proteanit.sql.DbUtils;

public class customerdetails extends JFrame implements ActionListener{

    Choice meternumber,cmonth;
    JTable table;
    JButton search,print;
    conn c;

    customerdetails()
    {
        super("Customer Details");
        setSize(1200, 700);
        setLocation(200, 150);

        table = new JTable();

        try {
            c= new conn();
            ResultSet rs = c.s.executeQuery("select * from customer");
            table.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (Exception e) {
            e.printStackTrace();
        }

        JScrollPane sp = new JScrollPane(table);
        add(sp); 

        print = new JButton("Print");
        print.addActionListener(this);
        add(print,"South");

        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae)
    {
            try {
                table.print();
            } catch (Exception e) {
                e.printStackTrace();
            }
    }
    public static void main(String[] args) {
        new customerdetails();
    }
}
