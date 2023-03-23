package app;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import model.entities.Reservation;
import model.exceptions.DoaminException;

public class Program {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		DateTimeFormatter fmt1 = DateTimeFormatter.ofPattern("dd/MM/yyyy");

		try {
	
			System.out.print("Room number: ");
			int number = sc.nextInt();
			System.out.println("Check-in date (DD/MM/YYYY): ");
			LocalDate checkIn = LocalDate.parse(sc.next(), fmt1);
			System.out.println("Check-out date (DD/MM/YYYY): ");
			LocalDate checkOut = LocalDate.parse(sc.next(), fmt1);
			
			
			
				Reservation reservation = new Reservation(number, checkIn, checkOut);
				System.out.println("Reservation: " + reservation);
				
				System.out.println();
				System.out.println("Enter data to update the reservation: ");
				System.out.println("Check-in date (DD/MM/YYYY): ");
				checkIn = LocalDate.parse(sc.next(), fmt1);
				System.out.println("Check-out date (DD/MM/YYYY): ");
				checkOut = LocalDate.parse(sc.next(), fmt1);
				
				
			
				reservation.updadateDates(checkIn, checkOut);
				System.out.println("Reservation: " + reservation);
						
					
		}
		catch(DoaminException e) {
			System.out.println("Error in reservation: " + e.getMessage());
		}
			
		
		
		sc.close();
	
	}

}
