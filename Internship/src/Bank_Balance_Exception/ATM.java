package Bank_Balance_Exception;

import java.util.Scanner;

import Bank_Balance_Exception.Custom.Custom_Exception;
import Bank_Balance_Exception.Services.Service;

public class ATM {
	static char exit;
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		 Account A1=new Account("Naresh",123456,1234);
		 Service Serv=new Service();
		
		System.out.println("Welcome To ATM");
		
		do {
			try {
				System.out.println("Enter Your Account Number:");
				String AccountNum=sc.next();
				if(Integer.parseInt(AccountNum)==A1.getAccountNum() && AccountNum.length()==6) {
					try {
						System.out.println("Enter Your Secret Pin:");
						String pin=sc.next();
						if(pin.length()==4&&Integer.parseInt(pin)==A1.getSecretPin()) {
							Serv.proceed(sc,A1);
						}else {
							throw new Custom_Exception("Entered Pin is Wrong");
						}
					}catch(Exception e) {
						System.out.println(e.getMessage());
						
					}
				}else {
					throw new Custom_Exception("Check your Account Number:");
				}
			}catch (Exception e){
				System.out.println(e.getMessage());
			}
			System.out.println("Do you Want to continue:'y' for continue or 'n' for exit ");
			try {
				exit = sc.next().toLowerCase().charAt(0);
			}catch(Exception e) {
				System.out.print("invalid input");
			}
		}while(exit!='n');
		System.out.println("Thanks For Banking With us :)");
		
		
		
		
		
		
	}

}
