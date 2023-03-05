package com.example.geektrust.utility;

import com.example.geektrust.constant.ExceptionMessage;
import com.example.geektrust.constant.StaticConstantValue;
import com.example.geektrust.exception.InvalidDateException;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class DateUtility {

    private DateUtility(){

    }

    public static LocalDate convertStringToDate(String stringDate){

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(StaticConstantValue.DATE_FORMAT);
        formatter.withLocale(Locale.ENGLISH);
        LocalDate date;
        try {
            date = LocalDate.parse(stringDate,formatter);
        }catch (Exception e){
            throw new InvalidDateException(ExceptionMessage.INVALID_DATE);
        }

        return date;

    }


    public static void isValidDate(LocalDate date){
        Calendar calendar = Calendar.getInstance();

        calendar.setTime(Date.from(date.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant()));

        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH) + 1; // add 1 to match the range 1-12
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        if (year <= 0 || month > 12 || day > calendar.getActualMaximum(Calendar.DAY_OF_MONTH)) {
            throw new InvalidDateException(ExceptionMessage.INVALID_DATE);
        }

    }

}
