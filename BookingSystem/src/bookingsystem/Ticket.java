package bookingsystem;

import java.util.Date;
import java.util.Random;

public class Ticket {
	private Person person;
	private Room room;
	private String id;
	private Date checkInDate;
	
	public Ticket(Person person, Room room) {
		this.person = person;
		this.room = room;
		checkInDate = new Date();
		id = generateId();
	}

	public String getId() {
		return id;
	}

	public Person getPerson() {
		return person;
	}

	public Room getRoom() {
		return room;
	}

	public Date getCheckInDate() {
		return checkInDate;
	}

	@Override
	public String toString() {
		return "Rum nr: " + this.getRoom().getRoomNr() + " - " + this.getPerson().getName() + " " + this.getPerson().getAge() + "år (" + id +")" ;
	}

	private String generateId() {
		
		//use seed systemTime.milliseconds if necessary
		Random random = new Random();
		
		return person.getName().replaceAll("\\s", "")+random.nextInt();
	}
}
