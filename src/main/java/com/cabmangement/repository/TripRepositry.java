package com.cabmangement.repository;

import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.cabmangement.enums.TripStatus;
import com.cabmangement.model.Trip;

@Component
public class TripRepositry {

	Map<String, Trip> map = new HashMap<>();

	public Trip startTrip(Trip trip) {

		ZonedDateTime zonedDateTime = ZonedDateTime.now(ZoneId.of("Asia/Kolkata"));
		Instant startTime = zonedDateTime.toInstant();
		trip.setStartTime(startTime);
		trip.setTripId(System.currentTimeMillis());
		trip.setTripStatus(TripStatus.IN_PROGRESS);

		return trip;

	}

	public void endTrip(Trip trip) {
		ZonedDateTime zonedDateTime = ZonedDateTime.now(ZoneId.of("Asia/Kolkata"));
		Instant time = zonedDateTime.toInstant();
		 trip.setEndTime(time);
         trip.setTripStatus(TripStatus.FINISHED);
		
	}
}
