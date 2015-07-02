
public class FloorButtonFactory {
	
	public FloorButton getFloorButton(String type){
		if(type.equals("up"))
			return new Floor_up_button();
		else
			return new Floor_down_button();
		}
}
