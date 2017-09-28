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
	
	public Ticket checkIn(Person person) {
		ticket = new Ticket(person, this);
		return ticket;
	}
	public Ticket checkOut() {
		Ticket checkOutTicket = ticket;
		ticket = null;
		System.out.println("checked out: " +checkOutTicket.toString());
		return checkOutTicket;
	}
}
