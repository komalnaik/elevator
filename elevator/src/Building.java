import java.util.ArrayList;


public class Building {
	ArrayList<Floor> Floor_list=new ArrayList<Floor>();
	int number_of_floors;
	Elevetor elevetor;
	
	public Building(){
		number_of_floors=5;
		for(int i=0;i<number_of_floors;i++)
			Floor_list.add(new Floor(i));
		elevetor=new Elevetor(Floor_list.get(0), number_of_floors);
	}

	public boolean requestFrom(int req_floor,String s) {
		Floor requested_floor=Floor_list.get(req_floor);
		requested_floor.pressButton(s);
		return move_To_Req_floor(requested_floor);
	}


	public void setElevetorFloor(int n) {
		elevetor.setCurrentFloor(Floor_list.get(n));
	}

	public void MoveTofloor() {
		int requested_floor=elevetor.getPannelButton();
		elevetor.move(requested_floor,Floor_list);
	}

	public void pressPanelButton(int i) {
		elevetor.pressPannelButton(i);
	}

	public int getElevetorFloor() {
		return elevetor.getFloorNumber();
	}
	
	
	private boolean move_To_Req_floor(Floor requested_floor) {
	String userReq=requested_floor.getPressedButton();
	String elevetorState=elevetor.getCurrent_state();
	
	 if(userReq.equals(elevetorState) || elevetorState.equals("idle")){
				elevetor.move(requested_floor.getFloor_number(),Floor_list);
				return true;
	  }	
		return false;
	}

}
