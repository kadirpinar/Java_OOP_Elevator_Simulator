package lift;

public class Tester {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Elevator myElevator= new Elevator(4, 5, 0 , 5);
		
		myElevator.AddFloorRequest(5);
		
		myElevator.AddFloorRequest(2);
		
		myElevator.AddFloorRequest(3);
		
		myElevator.AddFloorRequest(10);
                myElevator.StartEngine();
	}

}
