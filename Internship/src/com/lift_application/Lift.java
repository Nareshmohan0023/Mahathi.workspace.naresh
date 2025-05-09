package com.lift_application;

import java.util.ArrayList;
import java.util.List;

public class Lift {

	private int LiftId;
	private int currentFloor;
	private List<Integer> PendingRequests;
	private final int maxFloor=4;
	private final  int minFloor=0;

	public int getMaxFloor() {
		return maxFloor;
	}

	public int getMinFloor() {
		return minFloor;
	}

	public Lift(int lift_id) {
		super();
		LiftId = lift_id;
		this.currentFloor = 0;
		this.PendingRequests = new ArrayList<>();
		

	}

	public int getLiftId() {
		return LiftId;
	}

	public void setLift_id(int lift_id) {
		LiftId = lift_id;
	}

	public int getCurrent_floor() {
		return currentFloor;
	}

	public void setCurrent_floor(int current_floor) {
		this.currentFloor = current_floor;
	}

	public List<Integer> getPending_Requests() {
		return PendingRequests;
	}

	public void setPending_Requests(int floor) {
		this.PendingRequests.add(floor);
	}

	@Override
	public String toString() {
		return "Lift [Lift_id=" + LiftId + ", currentFloor=" + currentFloor + ", PendingRequests=" + PendingRequests
				+ ", maxFloor=" + maxFloor + ", minFloor=" + minFloor + "]";
	}
	
	

}
