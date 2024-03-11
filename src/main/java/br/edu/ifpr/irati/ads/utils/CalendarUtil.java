package br.edu.ifpr.irati.ads.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class CalendarUtil {
  public Date addDays(Date actualDate, int incrementDays) {
    Calendar calendar = Calendar.getInstance();
    calendar.setTime(actualDate);
    calendar.add(Calendar.DAY_OF_MONTH, incrementDays);
    return calendar.getTime();
  }

  public Date getDateFormat(Date date) {
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
    String dataFormatada = simpleDateFormat.format(date);

    return new Date(dataFormatada);
  }

  public Date formatStringToDate(String dateString) {
    try {
      SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");

      if (dateString == null) {
        Date date = new Date();
        dateString = formatter.format(date);
      }

      return formatter.parse(dateString);
    } catch (ParseException e) {
      throw new RuntimeException(e);
    }
  }
}
