package com.bilgeadam.soru1_jdbc.utils;

import java.sql.Connection;
import java.sql.DriverManager;

public class DB {
    private final String mysqlDriver = "com.mysql.cj.jdbc.Driver";
    private final String url = "jdbc:mysql://localhost:3307/marathon2_jdbc?useUnicode=true&useLegacyDatetimeCode=false&serverTimezone=Turkey&useSSL=false"; // jdbc:mysql://localhost:3307/student_jdbc

    private final String userName = "root";
    private final String userPass = "1234";

    public Connection connection = null;

    public DB() {
        try {
            Class.forName(mysqlDriver);
            connection = DriverManager.getConnection(url, userName, userPass);
            if(!connection.isClosed()) {
                System.out.println("Connection Success");
            }
        } catch (Exception e) {

        }
    }
}
