package com.java8.labbdas.exercises;

import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * public interface Supplier<T>{
 *
 *     T get() //gets a result
 * }
 *
 *
 */
public class Chapter1 {

    public static ThreadLocal<SimpleDateFormat> formatter
            = ThreadLocal.withInitial(()->new SimpleDateFormat("dd-MMM-yyy"));
    public static void main(String[] args) {

        Calendar cal = Calendar.getInstance() ;
        cal.set(Calendar.YEAR,1970);
        cal.set(Calendar.MONTH,Calendar.JANUARY);
        cal.set(Calendar.DAY_OF_MONTH,1);
        String format = formatter.get().format(cal.getTime());
        System.out.println(format);
    }
}
