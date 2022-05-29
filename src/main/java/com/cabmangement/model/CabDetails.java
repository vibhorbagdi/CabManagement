package com.cabmangement.model;

import com.cabmangement.enums.CabState;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class CabDetails implements Comparable<CabDetails> {
	
    private Cab cab;
    private CabState cabState;
    private City location;
    
	

	@Override
	public int compareTo(CabDetails o) {
		return this.getCab().getCabId().compareTo(o.getCab().getCabId());
	}
	
    

}
