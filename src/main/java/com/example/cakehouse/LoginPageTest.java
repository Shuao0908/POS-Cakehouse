package com.example.cakehouse;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.Array;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.concurrent.CopyOnWriteArrayList;

import static org.junit.jupiter.api.Assertions.*;

class LoginPageTest {
    public static DataTesting data = new DataTesting();
    public static ArrayList<Unit> inventoryDataList2(){
        ArrayList<com.example.cakehouse.Unit> listData = new ArrayList<>();
        String sql = "SELECT * FROM `inventory`";
        Connection connect2 = data.connectDB();
        try{
            PreparedStatement prepare2 = connect2.prepareStatement(sql);
            ResultSet result2 = prepare2.executeQuery();
            com.example.cakehouse.Unit unit;
            while(result2.next()){
                unit = new com.example.cakehouse.Unit(result2.getString("id"),
                        result2.getString("name"),
                        result2.getString("type"),
                        result2.getInt("stock"),
                        result2.getDouble("price"),
                        result2.getString("status"),
                        result2.getString("image"),
                        result2.getDate("date"));
                listData.add(unit);
            }
        }catch(Exception e){e.printStackTrace();}
        return listData;
    }
    public static ArrayList<Unit> orderDataList2(){
        int orderID = 1;
        ArrayList<Unit> listData = new ArrayList<>();
        String sql = "SELECT * FROM `order` WHERE `order_id`='"+orderID+"'";
        Connection connect2 = data.connectDB();
        try{
            PreparedStatement prepare2 = connect2.prepareStatement(sql);
            ResultSet result2 = prepare2.executeQuery();
            Unit u1;
            while(result2.next()){
                u1 = new Unit(result2.getString("id"),
                        result2.getString("name"),
                        result2.getString("type"),
                        result2.getInt("quantity"),
                        result2.getDouble("price"),
                        result2.getString("image"));
                listData.add(u1);
            }
        }catch(Exception e){e.printStackTrace();}
        return listData;
    }
    public static ArrayList<Unit> productDataList2(){
        String sql = "SELECT * FROM `inventory`";
        Connection connect2 = data.connectDB();
        ArrayList<Unit> listData = new ArrayList<>();
        try{
            PreparedStatement prepare2 = connect2.prepareStatement(sql);
            ResultSet result2 = prepare2.executeQuery();
            Unit u1;
            while(result2.next()){
                u1 = new Unit(result2.getString("id"),
                        result2.getString("name"),
                        result2.getString("type"),
                        0,
                        result2.getDouble("price"),
                        result2.getString("image"));
                listData.add(u1);
            }
        }catch(Exception e){e.printStackTrace();}
        return listData;
    }
    public  static double calculateTotal2(){
        double totalPriceOfOrder = 0;
        int orderID =1;
        String checkTotal = "SELECT SUM(price) FROM `order` WHERE order_id ='" +orderID+"'";
        Connection connect2 = data.connectDB();
        try{
            PreparedStatement prepare2 = connect2.prepareStatement(checkTotal);
            ResultSet result2 = prepare2.executeQuery();

            if(result2.next()){
                totalPriceOfOrder =result2.getDouble("SUM(price)");
//                total.setText("$"+ df.format(totalPriceOfOrder));
            }
        }catch (Exception e){ e.printStackTrace(); }
        return totalPriceOfOrder;
    }
    public static ArrayList<Receipt> receiptDataList2(){
        String sql = "SELECT * FROM `receipt`";
        Connection connect2 = data.connectDB();
        ArrayList<Receipt> listData = new ArrayList<>();
        try{
            PreparedStatement prepare2 = connect2.prepareStatement(sql);
            ResultSet result2 = prepare2.executeQuery();
            Receipt r1;
            while(result2.next()){
                r1 = new Receipt(result2.getInt("order_id"),
                        result2.getString("userName"),
                        result2.getDouble("total"),
                        result2.getString("paymentMethod"),
                        result2.getDate("date"));
                listData.add(r1);
            }
        }catch(Exception e){e.printStackTrace();}

        String sql2 = "SELECT * FROM `cus_receipt`";
        try{
            PreparedStatement prepare2 = connect2.prepareStatement(sql2);
            ResultSet result2 = prepare2.executeQuery();
            Receipt r1;
            while(result2.next()){
                r1 = new Receipt(result2.getInt("order_id"),
                        result2.getString("userName"),
                        result2.getDouble("total"),
                        result2.getString("paymentMethod"),
                        result2.getDate("date"));
                listData.add(r1);
            }
        }catch(Exception e){e.printStackTrace();}
        return listData;
    }
    public static ArrayList<Survey> surveyDataList2(){
        String sql = "SELECT * FROM `survey`";
        Connection connect2 = data.connectDB();
        ArrayList<Survey> listData = new ArrayList<>();
        try{
            PreparedStatement prepare2 = connect2.prepareStatement(sql);
            ResultSet result2 = prepare2.executeQuery();
            Survey s1;
            while(result2.next()){
                s1 = new Survey(result2.getInt("id"),
                        result2.getString("userName"),
                        result2.getString("way"),
                        result2.getString("food_quality"),
                        result2.getString("order_accuracy"),
                        result2.getString("cleanliness"),
                        result2.getString("service_quality"),
                        result2.getString("experience"),
                        result2.getString("comment"),
                        result2.getDate("date"));
                listData.add(s1);
            }
        }catch(Exception e){e.printStackTrace();}
        return listData;
    }
    public static ArrayList<Unit> cusOrderDataList2(){
        int orderID =1;
        ArrayList<Unit> listData = new ArrayList<>();
        String sql = "SELECT * FROM `cus_order` WHERE `order_id`='"+orderID+"'";
        Connection connect2 = data.connectDB();
        try{
            PreparedStatement prepare2 = connect2.prepareStatement(sql);
            ResultSet result2 = prepare2.executeQuery();
            Unit u1;
            while(result2.next()){
                u1 = new Unit(result2.getString("id"),
                        result2.getString("name"),
                        result2.getString("type"),
                        result2.getInt("quantity"),
                        result2.getDouble("price"),
                        result2.getString("image"));
                listData.add(u1);
            }
        }catch(Exception e){e.printStackTrace();}
        return listData;
    }
    public static double calculateTotalCus2(){
        double totalPriceOfOrder2 = 0;
        int orderID =1;
        String checkTotal = "SELECT SUM(price) FROM `cus_order` WHERE order_id ='" +orderID+"'";
        Connection connect2 = data.connectDB();
        try{
            PreparedStatement prepare2 = connect2.prepareStatement(checkTotal);
            ResultSet result2 = prepare2.executeQuery();

            if(result2.next()){
                totalPriceOfOrder2 =result2.getDouble("SUM(price)");
//                total2.setText("$"+ df.format(totalPriceOfOrder2));
            }
        }catch (Exception e){ e.printStackTrace(); }
        return totalPriceOfOrder2;
    }
    public static ArrayList<Receipt> cusReceiptDataList2(){
        Connection connect2 = data.connectDB();
        ArrayList<Receipt> listData = new ArrayList<>();
        String u="C1";
        String sql2 = "SELECT * FROM `cus_receipt` WHERE userName = '"+u+"'";
        try{
            PreparedStatement prepare2 = connect2.prepareStatement(sql2);
            ResultSet result2 = prepare2.executeQuery();
            Receipt r1;
            while(result2.next()){
                r1 = new Receipt(result2.getInt("order_id"),
                        result2.getString("userName"),
                        result2.getDouble("total"),
                        result2.getString("paymentMethod"),
                        result2.getDate("date"));
                listData.add(r1);
            }
        }catch(Exception e){e.printStackTrace();}
        return listData;
    }
    public static ArrayList<Unit> personalOrderDataList2(){
        ArrayList<Unit> listData = new ArrayList<>();
        data.id =2;
        if(data.id != null ){
//            Alert a = new Alert(Alert.AlertType.ERROR);
//            a.setTitle("Error Message");
//            a.setHeaderText(null);
//            a.setContentText("Please select an order history!");
//            a.showAndWait();
//        } else {
            String sql = "SELECT * FROM `cus_order` WHERE `order_id`='" + data.id + "'";
            Connection connect2 = data.connectDB();
            try {
                PreparedStatement prepare2 = connect2.prepareStatement(sql);
                ResultSet result2 = prepare2.executeQuery();
                Unit u1;
                while (result2.next()) {
                    u1 = new Unit(result2.getString("id"),
                            result2.getString("name"),
                            result2.getString("type"),
                            result2.getInt("quantity"),
                            result2.getDouble("price"),
                            result2.getString("image"));
                    listData.add(u1);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return listData;
    }
}