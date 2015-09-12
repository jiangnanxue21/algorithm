package com.corejava.exercises;

import java.util.Scanner;

/**
 * Created by xue on 15/8/25.
 */
public class EnumTest {

    enum Size{
        SMALL("S"), LARGE("L"), MEDIA("M"),EXTRA_LARGE("XL");

        private  Size(String abbreviation) {this.abbreviation = abbreviation ;}
        public String getAbbreviation(){return abbreviation; }

        private String abbreviation ;
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in) ;
        String name = scanner.next().toUpperCase();
        Size size = Enum.valueOf(Size.class,name) ;
        System.out.println(size.getAbbreviation());
        System.out.println(size.ordinal()+1);
    }
}
