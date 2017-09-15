package Cars;

import interfaces.IVehicle;

public class Car implements IVehicle{

	private String type;
	
	public Car(String type) {
		this.type = type;
	}
	@Override
	public int NumberOfWheel() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String VehicleType() {
		// TODO Auto-generated method stub
		return type;
	}

}
