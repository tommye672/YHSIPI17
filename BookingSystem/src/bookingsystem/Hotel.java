package bookingsystem;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Hotel {

	private List<Room> rooms = new ArrayList<Room>();
	private List<Ticket> tickets = new ArrayList<Ticket>();
	
	public Hotel(int nrOfRooms) {
		for (int i = 0; i < nrOfRooms;i++) {
			rooms.add(new Room());
		}
	}

	public void checkIn(Person person) {
		tickets.add(getVacantRoom().checkIn(person));
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
		StringBuilder sb = new StringBuilder();
		tickets.forEach(r -> sb.append(r + "\n"));
		
		sb.insert(0,sb.length() > 0 ? "Incheckade personer:\n" :"Finns ingen incheckad person...\n");
		
		System.out.println(sb.toString());
	}	

	public void printVacantRooms() {
		
		StringBuilder sb = new StringBuilder();
		
		sb.append("Lediga rum:\n");
		
		getVacantRooms().forEach(r -> sb.append(r.getRoomNr() + "\n"));
		
		System.out.println(sb.toString());
	}
	
	private List<Room> getVacantRooms() { 
		return rooms
				.stream()
				.filter(r -> r.getTicket() == null)
				.collect(Collectors.toList());		
	}

}
