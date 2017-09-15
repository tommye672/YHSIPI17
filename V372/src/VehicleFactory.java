import Cars.Car;
import Cars.Rickshaw;
import interfaces.IVehicle;

public class VehicleFactory {

	public IVehicle getVehicle(String type,String vehicle) {
		
		
		switch(type) {
		case "car":
			return new Car(vehicle);
		case "rickshaw":
			return new Rickshaw();
			default:
				return new Car("");
		}		
	}
}
