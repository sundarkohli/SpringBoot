package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.petrolBunk;
import com.example.demo.service.fuelService;

@RestController
public class FuelController {

	
	@Autowired
	fuelService fser;
	@PostMapping("/saveFuel")
	
	public petrolBunk saveFuelStationDe(@RequestBody petrolBunk pb)
	{
		return fser.saveDetails(pb);
	}
	
	@GetMapping("/getFuel")
	public List<petrolBunk> getFuelStationDe()
	{
		return fser.getDetails();
	}
}
