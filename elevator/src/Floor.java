
public class Floor {
	int floor_number;
	FloorButton button_pressed;
	
	public Floor(int floor_number) {
		super();
		this.floor_number = floor_number;
	}

	public int getFloor_number() {
		return floor_number;
	}

	public void setFloor_number(int floor_number) {
		this.floor_number = floor_number;
	}
	
	public String getPressedButton(){
		if(button_pressed instanceof Floor_up_button){return "up";}
		if(button_pressed instanceof Floor_down_button){return "down";}
		return null;
	}
	
	public void pressButton(String s) {
		FloorButtonFactory f=new FloorButtonFactory();
		button_pressed=f.getFloorButton(s);
	}
}
