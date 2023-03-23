package app;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import model.entities.Reservation;

public class Program {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		DateTimeFormatter fmt1 = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		
		System.out.print("Room number: ");
		int number = sc.nextInt();
		System.out.println("Check-in date (DD/MM/YYYY): ");
		LocalDate checkIn = LocalDate.parse(sc.next(), fmt1);
		System.out.println("Check-out date (DD/MM/YYYY): ");
		LocalDate checkOut = LocalDate.parse(sc.next(), fmt1);
		
		if(checkIn.isAfter(checkOut)) {
			System.out.println("Error in reservation: Check-out date must be after check-in date");
		}
		
		else {
			Reservation reservation = new Reservation(number, checkIn, checkOut);
			System.out.println("Reservation: " + reservation);
			
			System.out.println();
			System.out.println("Enter data to update the reservation: ");
			System.out.println("Check-in date (DD/MM/YYYY): ");
			checkIn = LocalDate.parse(sc.next(), fmt1);
			System.out.println("Check-out date (DD/MM/YYYY): ");
			checkOut = LocalDate.parse(sc.next(), fmt1);
			
			

			String error = reservation.updadateDates(checkIn, checkOut);
			if(error != null) {
				System.out.println("Error in reservation " + error);
			}
			else {
				System.out.println("Reservation: " + reservation);
			}
			
			
			
		}
		
		sc.close();
	
	}

}
