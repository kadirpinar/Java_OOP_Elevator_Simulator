package lift;

import java.util.ArrayList;
import java.util.Collections;

public class Elevator {

	private ElevatorState State;
	private final int CAPACITY;
	private final int MAXFLOOR;
	private final int MINFLOOR;
    private int NumberOfPerson;
    private boolean isBusy;
    private ArrayList<Integer> Requests= new ArrayList<>();
    private int MultiRequest;
    private int CurrentFloor;
    
	public Elevator(int Capacity, int MaxFloor, int MinFloor,int Numberofperson){
		this.CAPACITY=Capacity;
		this.MAXFLOOR=MaxFloor;
		this.MINFLOOR=MinFloor;
		this.NumberOfPerson=Numberofperson;
		isBusy=false;
		CurrentFloor=4;
	}
	
	
	public void AddFloorRequest(int StopRequest){	
                Requests.add(StopRequest);     
	}
        
	public void StartEngine(){
            Collections.sort(Requests);
            GetOffPerson();
            
          for(int i:Requests){
                               if(i>MAXFLOOR)
		{ System.out.println("MAXFLOOR is Given");
		
		  MultiRequest=MAXFLOOR;
		}
		else if(i<MINFLOOR)
			MultiRequest=MINFLOOR;
		else
			MultiRequest=i;
                
	while (CurrentFloor-MultiRequest!=0){
	if ((CurrentFloor-MultiRequest)>0)
		goDOWN();
	else if((CurrentFloor-MultiRequest)<0)
		goUP();
		
	}
	
	     StopEngine();
          }
}
	public void StopEngine(){
		System.out.println("Elevetator has stopped");
		State = ElevatorState.Idle;
		
	}
	
	
public void GetOnPerson(){
	if(NumberOfPerson<CAPACITY)
	    {
                NumberOfPerson++;
                System.out.println("A person get into Elevator");
            }
        else if(NumberOfPerson==CAPACITY)
		System.out.println("Maximum number of allowed passenger is REACHED");
	        
}	

public void GetOffPerson(){
    if(NumberOfPerson>CAPACITY)
    while(NumberOfPerson!=CAPACITY){
            System.out.println("A person left Elevator because Elevator reached over of capacity");    
		NumberOfPerson--;
	}
        if(NumberOfPerson==0)
		System.out.println("there is no Passenger in the LIFT");
                GetOnPerson();
	
}
  
public void TelltheFloor(){
		System.out.println("Currnt Floor is " + CurrentFloor +" " + State);
	}
	
public void goUP(){	
		if(CurrentFloor<MAXFLOOR)
		{	  
			CurrentFloor++;
			State= ElevatorState.GoingUP;
			isBusy=true;
		   TelltheFloor();
		}
		else
			System.out.println("You Can not Go UP further");
	}
	
	
public void goDOWN(){
		
	if(CurrentFloor>MINFLOOR)
	{	  
		CurrentFloor--;
		State= ElevatorState.GoingDOWN;
		isBusy=true;
	   TelltheFloor();
	}
	else
		System.out.println("You Can not Go DOWN further");
}
	
	
}
