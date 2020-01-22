package com.tpt.intellij;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class MillisToDate {

  public static String convert(long currentDateTime, TimeZone timeZone) {

    Date currentDate = new Date(currentDateTime);

    System.out.println("current Date: " + currentDate);

    DateFormat df = new SimpleDateFormat("EEE, d MMM yyyy HH:mm:ss Z");
    df.setTimeZone(timeZone);

    return "Milliseconds: " + currentDateTime + "\nDate: " + df.format(currentDate);
  }
}
