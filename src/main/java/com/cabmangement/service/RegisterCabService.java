package com.cabmangement.service;

import java.util.List;

import com.cabmangement.enums.CabState;
import com.cabmangement.model.Cab;
import com.cabmangement.model.CabDetails;

public interface RegisterCabService {
	    Cab registerCab(Cab cab);
	    boolean changeCabLocation(Cab cab);
	    boolean changeCabState(Cab cab, CabState cabState);
	    List<CabDetails> getAllCab();
}
