
public class ElevetorDoor {
boolean door;
	public ElevetorDoor() {
		super();
		door=true;
	}
	public boolean isDoor_open() {
		
		return door;
	}
	public void openDoor(){
		door=true;
	}
	public void closeDoor(){
		door=false;
	}
}
