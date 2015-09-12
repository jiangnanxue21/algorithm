package com.corejava.exercises;

import java.util.Date;
import java.util.GregorianCalendar;

/**
 * Created by xue on 15/8/22.
 */
public class Employee implements Comparable<Employee>,Cloneable{

    public Employee(String n, double s, int year , int month, int day) {
        this.name = n;
        this.salary = s;
        GregorianCalendar calendar = new GregorianCalendar(year,month-1,day) ;
        hireDay = calendar.getTime() ;
    }

    @Override
    public int compareTo(Employee e) {
        return Double.compare(this.getSalary(),e.getSalary());
    }

    public String getName() {
        return name;
    }

    public double getSalary() {
        return salary;
    }

    public Date getHireDay() {
        return hireDay;
    }

    public void setHireDay(Date hireDay) {
        this.hireDay = hireDay;
    }

    @Override
    protected Employee clone() throws CloneNotSupportedException {
        Employee cloned = (Employee)super.clone();
        cloned.hireDay = (Date)hireDay.clone() ;
        return cloned ;
    }

    public String toString(){
        return this.getClass().getName()
                +"[name="+name
                +"] [salary="+salary
                +"] [hireDay="+hireDay;
    }

    public void raiseSalary(double byPercent){
        double raise = salary*byPercent/100 ;
        salary += raise ;
    }

    private String name ;
    public double salary ;
    private Date hireDay ;
}
