
public class Pannel {
	Button[] Pannel_button;
	
	public Pannel(int no_of_buttons) {
		super();
		Pannel_button=new Button[no_of_buttons];
		for(int i=0;i<no_of_buttons;i++)
		Pannel_button[i] = new Button();
	}
	
	public  int  getPressd_button(){
		 for(int i=0;i<Pannel_button.length;i++)
			 if(Pannel_button[i].isPressed())
				 return i;
		 
		 return -1;	 
	}
	
	public void setButton(int i){
		Pannel_button[i].setPressed(true);
	}
}
