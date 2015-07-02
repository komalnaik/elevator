import java.util.ArrayList;



public class Elevetor {
	static Elevetor myInstance=null;
	private Floor currentFloor;
	private ElevetorDoor doorOpen;
	private Pannel button_pannel;
	private String current_state;
		
	private Elevetor(Floor currentFloor,int n) {
		super();
		this.currentFloor = currentFloor;
		this.doorOpen = new ElevetorDoor();
		this.button_pannel = new Pannel(n);
		this.current_state = "idle";
	}
	public static Elevetor getInstance(Floor currentFloor,int n){
		if(myInstance==null){
			myInstance=new Elevetor(currentFloor, n);
		}
		return myInstance;
		
	}
	
	public String getCurrent_state() {
		return current_state;
	}

	private void goUp(Floor requested_floor){
		current_state="up";
		setCurrentFloor(requested_floor);

	}
	
	private void goDown(Floor requested_floor){
			current_state="down";
			setCurrentFloor(requested_floor);
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
	
	public void move(Floor requested_floor) {
		if(getFloorNumber()< requested_floor.getFloor_number()){
			goUp(requested_floor);
		}
		if(getFloorNumber()>requested_floor.getFloor_number()){
			goDown( requested_floor);
		}
		if(getFloorNumber()==requested_floor.getFloor_number()){
			open_door();
		}
	}

	public void moveToReq(Floor requested_floor) {
			String userReq=requested_floor.getPressedButton();
			String elevetorState=getCurrent_state();
			 if(userReq.equals(elevetorState) || elevetorState.equals("idle")){
						move(requested_floor);
						
			  }	
				
	}
}
