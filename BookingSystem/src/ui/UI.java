package ui;

import java.util.Scanner;

import bookingsystem.*;

public class UI  {
	private static Hotel hotel = new Hotel(10);
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		char input = 0;

		while(input != 'q') {
			
			printUIMenu();
			input = sc.next().charAt(0);
			
			switch(input) {
				case '1':
					hotel.printVacantRooms();
					break;
				case '2':
					hotel.printCheckedinPersons();
					break;
				case '3':
					test();
					break;
				default:
					break;
			}
		}
		sc.close();
		
		
	}
	private static void printUIMenu() {
		
		StringBuilder sr = new StringBuilder();
		
		sr.append("MENY\n");
		sr.append("************************************\n");
		sr.append("1. Visa lediga rum\n");
		sr.append("2. Visa inchekade personer\n");
		sr.append("3. Checka in person\n");
		sr.append("4. Checka ut person\n");
		
		sr.append("\nGör ditt val: ");
		System.out.println(sr.toString());		
	}
	private static void test() {
		Person p1 = new Person("Roffe", 58);
		
//		hotel.printVacantRooms();
		hotel.checkIn(p1);
//		hotel.printCheckedinPersons();
//		hotel.checkOut();
	}

}
