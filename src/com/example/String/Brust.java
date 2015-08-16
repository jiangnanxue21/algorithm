package com.example.String;

/**
 * Created by xue on 15/8/16.
 */
public class Brust {

    public static int search(String pat,String txt){

        int n = pat.length() ;
        int m = txt.length() ;
        for (int i = 0; i <= m-n;i++){
            int j ;
            for ( j = 0 ;j <n ;j++)
                if (pat.charAt(j)!=txt.charAt(i+j))
                    break;
                if (j==n) return i;
        }
        return m;
    }

    public static void main(String[] args) {
        String a = "fsfdsffsdfdsfdsggwrgbvysghet" ;
        String b = "et";
        int l = search(b,a) ;
        System.out.println(l);
    }
}
