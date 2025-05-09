package com.lift_application;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.lift_application.services.Lift_Service;
import com.lift_application.services.Lift_Service_Impl;

public class Application {
	private static List<Lift> Lifts=new ArrayList<>();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Lift_Service serv=new Lift_Service_Impl();
		System.out.println("Welcome To lift Management");
		System.out.println("Enter the number of lifts You need to create");
		int numOfLifts = sc.nextInt();

		for (int i = 1; i <= numOfLifts; i++) {
			Lifts.add(new Lift(i));
		}
		
		System.out.println("Enter the Lift_id and floor to make a request to lift" );
		
		System.out.println("Enter lift id");
		int id=sc.nextInt();

		System.out.println("Enter floor you need to go");
		int floor=sc.nextInt();
		
		serv.addRequest(Application.getLiftById(id), floor);
		serv.addRequest(Application.getLiftById(id), 3);
		while(!Application.getLiftById(id).getPending_Requests().isEmpty()) {
			serv.moveLift(Application.getLiftById(id));
		}
		sc.close();
		
		
		

	}
	
	public static Lift getLiftById(int liftId) {
	    for (Lift lift : Lifts) {
	        if (lift.getLiftId() == liftId) {
	            return lift;
	        }
	    }
	    return null;
	}

}
