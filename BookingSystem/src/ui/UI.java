package ui;

import java.util.Scanner;

import bookingsystem.*;

public class UI  {
	private static Hotel hotel = new Hotel(10);
	
	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);
		char input = 0;

		while(input != 'q') {	
			printUIMenu();
			input = in.next().charAt(0);
			
			switch(input) {
				case '1':
					hotel.printVacantRooms();
					break;
				case '2':
					hotel.printCheckedinPersons();
					break;
				case '3':
					hotel.checkIn(printUICheckInNewPerson());
					break;
				default:
					break;
			}
		}
		in.close();
	}
	private static void printUIMenu() {
		StringBuilder sr = new StringBuilder();
		
		sr.append("************************************\n");
		sr.append("*            MENY                  *\n");
		sr.append("************************************\n");
		sr.append("* 1. Visa lediga rum               *\n");
		sr.append("* 2. Visa inchekade personer       *\n");
		sr.append("* 3. Checka in person              *\n");
		sr.append("* 4. Checka ut person              *\n");
		
		sr.append("\nGör ditt val: ");
		System.out.print(sr.toString());		
	}
	
	private static Person printUICheckInNewPerson() {
		Scanner in = new Scanner(System.in);
		System.out.println("Checka in ny gäst:");
		
		System.out.println("Namn: ");
		String name = in.nextLine();
		
		System.out.println("Ålder: ");
		int age = in.nextInt();
		
		in.close();
		
		return new Person(name, age);
	}
	
	private static void test() {
		Person p1 = new Person("Roffe", 58);
		
//		hotel.printVacantRooms();
		hotel.checkIn(p1);
//		hotel.printCheckedinPersons();
//		hotel.checkOut();
	}

}
