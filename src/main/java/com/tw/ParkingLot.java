package com.tw;

import com.tw.exception.ParkingLotException;
import com.tw.exception.ParkingLotIsFullException;
import com.tw.exception.VechicleNotParkedException;
import com.tw.exception.VehicleAlreadyParkedException;

import java.util.HashSet;
import java.util.Set;

public class ParkingLot {

    private final int parkingSpaces;
    private final Set<Object> parkedVehicles;

    public ParkingLot (int parkingSpace) {
        this.parkingSpaces = parkingSpace;
        parkedVehicles = new HashSet<Object>();
    }

    private boolean isParkingLotFull() {
        return parkingSpaces <= parkedVehicles.size();
    }

    public void checkIn(Object vehicle) throws ParkingLotException {
        if (vehicle == null) throw new ParkingLotException();
        if (parkedVehicles.contains(vehicle)) {
            throw new VehicleAlreadyParkedException();
        }
        if (!isParkingLotFull()) {
            parkedVehicles.add(vehicle);
        } else {
            throw new ParkingLotIsFullException();
        }
    }

    public void checkOut(Object vehicle) throws ParkingLotException {
        if (parkedVehicles.contains(vehicle)) {
            parkedVehicles.remove(vehicle);
        } else {
            throw new VechicleNotParkedException();
        }
    }

    public boolean vehicleParked (Object vehicle) {
        return parkedVehicles.contains(vehicle);
    }
}
