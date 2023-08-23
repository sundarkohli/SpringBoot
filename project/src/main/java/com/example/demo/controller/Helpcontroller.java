package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Helpmodel;
import com.example.demo.service.Helpservice;

@RestController
public class Helpcontroller {
	
@Autowired
public Helpservice hserv;

@PostMapping("/postHotel")
public String postHotel(@RequestBody Helpmodel hr) {
	hserv.saveHotel(hr);
	return"datasaved";
	}
@GetMapping("/getHotel")
public List<Helpmodel>getHotelInfo()
{
	return hserv.getHotel();
}
@PutMapping("/updateHotel")
	public Helpmodel updateHotelInfo(@RequestBody Helpmodel ve) {
	return hserv.updateHotel(ve);
}
@DeleteMapping("/deleteHotel/{id}")
public String removeHotel(@PathVariable("id") int hid)
{
	hserv.deleteHotel(hid);
	return"Hotel Id"+hid+"is deleted";
}
@DeleteMapping("/byReqParm")
public String removeByRequestPam(@RequestParam("id") int id)
{
	hserv.deleteHotel(id);
	return"Hotel with Id"+id+ "is deleted";
}
@DeleteMapping("/deleteHotelif/{id}")
public ResponseEntity<String> deleteMatrix(@PathVariable int id){
	boolean deleted = hserv.deleteHotelif(id);
	if(deleted) {
		return ResponseEntity.ok("Hotel with ID "+id+" deleted successfully");
	}else {
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Hotel with ID "+id+" not found");
	}
}
//getUserById
	@GetMapping("users/{userId}")
	public ResponseEntity<?> getUserById(@PathVariable int userId)
	{
      Optional<Helpmodel> hotel = hserv.getuserById(userId);
		if(hotel != null) {
			return ResponseEntity.ok(hotel);
		}
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(hotel);
	}
}
