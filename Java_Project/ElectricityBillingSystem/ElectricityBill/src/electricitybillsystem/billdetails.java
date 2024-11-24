package electricitybillsystem;

import java.sql.*;
import javax.swing.*;
import net.proteanit.sql.*;

public class billdetails extends JFrame{
    String meter;
    billdetails(String meter)
    {
        this.meter=meter;
        setBounds(400,150,700,650);
        setLayout(null);
        setVisible(true);

        JTable table = new JTable();
        try {
            conn c = new conn();
            String query = "select * from bill where meter_no = '"+meter+"'";
            ResultSet rs = c.s.executeQuery(query);

            table.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (Exception e) {
            e.printStackTrace();
        }

        JScrollPane sp = new JScrollPane(table);
        sp.setBounds(0, 0, 700, 650);
        add(sp);
    }
    public static void main(String[] args) {
        new billdetails("");
    }
}
