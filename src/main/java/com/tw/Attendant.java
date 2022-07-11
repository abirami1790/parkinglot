package com.tw;

import com.tw.exception.ParkingLotException;

public class Attendant {

    private ParkingLot parkingLot;
    public Attendant(ParkingLot parkingLot) {
        this.parkingLot = parkingLot;
    }

    public void parkVehicle(Object vehicle) throws ParkingLotException {
        parkingLot.checkIn(vehicle);
    }
}
