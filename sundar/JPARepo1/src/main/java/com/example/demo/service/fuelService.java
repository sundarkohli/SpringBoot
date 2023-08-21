package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.petrolBunk;
import com.example.demo.repository.fuelRep;

@Service
public class fuelService {
	@Autowired
	fuelRep frepo;
	
	public petrolBunk saveDetails(petrolBunk p)
	{
		return frepo.save(p);
	}
	
	public List<petrolBunk> getDetails()
	{
		return frepo.findAll();
	}
}

