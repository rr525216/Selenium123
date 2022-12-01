package com.functions.reTry;

import org.testng.*;

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
