package ui;

import java.util.Scanner;

import bookingsystem.*;

public class UI  {
	private static Hotel hotel = new Hotel(2);
	
	public static void main(String[] args) {
		while(true) {
			switch(printUIMenu()) {			
				case '1':
					hotel.printVacantRooms();
					break;
				case '2':
					hotel.printCheckedinPersons();
					break;
				case '3':
					checkIn();
					break;
				case '4':				
					checkOut();
					break;
				case '9':				
					return;
				default:
					break;
			}
		}
	}
	private static char printUIMenu() {	
		StringBuilder sr = new StringBuilder();
		
		sr.append("************************************\n");
		sr.append("*            MENY                  *\n");
		sr.append("************************************\n");
		sr.append("* 1. Visa lediga rum               *\n");
		sr.append("* 2. Visa incheckade personer       *\n");
		sr.append("* 3. Checka in person              *\n");
		sr.append("* 4. Checka ut person              *\n");
		sr.append("* 9. Avsluta                       *\n");
		
		sr.append("\nGör ditt val: ");
		System.out.print(sr.toString());	
		
		@SuppressWarnings("resource")
		Scanner in = new Scanner(System.in);
		
		return in.next().charAt(0);
	}
	
	private static void checkIn() {
		if(hotel.getVacantRoom() == null) {
			System.out.println("Hotellet är fullbelagt...\n");
			return;
		}
		
		@SuppressWarnings("resource")
		Scanner in = new Scanner(System.in);
		
		System.out.println("Checka in ny gäst:");
		
		System.out.println("Namn: ");
		String name = in.nextLine();
		
		System.out.println("Ålder: ");
		int age = in.nextInt();

		hotel.checkIn(new Person(name, age));
	}
	
	private static void checkOut() {
		@SuppressWarnings("resource")
		Scanner in = new Scanner(System.in);
		
		System.out.println("Ange ticket ID:");
		
		hotel.checkOut(in.nextLine());
	}
}
