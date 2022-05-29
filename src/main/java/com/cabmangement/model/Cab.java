package com.cabmangement.model;

import com.cabmangement.enums.CabType;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
@Data
public class Cab {
	
	private String cabId;
    private String cabNumber;
    private String brand;
    private CabType model;
    private String city;
}
