package com.sri.utilities;

import org.joda.time.DateTime;

/**
 * Created by srinidhis on 22/08/16.
 */
public class TimeUtility {

    //Time Utility to get UTC time stamp
    public static long getUTCTimeStamp(String date){
        DateTime dateTime = new DateTime(date);
        return dateTime.getMillis();
    }

}
