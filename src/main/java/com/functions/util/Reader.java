package com.functions.util;

import com.codoid.products.exception.FilloException;
import com.codoid.products.fillo.Connection;
import com.codoid.products.fillo.Fillo;
import com.codoid.products.fillo.Recordset;

import java.util.Map;
import java.util.TreeMap;

public class Reader {

        public static  Map<String,String> getTestdataInmap(String sheetname,String date){

            Map<String,String> TestDatainMap = new TreeMap<String,String>();
            String query = "SELECT * FROM "+sheetname+" WHERE Date= '"+date+"'";
            String filePath = ConfigReader.getValue("testPath");
            try {
                Fillo fillo = new Fillo();
                Connection connection = fillo.getConnection(filePath);
                Recordset recordset = connection.executeQuery(query);
                while (recordset.next()) {

                    for (String field : recordset.getFieldNames()) {
                       TestDatainMap.put(field,recordset.getField(field));
                    }
                }
                recordset.close();
                connection.close();
            } catch (FilloException e) {
               // e.printStackTrace();
            } catch (Throwable e) {
               // e.printStackTrace();
            }

            return TestDatainMap;
        }

    public static  Map<String,String> UpdateTestdataInmap(String sheetname,String counter,String date){

        Map<String,String> TestDatainMap = new TreeMap<String,String>();

        int count=Integer.parseInt(counter);
        int counts=count+1;

        String query = "Update "+sheetname+" Set Count='"+counts+"' where Date ='"+date+"'";
        String filePath = ConfigReader.getValue("testPath");
        try {
            Fillo fillo = new Fillo();
            Connection connection = fillo.getConnection(filePath);
            connection.executeUpdate(query);
            connection.close();
        } catch (FilloException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        String ct=String.valueOf(counts);
        ConfigReader.setConfigValue("SheetName",sheetname);
        ConfigReader.setConfigValue("MyCount",ct);
        return TestDatainMap;
    }

    public static  Map<String,String> insertTestdataInmap(String sheetname,String date){

        Map<String,String> TestDatainMap = new TreeMap<String,String>();
        String query = "INSERT INTO "+sheetname+" (Date,Count) VALUES ('"+date+"','1')";
        String filePath = ConfigReader.getValue("testPath");
        try {
            Fillo fillo = new Fillo();
            Connection connection = fillo.getConnection(filePath);
            connection.executeUpdate(query);
            connection.close();
        } catch (FilloException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
      //  addTestStepLog("SheetName : " + sheetname +  " My Count : " + 1 );
        ConfigReader.setConfigValue("SheetName",sheetname);
        ConfigReader.setConfigValue("MyCount","1");
        return TestDatainMap;
    }


}


