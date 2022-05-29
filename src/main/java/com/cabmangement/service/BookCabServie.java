package com.cabmangement.service;

import com.cabmangement.model.Trip;

public interface BookCabServie {
	Trip bookCab(String fromLocation, String toLocation);

    Trip endTrip(Trip trip);

}
