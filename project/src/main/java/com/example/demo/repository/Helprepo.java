package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;


import com.example.demo.model.Helpmodel;


public interface Helprepo extends JpaRepository<Helpmodel, Integer> {

}