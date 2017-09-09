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
			System.out.println("1: slumpa nr \n2: ta bort fr�n k�n");
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
		
		cb.add(new Person("Anton", "Andersson", 22));	//l�gg till person plats 0
		cb.add(new Person("Emil", "Svenosson", 24));	//l�gg till person plats 1
		cb.remove();									//ta bort person plats 0
		cb.add(new Person("Lotta", "Karlsson", 52));	//l�gg till person plats 2
		cb.add(new Person("Anders", "And", -45));		//l�gg till personplats 0
		cb.add(new Person("Karin", "L��ve", 66));		//plats 1 full
		cb.remove();									//ta bort person plats 1
		//cb.add(new Person("Karin", "L��ve", 66));		//l�gg till person plats 1 igen nu n�r den �r ledig
		
		System.out.println(cb.toString());
	}

}
