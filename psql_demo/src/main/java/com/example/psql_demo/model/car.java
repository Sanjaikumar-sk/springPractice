package com.example.psql_demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class car {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private int carNumber;
    private String manufacturer;
    private String model;
}
