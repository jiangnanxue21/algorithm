package com.example.String;

/**
 * Created by xue on 15/8/16.
 */
public class Brust {

    public static int search1(String pat,String txt){

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

    public static int search2(String pat,String txt){

        int n = pat.length() ;
        int m = txt.length() ;
        int i ,j ;
        for (i = 0,j = 0;i < m && j < n;i++){
            if (pat.charAt(j) == txt.charAt(i))
                j++;
            else {
                i -= j ;
                j = 0 ;
            }

        }
        if(j == n) return i - n ;
        else return m ;
    }

    public static void main(String[] args) {
        String a = "fsfdsffsdfdsfdsggwrgbvysghet" ;
        String b = "et";
        int l1 = search1(b,a) ;
        int l2 = search2(b,a) ;
        System.out.println(l1+" "+l2);
    }
}
