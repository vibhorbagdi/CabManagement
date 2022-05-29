package com.cabmangement.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cabmangement.enums.CabState;
import com.cabmangement.model.Cab;
import com.cabmangement.model.CabDetails;
import com.cabmangement.repository.CabRepository;
import com.cabmangement.service.RegisterCabService;

@Component
public class RegisterCabServiceImpl implements RegisterCabService {
 
	@Autowired
	CabRepository cabRepository;
	@Override
	public Cab registerCab(Cab cab) {
		CabDetails cabDetails = CabDetails.builder().cab(cab).cabState(CabState.IDLE).build();
		cabRepository.addCab(cab.getCity(), cabDetails);
		return cab;
	}

	@Override
	public boolean changeCabLocation(Cab cab) {
		CabDetails currentCabDetails = cabRepository.getCabDetail(cab.getCabId());
		cabRepository.getIdleCabs(currentCabDetails.getCab().getCity()).remove(cabRepository.getCabDetail(cab.getCabId()));
		cab.setCity(cab.getCity());
		cabRepository.addCab(cab.getCity(), cabRepository.getCabDetail(cab.getCabId()));
		return true;
	}

	@Override
	public boolean changeCabState(Cab cab, CabState cabState) {
		
	  //having doubt in this user also need to share trip details as well
		return false;
		
		
	}

	@Override
	public List<CabDetails> getAllCab() {
		return cabRepository.getAllCabs();
	}

}
