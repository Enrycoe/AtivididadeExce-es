package model.entities;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

import model.exceptions.DoaminException;


public class Reservation {

	DateTimeFormatter fmt1 = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	
	private Integer roomNumber;
	private LocalDate checkIn;
	private LocalDate checkOut;
	
	public Reservation(Integer roomNumber, LocalDate checkIn, LocalDate checkOut) throws DoaminException {
		if(checkIn.isAfter(checkOut)) { 
			throw new DoaminException("Error in reservation: Check-out date must be after check-in date");
		}
		
		this.roomNumber = roomNumber;
		this.checkIn = checkIn;
		this.checkOut = checkOut;
	}

	public Integer getRoomNumber() {
		return roomNumber;
	}

	public void setRoomNumber(Integer roomNumber) {
		this.roomNumber = roomNumber;
	}

	public LocalDate getCheckIn() {
		return checkIn;
	}

	public LocalDate getCheckOut() {
		return checkOut;
	}

	public long duration() {
		long meses = getCheckIn().until(checkOut, ChronoUnit.DAYS);
		return meses;
	}
	
	public void updadateDates(LocalDate checkIn, LocalDate checkOut) throws DoaminException {
		LocalDate now = LocalDate.now();
		if(checkIn.isBefore(now) || checkOut.isBefore(now)) {
			throw new DoaminException("Error in reservation: Reservation for updates must be future dates");
		}
		
		if(checkIn.isAfter(checkOut)) { 
			throw new DoaminException("Error in reservation: Check-out date must be after check-in date");
		}
		
		this.checkIn = checkIn;
		this.checkOut = checkOut;

	}
	
	@Override
	public String toString() {
		return "Room " + roomNumber
				+ ", check-in: " 
				+ checkIn.format(fmt1) 
				+ ", check-out "
				+ checkOut.format(fmt1) 
				+ ", " + duration() 
				+ " nights";
	}
		
}
