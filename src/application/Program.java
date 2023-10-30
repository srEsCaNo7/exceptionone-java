package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entities.Reservation;

public class Program {

	public static void main(String[] args) throws ParseException {
	 
		
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		System.out.print("Room number: ");
		int number = sc.nextInt();
		
		System.out.print("check-in date (dd/MM/yyyy): ");
		Date checkIn = sdf.parse(sc.next());
		System.out.print("check-Out date (dd/MM/yyyy): ");
		Date checkOut = sdf.parse(sc.next());

		if(!checkOut.after(checkIn)) {
			System.out.println("Error in reservation: Check-out date must be after check-in date.");
		}
		else {
			Reservation reserv = new Reservation(number, checkIn, checkOut);
			System.out.println("Reservation: " + reserv);
			
			System.out.println();
			System.out.println("Enter date to update the reservation: ");
			System.out.print("check-in date (dd/MM/yyyy): ");
			checkIn = sdf.parse(sc.next());
			System.out.print("check-Out date (dd/MM/yyyy): ");
			checkOut = sdf.parse(sc.next());
			
			Date now = new Date();
			if(checkIn.before(now)|| checkOut.before(now)){
				System.out.println("Error in reservation: Reservation dater for update must be future dates.");
			}
			else if(!checkOut.after(checkIn)) {
				System.out.println("Error in reservation: Check-out date must be after check-in date.");
			}
			else {
				reserv.updateDates(checkIn, checkOut);
				System.out.print("Reservation: " + reserv);
				
			}
		
		}
		
		sc.close();
	}
}
