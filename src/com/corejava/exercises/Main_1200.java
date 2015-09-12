package com.corejava.exercises;


import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.math.Fraction;
import org.apache.commons.math3.stat.descriptive.DescriptiveStatistics;

import java.util.Arrays;
import java.util.Random;

/**r
 * Created by xue on 15/8/30.
 */
public class Main_1200 {

    public static void main(String[] args) {

        int[] array0 = new int[5];
        Arrays.fill(array0,8);

        /*add 10 in the end */
        int[] array1 = ArrayUtils.add(array0,10) ;

        /* add element 10 int start */
        int[] array2 = ArrayUtils.add(array1,0,10) ;

        /* merge two arrays */
        int[] array3 = ArrayUtils.addAll(array1,array2) ;

        /*remove a element in a index */
        int[] array4 = ArrayUtils.remove(array0,0) ;

        /*remove the first element in the start */
        int[] array5 = ArrayUtils.removeElement(array1,10) ;

        System.out.println(Arrays.toString(array5));

        /**
         *         RandomStringUtils
         *         generate a random
         *         1.大小写字母
         *         2.大小写字母和数字
         *         3.Ascii
         *         4.数字
         */
        System.out.println(RandomStringUtils.randomAlphabetic(5));
        System.out.println(RandomStringUtils.randomAlphanumeric(5));
        System.out.println(RandomStringUtils.randomNumeric(5));
        System.out.println(RandomStringUtils.randomAscii(5));

        /**
         * 分数的运算
         */
        Fraction fraction1 = Fraction.getFraction(1,3) ;
        Fraction fraction2 = Fraction.getFraction(1,3) ;
        System.out.println(fraction1.add(fraction2));
        System.out.println(fraction1.multiplyBy(fraction2));
        System.out.println(fraction1.divideBy(fraction2));
        System.out.println(fraction1.pow(2));

        /**
         * 统计学的应用
         * 常用有以下这些方法：
         * getMax,getMin,getMean,getSum
         */
        DescriptiveStatistics ds = new DescriptiveStatistics(10) ;
        for(int i = 0 ; i<10 ;i++)
            ds.addValue(new Random().nextInt(10));//增加元素
        System.out.println(Arrays.toString(ds.getValues()));

        System.out.println(ds.getMax());

        /**
         * 区间
         */



    }
}
