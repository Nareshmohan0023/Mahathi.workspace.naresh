package com.lift_application.services;

import com.lift_application.Lift;

public interface Lift_Service {
	void moveLift(Lift lift);

	void addRequest(Lift lift, int floor);
	
	void sleepThread();
}
