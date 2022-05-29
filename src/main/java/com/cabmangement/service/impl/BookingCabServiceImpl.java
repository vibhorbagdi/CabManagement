package com.cabmangement.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cabmangement.repository.CabRepository;
import com.cabmangement.repository.TripRepositry;
import com.cabmangement.enums.CabState;
import com.cabmangement.model.CabDetails;
import com.cabmangement.model.Trip;
import com.cabmangement.service.BookCabServie;

@Component
public class BookingCabServiceImpl implements BookCabServie {
	
	@Autowired
	CabRepository cabRepository;
	@Autowired
	TripRepositry tripRepository;
	
	@Override
	public synchronized Trip bookCab(String fromLocation, String toLocation) {
		CabDetails cabDetails = cabRepository.getIdleCabs(fromLocation).poll();
		Trip trip = Trip.builder().
		cabDetails(cabDetails)
		.startLocation(fromLocation)
		.endLocation(toLocation)
		.build();
		
		cabDetails.setCabState(CabState.ON_TRIP);
		cabRepository.addCabToTrip(fromLocation, cabDetails);
		
		tripRepository.startTrip(trip);
		return trip;
	}

	@Override
	public Trip endTrip(Trip trip) {
        tripRepository.endTrip(trip);
        trip.getCabDetails().setCabState(CabState.IDLE);
        cabRepository.addCab(trip.getEndLocation(), trip.getCabDetails());
        return trip;
	}

}
