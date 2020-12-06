package com.mycompany.test;

import com.mycompany.Array;
import org.junit.Test;

import static org.junit.Assert.*;


public class ArrayTest {
    @Test
    public void ArrayTestConstructor(){
        Array<String> myArray = new Array<>(10);
        assertNotEquals(myArray,null);
    }

    @Test
    public void insertAtBeginning() {
        Array<String> myArray = new Array<>(10);
        myArray.insertAt("a",0);
        assertEquals(0,myArray.indexOf("a"));
    }
}
