package ui;

import bookingsystem.*;

public class UI  {
	private static Hotel hotel = new Hotel(10);
	
	public static void main(String[] args) {
		Person p1 = new Person("Roffe", 58);
		
		hotel.printVacantRooms();
		hotel.checkIn(p1);
		hotel.printCheckedinPersons();
		hotel.checkOut();
		
	
	}

}
