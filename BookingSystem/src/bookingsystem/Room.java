package bookingsystem;

public class Room {
	private static int id;
	private int roomNr;
	private Ticket ticket;
	
	public Room() {
		id++;
		roomNr = id +100;
	}

	public Ticket getTicket() {
		return ticket;
	}

	public int getRoomNr() {
		return roomNr;
	}
	
	public void checkIn(Person person) {
		ticket = new Ticket(person, this);
	}
	public void checkOut() {
		ticket = null;
		System.out.println("checked out...");
	}
}
