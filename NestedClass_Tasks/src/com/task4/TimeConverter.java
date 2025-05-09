package com.task4;

import java.util.Scanner;

public class TimeConverter {
	
	public void converterToSeconds(int hours,int minutes) {
		class Time{
			private int hours;
			private int minutes;
			public Time(int hours, int minutes) {
				super();
				TimeConverter tc=new TimeConverter();
				if((hours<24&&hours>=0)&&(minutes>=0&&minutes<59)) {
					this.hours = hours;
					this.minutes = minutes;
					int Total_Seconds=(hours*3600)+(minutes*60);
				
					System.out.println("The Converted values is:"+Total_Seconds);
				}else {
					System.err.println("invalid data");
				}
				
			}
			
			
			
		}
        new Time(hours, minutes);

		
	}
	
	
	
	public static void main(String[] args) {
		boolean x=true;
	while(x) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the hour:");
		int hour=sc.nextInt();
		System.out.println("Enter The Minutes");
		int minutes=sc.nextInt();
		TimeConverter tc=new TimeConverter();
//		tc.new Time(hour,minutes);
		tc.converterToSeconds(hour, minutes);
		
		System.out.println("Do you want to continue 'y' or ''n");
		char exit=sc.next().charAt(0);
		if(exit=='y') {
			x=true;
		}else {
			x=false;
		}
		
	}
	System.out.println("than you");

}
}
