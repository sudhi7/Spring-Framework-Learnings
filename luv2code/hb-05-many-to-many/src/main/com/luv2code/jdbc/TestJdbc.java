package com.luv2code.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class TestJdbc {
    public static void main(String[] args) {

        String jdbcUrl = "jdbc:mysql://localhost:3306/hb-05-many-to-many?useSSL=false&serverTimezone=UTC";
        String user = "hbstudent";
        String pass = "Hbstudent@123";

        try {
            System.out.println("Connecting to database " + jdbcUrl);
            Connection muCon = DriverManager.getConnection(jdbcUrl, user, pass);

            System.out.println("Connection successfull");
        }
        catch (Exception e) {
            e.printStackTrace();
        }

    }
}
