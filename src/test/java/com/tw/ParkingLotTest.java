package com.tw;

import com.tw.exception.ParkingLotException;
import com.tw.exception.ParkingLotIsFullException;
import com.tw.exception.VechicleNotParkedException;
import com.tw.exception.VehicleAlreadyParkedException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ParkingLotTest {

    @Test
    void carAShouldBeAbleToPark () {
        ParkingLot parkingLot = new ParkingLot(10);
        Object carA = new Object();
        assertDoesNotThrow(()->parkingLot.checkIn(carA));
    }

    @Test
    void carCShouldNotBeAbleToPark () throws ParkingLotException {
        ParkingLot parkingLot = new ParkingLot(2);
        Object carA = new Object();
        Object carB = new Object();
        Object carC = new Object();
        parkingLot.checkIn(carA);
        parkingLot.checkIn(carB);
        assertThrows(ParkingLotIsFullException.class,()->parkingLot.checkIn(carC));
    }

    @Test
    void carAShouldBeCheckOutFromTheParkingLot() throws ParkingLotException {
        ParkingLot parkingLot = new ParkingLot(2);
        Object carA = new Object();
        parkingLot.checkIn(carA);
        assertDoesNotThrow(()->parkingLot.checkOut(carA));
    }

    @Test
    void throwExceptionWhenCarBTryingCheckOutWithoutParking() throws ParkingLotException {
        ParkingLot parkingLot = new ParkingLot(2);
        Object carA = new Object();
        Object carB = new Object();
        parkingLot.checkIn(carA);
        assertThrows(VechicleNotParkedException.class,()->parkingLot.checkOut(carB));
    }

    @Test
    void shouldThrowExceptionWhenSameCarIsGettingParkedTwice() throws ParkingLotException {
        ParkingLot parkingLot = new ParkingLot(4);
        Object carA = new Object();
        parkingLot.checkIn(carA);
        assertThrows(VehicleAlreadyParkedException.class,()->parkingLot.checkIn(carA));
    }

    @Test
    void shouldThrowExceptionWhenSameCarGettingCheckedOutTwice () throws ParkingLotException {
        ParkingLot parkingLot = new ParkingLot(2);
        Object carA = new Object();
        parkingLot.checkIn(carA);
        parkingLot.checkOut(carA);
        assertThrows(VechicleNotParkedException.class,()->parkingLot.checkOut(carA));
    }

    @Test
    void shouldThrowExceptionWhenNullObjectIsPassed() {
        ParkingLot parkingLot = new ParkingLot(2);
        assertThrows(ParkingLotException.class,()->parkingLot.checkIn(null));
    }

    @Test
    void returnTrueIfVehicleAlreadyParked() throws ParkingLotException {
        ParkingLot parkingLot = new ParkingLot(2);
        Object carA = new Object();
        parkingLot.checkIn(carA);
        assertTrue(parkingLot.vehicleParked(carA));
    }

    @Test
    void returnFalseIfVehicleNotParked() {
        ParkingLot parkingLot = new ParkingLot(2);
        Object carA = new Object();
        assertFalse(parkingLot.vehicleParked(carA));
    }
    @Test
    void carAShouldBeAllowedToCheckIn() throws ParkingLotException {
        ParkingLot parkingLot = new ParkingLot(1);
        Object carA = new Object();
        parkingLot.checkIn(carA);
    }
}