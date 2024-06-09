package com.example.cakehouse;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

public class Testing {
    @Test
    public void testInventoryDataList(){
        ArrayList<Unit> listData = LoginPageTest.inventoryDataList2();
        assertEquals(listData.get(0).getName(), "Cheesecake");
        assertEquals(listData.get(1).getName(),"Bubble Tea");
    }
    @Test
    public void testOrderDataList(){
        ArrayList<Unit> listData = LoginPageTest.orderDataList2();
        ArrayList<String> actualOrderFromAdmin = new ArrayList<>(Arrays.asList(
                "Cheesecake","Matcha Lava Cake","Cheesecake","Cheesecake",
                "Cheesecake","Cheesecake","Cheesecake"
        ));
        for(int i=0; i<listData.size();i++){
            assertEquals(listData.get(i).getName(),actualOrderFromAdmin.get(i));
        }
    }
    @Test
    public void testProductDataList(){
        ArrayList<Unit> listData = LoginPageTest.productDataList2();
        assertEquals(listData.get(0).getName(), "Cheesecake");
        assertEquals(listData.get(1).getName(),"Bubble Tea");
    }
    @Test
    public void testCalculateTotal2(){
        double testingTotalPrice = LoginPageTest.calculateTotal2();
        assertEquals(testingTotalPrice, 151.00);
    }
    @Test
    public void testReceiptDataList2(){
        ArrayList<Receipt> listData = LoginPageTest.receiptDataList2();
        assertEquals(listData.get(0).getId(), 1);
        assertEquals(listData.get(0).getUsername(), "A1");
        assertEquals(listData.get(0).getTotalprice(),151);
        assertEquals(listData.get(0).getPayment(),"TnG");
    }
    @Test
    public void testSurveyDataList2(){
        ArrayList<Survey> listData = LoginPageTest.surveyDataList2();
        assertEquals(listData.get(0).getId(), 1);
        assertEquals(listData.get(0).getUsername(), "Shuao");
        assertEquals(listData.get(0).getWay(),"Dine In");
        assertEquals(listData.get(0).getFood_quality(),"Average");
        assertEquals(listData.get(0).getOrder_accuracy(),"Good");
        assertEquals(listData.get(0).getCleanliness(),"Good");
        assertEquals(listData.get(0).getService_quality(),"Average");
        assertEquals(listData.get(0).getExperience(),"Average");
        assertEquals(listData.get(0).getComment(),"-");
    }
    @Test
    public void testCusOrderDataList2(){
        ArrayList<Unit> listData = LoginPageTest.cusOrderDataList2();
        assertEquals(listData.get(0).getName(), "Cheesecake");
        assertEquals(listData.get(0).getType(),"Cake");
    }
    @Test
    public void testCalculateTotalCus2(){
        double testingTotalPrice = LoginPageTest.calculateTotalCus2();
        assertEquals(testingTotalPrice, 16.90);
    }
    @Test
    public void testCusReceiptDataList2(){
        ArrayList<Receipt> listData = LoginPageTest.cusReceiptDataList2();
        assertEquals(listData.get(0).getId(), 1);
        assertEquals(listData.get(0).getUsername(), "C1");
        assertEquals(listData.get(0).getTotalprice(),16.90);
        assertEquals(listData.get(0).getPayment(),"TnG");
    }
    @Test
    public void testPersonalOrderDataList2(){
        ArrayList<Unit> listData = LoginPageTest.personalOrderDataList2();
        assertEquals(listData.get(0).getName(), "Bubble Tea");
        assertEquals(listData.get(1).getName(), "Tiramisu");
    }
}
