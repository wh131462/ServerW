package com.wh131462.controller;
import com.wh131462.common.WwException;
public class test {
    public static void main(String[] args){
        test.WwException();
    }
     public static void WwException() {
        try {
            throw new WwException("false start");
        }catch (WwException e){
            System.out.println(e.getMessage());
        }
    }
}
