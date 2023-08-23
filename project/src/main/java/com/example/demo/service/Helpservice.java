package com.example.demo.service;

import java.security.PublicKey;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo.model.Helpmodel;
import com.example.demo.repository.Helprepo;

@Service
public class Helpservice {
@Autowired
public Helprepo hrepo;
public String saveHotel(Helpmodel h) {
	hrepo.save(h);
	return"Data saved";
}
public List<Helpmodel>getHotel(){
	return hrepo.findAll();
}

public Helpmodel updateHotel(Helpmodel hm) {
	return hrepo.saveAndFlush(hm);
}
public boolean deleteHotelif(int hotelId) {
	if(hrepo.existsById(hotelId)) {
		hrepo.deleteById(hotelId);
		return true;
	}
	return false;
}
public void deleteHotel(int hotel_id) {
	System.out.println("deleted");
	hrepo.deleteById(hotel_id);
}
//getUserId
@GetMapping("/users/userId")

public Optional<Helpmodel> getuserById(int userId)
{
	Optional<Helpmodel> hotel = hrepo.findById(userId);
	if(hotel.isPresent()) {
		return hotel;
	}
	else
	{
		return null;
	}
}
}