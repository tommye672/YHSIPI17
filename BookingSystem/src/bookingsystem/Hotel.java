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

	public void checkOut(String id) {
		System.out.println("Utcheckning sker...\n");
		try {
			rooms.stream()
				.filter(r -> r.getTicket() != null)
				.filter(r -> r.getTicket().getId().equals(id))
				.findFirst()
				.get()
				.checkOut();
			}
		catch(Exception e ){
			System.out.println("Något gick fel...\n");
			System.out.println(id+"\n");
			System.out.println(rooms.toString());
		}
	}
	
	public Room getVacantRoom() { 	
		if (getVacantRooms().isEmpty()) {
			return null;
			}
		return getVacantRooms()
				.stream()
				.findAny()
				.get();
	}

	public void printCheckedinPersons() {
		StringBuilder sb = new StringBuilder();
		
		rooms.stream().filter(r -> r.getTicket() != null).forEach(r -> sb.append(r.getTicket() + "\n"));
		
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
