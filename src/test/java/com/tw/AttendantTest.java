package com.tw;

import com.tw.exception.ParkingLotException;
import com.tw.exception.ParkingLotIsFullException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class AttendantTest {

    @Test
    void carShouldBeParkedByAttendant() throws ParkingLotException {
        ParkingLot parkingLot = new ParkingLot(2);
        Attendant attendant = new Attendant(parkingLot);
        Object carA = new Object();
        assertDoesNotThrow(()->attendant.parkVehicle(carA));
    }

    @Test
    void carCShouldNotBeAbleToPark () throws ParkingLotException {
        ParkingLot parkingLot = new ParkingLot(2);
        Attendant attendant = new Attendant(parkingLot);
        Object carA = new Object();
        Object carB = new Object();
        Object carC = new Object();
        attendant.parkVehicle(carA);
        attendant.parkVehicle(carB);
        assertThrows(ParkingLotIsFullException.class,()->attendant.parkVehicle(carC));
    }
}