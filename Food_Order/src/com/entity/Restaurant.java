package com.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.Services.Service;
import com.Services.Service_Impl;

public class Restaurant {
	
	public static List<Food> Menu=new ArrayList<>();

	public static void main(String[] args) throws InterruptedException {
//		Restaurant restaurant=new Restaurant();
		Service serv=new Service_Impl();
		Scanner sc=new Scanner(System.in);
		
		serv.foodLoader(Menu);

		Customer c1=new Customer("Naresh",Menu,sc);
		Customer c2=new Customer("Denesh",Menu,sc);
		Customer c3=new Customer("Vinoth",Menu,sc);
		Customer c4=new Customer("Prathap",Menu,sc);
		
		Thread t1=new Thread(c1);	
		Thread t2=new Thread(c2);	
		Thread t3=new Thread(c3);	
		Thread t4=new Thread(c4);		
		System.out.println("Welcome To Our Restaurant");
		t1.start();
		t1.join();
		t2.start();
		t2.join();
		
		
		
	}

}
