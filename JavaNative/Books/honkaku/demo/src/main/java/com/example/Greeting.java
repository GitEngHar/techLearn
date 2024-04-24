package com.example;

public class Greeting {
    String message;
    
    public String getMessage(int times){
        if(times >= 5 && 11 > times){
            message = "GoodMorning";
        }else if (times >= 11 && 17 > times){
            message = "Hello";
        }else{
            message = "GoodEvening";
        }
        return message;
    } 
}
