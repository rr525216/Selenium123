package stepDef.utilities;

import com.functions.util.ConfigReader;
import com.functions.util.Reader;
import io.cucumber.java.Scenario;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.Map;
import java.util.Properties;

import static com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter.addTestStepLog;

public class testCount {

    public static Map<String, String> TestDataInMap;

    public static Properties prop;

    public static void counter(Scenario scenario){

        Collection<String> tags = scenario.getSourceTagNames();

        System.out.println(tags);

        for (String tag:tags){

           if(tag.equals("@123")){
               updateTheSheet("naveen");
           }
            else if(tag.equals("@reddy")){
                updateTheSheet("reddy");
            }

        }

    }


    public static void updateTheSheet(String sheetname){


        Date date = new Date();
        DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        String today = dateFormat.format(date);
        System.out.println("today : "+ today);

        //GET
        TestDataInMap = Reader.getTestdataInmap(sheetname,today);
        System.out.println(TestDataInMap.get("Date"));
        System.out.println(TestDataInMap.get("Count"));

        String dateCount = TestDataInMap.get("Date");
        String testname =TestDataInMap.get("Count");

        //INSERT
        if(dateCount == null){
            addTestStepLog("My Date : " +today);
            TestDataInMap = Reader.insertTestdataInmap(sheetname,today);
            ConfigReader.getConfigValue("SheetName");
            ConfigReader.getConfigValue("MyCount");
            addTestStepLog("SheetName : " +ConfigReader.getConfigValue("SheetName") + " MyCount :" +ConfigReader.getConfigValue("MyCount"));
            System.out.println("SheetName : " +ConfigReader.getConfigValue("SheetName") + " MyCount : " +ConfigReader.getConfigValue("MyCount"));
        }
        //UPDATE
        else if (dateCount != null){
            addTestStepLog("My Date : " +today);
            TestDataInMap = Reader.UpdateTestdataInmap( sheetname,testname, today);
            ConfigReader.getConfigValue("SheetName");
            ConfigReader.getConfigValue("MyCount");
            addTestStepLog("SheetName : " +ConfigReader.getConfigValue("SheetName") + " MyCount : " +ConfigReader.getConfigValue("MyCount"));
            System.out.println("SheetName : " +ConfigReader.getConfigValue("SheetName") + " MyCount : " +ConfigReader.getConfigValue("MyCount"));

        }

    }
}
