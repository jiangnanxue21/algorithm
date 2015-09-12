package com.imooc.example;

/**
 * Created by xue on 15/8/23.
 */
public class Stage extends Thread {
    @Override
    public void run() {
        ArmyRunnable armyTaskOfSui = new ArmyRunnable() ;
        ArmyRunnable armyTaskOfRevolt = new ArmyRunnable() ;

        Thread armyOfSui = new Thread(armyTaskOfSui,"隋军") ;
        Thread armyOfRevolt = new Thread(armyTaskOfRevolt,"农民起义军") ;

        armyOfRevolt.start();
        armyOfSui.start();

        try {
            Thread.sleep(50);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        

    }

    public static void main(String[] args) {

        new Stage().start();
    }
}
