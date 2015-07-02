import java.util.ArrayList;


public class Building {
	ArrayList<Floor> Floor_list=new ArrayList<Floor>();
	int number_of_floors;
	Elevetor elevetor;
	
	public Building(){
		number_of_floors=5;
		elevetor=Elevetor.getInstance(null, number_of_floors);
		for(int i=0;i<number_of_floors;i++)
			Floor_list.add(new Floor(i,elevetor));
	}

	public boolean requestFrom(int req_floor,String s) {
		Floor requested_floor=Floor_list.get(req_floor);
		requested_floor.pressButton(s);
		if(req_floor==elevetor.getFloorNumber())return true;
		return false;
	}


	public void setElevetorFloor(int n) {
		elevetor.setCurrentFloor(Floor_list.get(n));
	}

	public void MoveTofloor() {
		Floor requested_floor=Floor_list.get(elevetor.getPannelButton());
		elevetor.move(requested_floor);
	}

	public void pressPanelButton(int i) {
		elevetor.pressPannelButton(i);
	}

	public int getElevetorFloor() {
		return elevetor.getFloorNumber();
	}
	
	


}
