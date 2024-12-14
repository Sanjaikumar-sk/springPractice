package org.example;

public class Laptop {

    private Developer developer;
    public Laptop(){
        System.out.println("Constructor of class laptop called. Coz object is created.");
    }

//  Setter Injection
//    public void setDeveloper(Developer developer) {
//        this.developer = developer;
//    }

    public void compile()
    {
        System.out.println("Class name: laptop \nMethod Name: compile");
    }
}
