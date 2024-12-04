package com.firstproject.helloworld;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class FirstProjectApplication {

    public static void main(String[] args) {

//  A reference of the container that has the object of the classes is taken and kept in objects.
//  The type of the reference in ApplicationContext.
//  It is the name of the container that contains all the objects created by the spring framework.

        ApplicationContext object = SpringApplication.run(FirstProjectApplication.class, args);

        objectCreation obj1 = object.getBean(objectCreation.class);
        objectCreation_2 obj2 = object.getBean(objectCreation_2.class);

        obj1.objects();
        obj2.anotherObjectTester();
    }

}
