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
		ticket = person != null ? new Ticket(person, this) : null;
	}
	public Ticket checkOut() {
		Ticket checkOutTicket = ticket;
		ticket = null;
		System.out.println(checkOutTicket.toString());
		System.out.println("Utcheckning klar...\n");
		return checkOutTicket;
	}

	@Override
	public String toString() {
		return "Room [roomNr=" + roomNr + ", ticket=" + ticket + "]\n";
	}
	
	
}
