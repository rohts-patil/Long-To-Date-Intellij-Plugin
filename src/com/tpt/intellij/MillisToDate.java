package com.tpt.intellij;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MillisToDate {
  public static String convert(long currentDateTime) {

    Date currentDate = new Date(currentDateTime);

    System.out.println("current Date: " + currentDate);

    DateFormat df = new SimpleDateFormat("EEE, d MMM yyyy HH:mm:ss Z");
    return "Milliseconds: " + currentDateTime + "\nDate: " + df.format(currentDate);
    // return "Milliseconds: " + currentDateTime + "\nDate: " + currentDate.toString();
    // return "Milliseconds to Date: " + df.format(currentDate);
  }
}
