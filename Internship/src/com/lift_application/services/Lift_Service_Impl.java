package com.lift_application.services;

import com.lift_application.Lift;

public class Lift_Service_Impl implements Lift_Service {
	

	@Override
	public void moveLift(Lift lift) {
		if (!lift.getPending_Requests().isEmpty()) {
			int prev_Floor=lift.getCurrent_floor();
			int Next_Floor = lift.getPending_Requests().remove(0);
			lift.setCurrent_floor(Next_Floor);
			
			if(prev_Floor < Next_Floor){
				for(int i=prev_Floor;i<=Next_Floor;i++) {
					System.out.println("Lift"+lift.getLiftId()+" is on floor number"+ i);
					sleepThread();
				}
				
			}else if(prev_Floor>Next_Floor){
				for(int i=prev_Floor;i>=Next_Floor;i--) {
					System.out.println("Lift"+lift.getLiftId()+" is on floor number"+ i);
					sleepThread();

				}
				
			}else {
				System.out.println("You are in the requesting floor itself");
			}
			System.out.println(lift.toString());
		}

	}

	@Override
	public void addRequest(Lift lift, int floor) {

		lift.setPending_Requests(floor);
		System.out.println("Request added successfully");

	}

	@Override
	public void sleepThread() {
		try {
            Thread.sleep(1000); // Sleep for 1 second (1000 milliseconds) before continuing
        } catch (InterruptedException e) {
            e.printStackTrace(); // Handle potential interruption
        }
		
	}

}
