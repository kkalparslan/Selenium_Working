package com.tests.replit;

public class Example3 {
    /**
     * hello ve world kelimelerini ayrı ayrı methodlardan çağırarak
     *
     *     hello world!
     * şeklinde yazdırın.
     *
     * reminder main mehod içinde println kullanmyın.
     */
    public static void main(String[] args) {

method1();

    }
    public static void method1(){
        System.out.print("hello ");
        method2();
    }
    public static void method2(){
        System.out.println("world!");
    }

}

