package stepDef.utilities;

import com.functions.util.*;
import io.cucumber.java.Scenario;
import java.text.*;
import java.util.*;

import static com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter.addTestStepLog;

public class testCount {

    public static Map<String, String> TestDataInMap;

    public static Properties prop;

    private Reader reader= Reader.getInstance();

    private ConfigReader configReader = ConfigReader.getInstance();
    private screenShot screenshot = screenShot.getInstance();

    private static testCount count = null;

    public testCount() {
    }

    public static testCount getInstance() {

        if (count == null) {
            count = new testCount();
        }
        return count;
    }

    public void counter(Scenario scenario){

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


    public  void updateTheSheet(String sheetname){


        Date date = new Date();
        DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        String today = dateFormat.format(date);
        System.out.println("today : "+ today);

        //GET
        TestDataInMap = reader.getTestdataInmap(sheetname,today);
        System.out.println(TestDataInMap.get("Date"));
        System.out.println(TestDataInMap.get("Count"));

        String dateCount = TestDataInMap.get("Date");
        String testname =TestDataInMap.get("Count");

        //INSERT
        if(dateCount == null){
            addTestStepLog("My Date : " +today);
            screenshot.fieldname("My Date : " +today);
            TestDataInMap = reader.insertTestdataInmap(sheetname,today);
            configReader.getConfigValue("SheetName");
            configReader.getConfigValue("MyCount");
            addTestStepLog("SheetName : " +configReader.getConfigValue("SheetName") + " MyCount :" +ConfigReader.getConfigValue("MyCount"));
            System.out.println("SheetName : " +configReader.getConfigValue("SheetName") + " MyCount : " +ConfigReader.getConfigValue("MyCount"));
            screenshot.fieldname("SheetName : " +configReader.getConfigValue("SheetName") + " MyCount : " +ConfigReader.getConfigValue("MyCount"));
        }
        //UPDATE
        else if (dateCount != null){
            addTestStepLog("My Date : " +today);
            TestDataInMap = reader.UpdateTestdataInmap( sheetname,testname, today);
            configReader.getConfigValue("SheetName");
            configReader.getConfigValue("MyCount");
            addTestStepLog("SheetName : " +configReader.getConfigValue("SheetName") + " MyCount : " +ConfigReader.getConfigValue("MyCount"));
            System.out.println("SheetName : " +configReader.getConfigValue("SheetName") + " MyCount : " +ConfigReader.getConfigValue("MyCount"));
            screenshot.fieldname("SheetName : " +configReader.getConfigValue("SheetName") + " MyCount : " +ConfigReader.getConfigValue("MyCount"));

        }

    }
}
