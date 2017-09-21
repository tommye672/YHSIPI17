package bookingsystem;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Hotel {

	private List<Room> rooms = new ArrayList<Room>();

	public Hotel(int nrOfRooms) {
		for (int i = 0; i < nrOfRooms;i++) {
			rooms.add(new Room());
		}
	}

	public void checkIn(Person person) {
		getVacantRoom().checkIn(person);
	}

	public void checkOut() {
		rooms.stream()
		.findFirst()
		.get()
		.checkOut();
	}
	public Room getVacantRoom() { 
		return getVacantRooms()
				.stream()
				.findAny()
				.get();
	}

	public void printCheckedinPersons() {
		rooms.stream()
		.filter(t -> t.getTicket() != null)
		.collect(Collectors.toList())
		.forEach(r -> System.out.println(r.getTicket()));
	}

	public void printVacantRooms() {
		getVacantRooms().forEach(r -> System.out.println(r.getRoomNr()));
	}
	
	private List<Room> getVacantRooms() { 
		return rooms
				.stream()
				.filter(r -> r.getTicket() == null)
				.collect(Collectors.toList());		
	}

}
