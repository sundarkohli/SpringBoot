package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;


import com.example.demo.model.petrolBunk;


public interface fuelRep extends JpaRepository<petrolBunk, Integer> {

}
