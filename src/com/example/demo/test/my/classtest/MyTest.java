package com.example.demo.test.my.classtest;

public class MyTest {
    public int x;
    public int y;

    static class innerTest{

        public void myinner(){

        }
    }

    class innerTest2{

        public void myinner(){
            System.out.println(x+" "+y);
        }
    }




    public static void main(String[] args) {
        //MyTest.innerTest  test=new innerTest();
        MyTest myTest=new MyTest();
        MyTest.innerTest2 innerTest2=myTest.new innerTest2();
    }
}
