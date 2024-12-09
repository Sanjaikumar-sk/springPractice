package com.firstproject.helloworld;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class objectCreation_2 {

//    Field Injection
//    @Autowired
//    @Qualifier("autoWired")
//    public autoWired wiredObject;
//
//
//    CONSTRUCTOR INJECTION:
//    public objectCreation_2(autoWired wiredObject)
//    {
//        this.wiredObject = wiredObject;
//    }
//
//
//    SETTER INJECTION
//    @Autowired
//    public void setautoWired(autoWired wiredObject)
//    {
//        this.wiredObject = wiredObject;
//    }

    public void anotherObjectTester()
    {
        System.out.println("Object created for the 2nd class: objectCreation_2");
//        wiredObject.funtion1();
    }
}
