import java.util.ArrayList;



public class Elevetor {
	private Floor currentFloor;
	private ElevetorDoor doorOpen;
	private Pannel button_pannel;
	private String current_state;
		
	public Elevetor(Floor currentFloor,int n) {
		super();
		this.currentFloor = currentFloor;
		this.doorOpen = new ElevetorDoor();
		this.button_pannel = new Pannel(n);
		this.current_state = "idle";
	}
	
	public String getCurrent_state() {
		return current_state;
	}

	private void goUp(ArrayList<Floor> floorList,int dest){
		current_state="up";
		while(currentFloor.getFloor_number()<dest){
			setCurrentFloor(floorList.get(currentFloor.getFloor_number()+1));
		}
	}
	
	private void goDown(ArrayList<Floor> floorList,int dest){
			current_state="down";
			while(currentFloor.getFloor_number()>dest){
				setCurrentFloor(floorList.get(currentFloor.getFloor_number()+1));
			}
		
	}
	
	public Floor getCurrentFloor() {
		return currentFloor;
	}

	public void setCurrentFloor(Floor currentFloor) {
		this.currentFloor = currentFloor;
	}
	
	public void pressPannelButton(int n){
		button_pannel.setButton(n);
		close_door();
	}
	
	public int getPannelButton(){
		return button_pannel.getPressd_button();
	}
	public void open_door(){
		current_state="idle";
		doorOpen.openDoor();
	}
	public void close_door(){
		doorOpen.closeDoor();
	}
	public boolean isDoorOpen(){
		return doorOpen.isDoor_open();
	}
	public int getFloorNumber(){
		return currentFloor.getFloor_number();
	}
	
	public void move(int requested_floor,ArrayList<Floor> Floor_list) {
		if(getFloorNumber()< requested_floor){
			goUp(Floor_list, requested_floor);
		}
		if(getFloorNumber()>requested_floor){
			goDown(Floor_list, requested_floor);
		}
		if(getFloorNumber()==requested_floor){
			open_door();
		}
	}
}
