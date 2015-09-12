package com.corejava.exercises;

/**
 * Created by xue on 15/8/22.
 */
public class Manger extends Employee {

    public double bonus ;

    public Manger(String n, double s, int year, int month, int day) {
        super(n, s, year, month, day);
        bonus = 0;
    }

    public void setBonus(double bonus) {
        this.bonus = bonus;
    }

    public String toString(){
        return super.toString()
                + "[bonus"+bonus
                +"]";
    }
    public double getSalary(){
        double baseSalary = super.getSalary() ;
        return  baseSalary+bonus ;
    }
}
