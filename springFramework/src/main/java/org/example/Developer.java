package org.example;

public class Developer {

    public Developer(){
        System.out.println("Constructor of class Developer called. Coz object is created.");
    }
    private Laptop laptop;
//    Constructor Injection
    public Developer(Laptop laptop)
    {
        this.laptop=laptop;
        System.out.println("constructor args");
    }


    public void build()
    {
        System.out.println("Class name: 'Developer'. \n Method name: 'build'");
    }
}
