package com.compjava;
//JEnums (Basic Enum)
//@author : Parveen Kumar

public enum JEnums {
    A,
    B,
    C,
    D;
    public int toInt(){
        return this.ordinal();
    }
}
//Additional Examples
enum Day{
    MON, TUE, WED, THU, FRI, SAT, SUN;
    private final static Day[] day = values();
    public static Day toDay(int n) {
        return day[n];
    }
    public int toInt(){
        return ordinal();
    }
}
enum Month{
    JAN(31), FEB(28), MAR(31), APR(30), MAY(31),
    JUN(30), JUL(31), AUG(31), SEP(30), OCT(31),
    NOV(30), DEC(31);
    private final int days;
    private Month(int days){
        this.days = days;
    }
    public int days(){
        return days;
    }
    private final static Month[] month = values();
}

class X{
    public static void main(String[] args) {
        JEnums[] enums = JEnums.values();
        for(JEnums enums1 : enums){
            System.out.println(enums1 + " ..... " + enums1.ordinal());
        }

        System.out.println("toInt " + JEnums.A + " ... " + JEnums.A.toInt());
        System.out.println("toInt " + JEnums.C + " ... " + JEnums.C.toInt());

        //Return Days in month from Month Enum
        Month[] months = Month.values();
        for(Month m : months){
            System.out.println("Month - " + m + " Days - " + m.days());
        }
    }
}