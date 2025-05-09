package Celsius_Farenheit;

import java.lang.annotation.AnnotationTypeMismatchException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Application {

	private static char exit;
	public static  double cel;
	public static  double far;

	public static void main(String[] args) {
		Scanner sc =new Scanner(System.in);
//		Application app=new Application();
		Services serv=new Services_Impl();
		System.out.println("Welcome!");
		do {
			
			System.out.println("Enter the Conversion need to perform");
			System.out.println("1.Celsius - Farenheit  \n2.Farenheit - Celsius");
			int choice=sc.nextInt();
			
			
			switch(choice) {
			case 1:
				try {
					System.out.println("Enter the Celsius Value");
					cel=sc.nextDouble();
					if(cel<0) {
						throw new Custom_Exception("The Value Cannotbe in Negative");
					}
					serv.Cel_to_Far(cel);
				}
				catch(InputMismatchException ex) {
					System.err.println("Enter only in Integer");
				}catch(Exception e) {
					System.err.println(e.getMessage());
				}
				
				break;
			
			case 2:
				try {
					System.out.println("Enter the Farenheit value");
					far=sc.nextDouble();
					if(far<0) {
						throw new Custom_Exception("The Value Cannotbe in Negative ");
					}
					serv.Far_to_Cel(far);
				}catch(InputMismatchException e) {
					System.err.println("Enter the value in Integer");
					
				}catch(Exception e) {
					System.err.println(e.getMessage());
				}
					
			}
			
			
			System.out.println("Do you Want to continue:'y' for continue or 'n' for exit ");
			try {
				exit = sc.next().toLowerCase().charAt(0);
			}catch(Exception e) {
				System.out.print("invalid input");
			}
		}while(exit!='n');
		System.out.println("Thank you :)");

	}

}
