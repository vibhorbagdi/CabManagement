package com.cabmangement.controller;

import javax.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.cabmangement.model.Cab;
import com.cabmangement.model.Trip;
import com.cabmangement.service.impl.BookingCabServiceImpl;
import com.cabmangement.service.impl.RegisterCabServiceImpl;


@RestController
public class CabApplicationController {
	
	@Autowired
	BookingCabServiceImpl bookingService;

	@Autowired
	RegisterCabServiceImpl registerCabService;
	
	@GetMapping("/bookCab")
	public ResponseEntity<Trip> bookCab(@PathParam(value = "source") String source, @PathParam(value = "destination") String destination) {
		 return new ResponseEntity<Trip>(bookingService.bookCab(source, destination), HttpStatus.OK);
		
	}
	
	@GetMapping("/test")
	public ResponseEntity<Trip> test() {
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@PostMapping("/registerCab")
	public  ResponseEntity<Object>  registerCab(@RequestBody Cab cab) {
	
		return new ResponseEntity<Object>(registerCabService.registerCab(cab), HttpStatus.OK);
	}
	
	@PutMapping("/updateCity")
	public ResponseEntity<Object> updateCab(@RequestBody Cab cab) {
		return new ResponseEntity<Object>(registerCabService.changeCabLocation(cab), HttpStatus.OK);
	}
	
	@PostMapping("/endTrip")
	public  ResponseEntity<Object>  endTrip(@RequestBody Trip trip) {
	
		return new ResponseEntity<Object>(bookingService.endTrip(trip), HttpStatus.OK);
	}
}
