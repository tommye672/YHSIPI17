import java.util.Random;
import java.util.Scanner;

public class Program {

	private static final int BUFFER_SIZE = 5;
	
	public static void main(String[] args) {
		
		randomIntQueue();
		
		//Fungerar lika bra med <Person> buffer
		//personQueue();

	}
	public static void randomIntQueue() {
		
		CircularBuffer<Integer> cb = new CircularBuffer<Integer>(BUFFER_SIZE);
		Scanner sc = new Scanner(System.in);
		Random random = new Random();
		char input = 0;
		
		while(input != 'q') {
			System.out.println("****************************************");
			System.out.println(cb.toString());
			System.out.println("1: slumpa nr \n2: ta bort från kön");
			input = sc.next().charAt(0);
			
			switch(input) {
				case '1':
					cb.add(random.nextInt(1000));
					break;
				case '2':
					cb.remove();
					break;
				default:
					break;
			}
		}
		sc.close();
	}	
	public static void personQueue() {
		
		// Skapa en person buffer
		CircularBuffer<Person> cb = new CircularBuffer<Person>(3);
		
		cb.add(new Person("Anton", "Andersson", 22));	//lägg till person plats 0
		cb.add(new Person("Emil", "Svenosson", 24));	//lägg till person plats 1
		cb.remove();									//ta bort person plats 0
		cb.add(new Person("Lotta", "Karlsson", 52));	//lägg till person plats 2
		cb.add(new Person("Anders", "And", -45));		//lägg till personplats 0
		cb.add(new Person("Karin", "Lööve", 66));		//plats 1 full
		cb.remove();									//ta bort person plats 1
		//cb.add(new Person("Karin", "Lööve", 66));		//lägg till person plats 1 igen nu när den är ledig
		
		System.out.println(cb.toString());
	}

}
