import java.util.ArrayList;
import java.util.Scanner;


public class Main_Class {

	public static void main(String[] args) {
		
		
		Elevetor_controller e=new Elevetor_controller();
		
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter current floor of elevetor ");
		e.setElevetorFloor(sc.nextInt());
		
		System.out.println("Enter your current floor number");
		System.out.println("Enter where you want to go up /down");
		if(e.requestFrom(sc.nextInt(),sc.next())){
			System.out.println("Enter which floor you want to move");
			e.pressPanelButton(sc.nextInt());
			e.MoveTofloor();
		}
		else{
			System.out.println("cannot move to requested floor");
		}
		
	}

}
