package com.bikash.springjpa.utility;

import java.text.SimpleDateFormat;
import java.util.Date;


public class DateUtility {


    public String formatDate(String date)
    {
        String pattern = "MM-dd-yyyy";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        date = simpleDateFormat.format(new Date());
        return date;

    }



}
