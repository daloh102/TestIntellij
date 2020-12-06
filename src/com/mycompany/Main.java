package com.mycompany;

public class Main {

    public static void main(String[] args) {
        Array<String> myArray = new Array<String>(10);
        myArray.insert("a");
        myArray.insert("b");
        myArray.insert("abcdeggh");
        myArray.print();
    }
}
