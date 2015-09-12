package com.corejava.exercises;


import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;
import java.util.Arrays;
import java.util.Date;
import java.util.Locale;
import java.util.function.Predicate;

/**
 * Created by xue on 15/8/22.
 */
public class Main {

    public static void main(String[] args) throws CloneNotSupportedException, ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchFieldException {

        Manger boss = new Manger("Cracke Harryr",80000,1987,12,15) ;
        boss.setBonus(5000);


        Employee[] staff = new Employee[3] ;

        staff[0] = boss ;
        staff[1] = new Employee("Harry Hacker", 50000 , 1989, 10 ,1) ;
        staff[2] = new Employee("Tommy Tester", 40000 , 1990 , 3 ,15) ;

//        for (Employee e:staff)
//            System.out.println(e.getName() + " " + e.getSalary() + " " + e.getHireDay());
//        System.out.println();

//        if (a instanceof Manger){
//            Manger b = (Manger)a ;
//            b.setBonus(50000);
//            System.out.println(b.getName() + " " + b.getSalary());
//        }
        Arrays.sort(staff);
//       for (Employee e:staff)
//            System.out.println(e.toString());




        Employee[] xue = new Employee[3] ;
        for (int i = 0;i<staff.length;i++){
            xue[i] = staff[i].clone() ;
        }
        xue[1].setHireDay(new Date());
        Manger rt = new Manger("fsfs",89999,1990,5,12) ;



        Employee a = new Employee("Hunt Xue",400000,1990,8,30) ;

        LocalDate localDate = LocalDate.of(2012,2,29).plusYears(1) ;
        LocalDate localDate1 = localDate.plusDays(200) ;
        System.out.println(localDate.until(localDate1, ChronoUnit.DAYS));
        LocalDate firstTh = LocalDate.of(2014,1,1).with(TemporalAdjusters.lastInMonth(DayOfWeek.THURSDAY)) ;
        System.out.println(firstTh);
        /**
         * 实现自己的日期校正器
         */
        TemporalAdjuster NEXT_workday = TemporalAdjusters.ofDateAdjuster(w ->{
            LocalDate result = w ;
            {
                result = result.plusDays(1) ;
            }while (result.getDayOfWeek().getValue()>=6) ;
            return result ;
        });

        LocalDate back = LocalDate.now().with(NEXT_workday) ;


        ZonedDateTime zone = ZonedDateTime.now(ZoneId.of("UTC")) ;
        zone = zone.plus(Period.ofDays(7)) ;
//        String formatted = DateTimeFormatter.RFC_1123_DATE_TIME.format(zone) ;
//        System.out.println(formatted);
        DateTimeFormatter timeFormatter = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.LONG) ;
        String formatted = timeFormatter.withLocale(Locale.CHINESE).format(zone) ;
//        System.out.println(formatted);

        LocalDate bir = LocalDate.of(1990,8,30) ;
        System.out.println(bir.until(LocalDate.now(), ChronoUnit.DAYS));
        System.out.println(LocalDate.now().with(next(w -> w.getDayOfWeek().getValue() < 6)));

    }

    public static TemporalAdjuster next(Predicate<LocalDate> localDate){
        return TemporalAdjusters.ofDateAdjuster(w ->{
            LocalDate lo = w ;
            {
                lo = lo.plusDays(1);
            }while (!localDate.test(lo)) ;
            return lo ;
        }) ;
    }
}
