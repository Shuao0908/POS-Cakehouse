package com.example.cakehouse;

import java.sql.Connection;
import java.sql.DriverManager;


public class DataTesting {
    public String inventory_name;
    public String path;
    public String date;
    public Integer id;
    public Integer inventory_stock;
    public Double inventory_price;
    public Connection connectDB() {
        try {
            Class.forName("com.mysql.jdbc.Driver");

            Connection connect = DriverManager.getConnection("jdbc:mysql://localhost/cakehouse", "root", "");
            return connect;

        } catch (Exception e) {e.printStackTrace();}
        return null;
    }
}
