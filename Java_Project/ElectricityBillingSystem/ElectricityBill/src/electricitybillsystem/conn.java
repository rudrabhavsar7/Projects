package electricitybillsystem;

import java.sql.*;

public class conn {
    Statement s;
    Connection c;

    conn() {
        try {
            c = DriverManager.getConnection("jdbc:mysql://localhost:3306/ebs", "root", "0@0a2AA2");
            s = c.createStatement();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new conn();
    }
}
