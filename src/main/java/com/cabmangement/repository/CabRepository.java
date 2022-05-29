package com.cabmangement.repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

import org.springframework.stereotype.Component;

import com.cabmangement.model.CabDetails;
@Component
public class CabRepository {
	
    Map<String, CabDetails> cabDetailMap = new HashMap<>();
	Map<String, PriorityQueue<CabDetails>> idleCab = new HashMap<String, PriorityQueue<CabDetails>>();
	Map<String, List<CabDetails>> onTrip = new HashMap<>();
	
	public void addCab(String city, CabDetails cabDetails){
		cabDetailMap.put(cabDetails.getCab().getCabId(), cabDetails);
		PriorityQueue<CabDetails> idleCabs =  idleCab.getOrDefault(city, new PriorityQueue<CabDetails>());
		idleCabs.add(cabDetails);
		idleCab.put(city, idleCabs);
	}
	
	public void addCabToTrip(String city, CabDetails cabDetails){
		cabDetailMap.put(cabDetails.getCab().getCabId(), cabDetails);
		List<CabDetails> onTripCabs =  onTrip.getOrDefault(city, new ArrayList<>());
		onTripCabs.add(cabDetails);
		onTrip.put(city, onTripCabs);
	}
	
	public PriorityQueue<CabDetails> getIdleCabs(String city){
		return idleCab.get(city);
	}
	
	public void addCabDetail(CabDetails cabDetail) {
		
		cabDetailMap.put(cabDetail.getCab().getCabId(), cabDetail);
		
	}

public CabDetails getCabDetail(String cabId) {
		
		return cabDetailMap.get(cabId);
		
	}

public List<CabDetails> getAllCabs(){
	return new ArrayList<CabDetails>(cabDetailMap.values());
}
}
