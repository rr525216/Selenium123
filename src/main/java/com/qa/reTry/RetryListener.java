package com.qa.reTry;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryListener implements IRetryAnalyzer {

    int failedCount =0;
    int Limit=2;

    @Override
    public boolean retry(ITestResult result) {

        if (failedCount<Limit){
            failedCount++;
            return true;
        }
        return false;
    }
}
