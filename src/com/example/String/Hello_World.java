package com.example.String;

/**
 * Created by xue on 15/8/17.
 */
public class Hello_World {

    public static void main(String[] args) {


        final double STARTRATE = 10 ;
        final int NRATES = 6 ;
        final int NYEARS = 10 ;

        double[] interesRate = new double[NRATES] ;
        for (int j = 0; j<interesRate.length ;j++)
            interesRate[j] = (STARTRATE+j)/100 ;

        double[][] balance = new double[NYEARS][NRATES] ;

        for (int j = 0 ;j < balance[0].length ;j++)
            balance[0][j] = 10000 ;

        for (int i = 1 ; i < balance.length ;i++)
            for (int j = 0 ; j < balance[i].length ; j++){
                balance[i][j] = balance[i-1][j]*(1+interesRate[j]) ;
            }

        for (int i = 0 ;i < interesRate.length ; i++)
            System.out.printf("%9.0f%%", interesRate[i]);

        System.out.println();

        for (double[] row:balance){

            for (double b :row){
                System.out.printf("%10.2f",b) ;
            }
            System.out.println();
        }

    }
}
