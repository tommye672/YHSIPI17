import Cars.Car;
import interfaces.IVehicle;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		VehicleFactory factory = new VehicleFactory();
		
		IVehicle v = factory.getVehicle("rickshaw","saab");
		System.out.println(v.VehicleType());
		
	}

}
