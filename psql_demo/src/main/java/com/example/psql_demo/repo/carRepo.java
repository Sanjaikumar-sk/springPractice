package com.example.psql_demo.repo;

import com.example.psql_demo.model.car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface carRepo extends JpaRepository<car, Integer> {
}
