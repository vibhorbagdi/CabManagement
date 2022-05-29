package com.cabmangement.model;

import java.time.Instant;

import com.cabmangement.enums.TripStatus;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class Trip {
    private Long tripId;
    private Instant startTime;
    private Instant endTime;
    private String startLocation;
    private String endLocation;
    private Double price;
    private TripStatus tripStatus;
    private CabDetails cabDetails;
}
