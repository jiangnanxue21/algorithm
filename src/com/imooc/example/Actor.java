package com.imooc.example;

/**
 * Created by xue on 15/8/23.
 */
public class Actor extends Thread {
    @Override
    public void run() {

        System.out.println(getName()+"是个演员");

        int count = 0 ;

        boolean keepRunning = true ;
        while (keepRunning){

            System.out.println(getName()+"登台演出"+(++count));

            if (count==100)
                keepRunning = false ;
            if (count%10 == 0)
                try {
                    Thread.sleep(10000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

        }
        System.out.println(getName()+"的演出结束了");
    }


    public static void main(String[] args) {
        Thread actor = new Actor() ;
        actor.setName("Mr.Thread");
        actor.start();


        Thread actressThread = new Thread(new Actress(),"MS. Runnable") ;
        actressThread.start();
    }
}


class Actress implements Runnable{
    @Override
    public void run() {

        System.out.println(Thread.currentThread().getName()+"是个演员");

        int count = 0 ;

        boolean keepRunning = true ;
        while (keepRunning){

            System.out.println(Thread.currentThread().getName()+"登台演出"+(++count));

            if (count==100)
                keepRunning = false ;
            if (count%10 == 0)
                try {
                    Thread.sleep(10000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

        }
        System.out.println(Thread.currentThread().getName()+"的演出结束了");
    }
}