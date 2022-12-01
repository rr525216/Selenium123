package com.functions.util;

import com.codoid.products.exception.FilloException;
import com.codoid.products.fillo.*;
import java.util.*;


public class Reader {

    private ConfigReader configReader = ConfigReader.getInstance();
    private static Reader reader = null;

    public Reader() {
    }

    public static Reader getInstance() {

        if (reader == null) {
            reader = new Reader();
        }
        return reader;
    }



        public   Map<String,String> getTestdataInmap(String sheetname,String date){

            Map<String,String> TestDatainMap = new TreeMap<String,String>();
            String query = "SELECT * FROM "+sheetname+" WHERE Date= '"+date+"'";
            String filePath = configReader.getValue("testPath");
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
            }
//            catch (FilloException e) {
//               // e.printStackTrace();
//            }
            catch (Throwable e) {
               // e.printStackTrace();
            }

            return TestDatainMap;
        }

    public  Map<String,String> UpdateTestdataInmap(String sheetname,String counter,String date){

        Map<String,String> TestDatainMap = new TreeMap<String,String>();

        int count=Integer.parseInt(counter);
        int counts=count+1;

        String query = "Update "+sheetname+" Set Count='"+counts+"' where Date ='"+date+"'";
        String filePath = configReader.getValue("testPath");
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

    public  Map<String,String> insertTestdataInmap(String sheetname,String date){

        Map<String,String> TestDatainMap = new TreeMap<String,String>();
        String query = "INSERT INTO "+sheetname+" (Date,Count) VALUES ('"+date+"','1')";
        String filePath = configReader.getValue("testPath");
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


