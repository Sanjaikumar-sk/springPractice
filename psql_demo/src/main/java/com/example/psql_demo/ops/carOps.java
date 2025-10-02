package com.example.psql_demo.ops;

import com.example.psql_demo.model.car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.psql_demo.repo.carRepo;

@Service
public class carOps {
    private carRepo repo;

    @Autowired
    public carOps(carRepo repo) {
        this.repo = repo;
    }
    private car car = new car();
    public void setRepo(carRepo repo) {
        this.repo = repo;
    }

    public void setCarData(){
        car.setCarNumber(123);
        car.setManufacturer("Mahindra");
        car.setModel("BE 6E");

        System.out.println("Adding data in DB");
        repo.save(car);
    }

    public void getCarData(){
        car = repo.findById(1).orElseThrow(() -> new RuntimeException("Data not found"));
        System.out.println("Make = " + car.getManufacturer());
    }

    public void updateCar(){
        car.setId(1);
        car.setModel("XEV 9E");

        System.out.println("Updating DB");
        repo.save(car);
    }

    public void deleteCar(){
        car.setId(1);
        System.out.println("Deleting Car");
        repo.delete(car);
    }
}
