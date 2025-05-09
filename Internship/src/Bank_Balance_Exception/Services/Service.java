package Bank_Balance_Exception.Services;

import java.util.Scanner;

import Bank_Balance_Exception.Account;
import Bank_Balance_Exception.Custom.Custom_Exception;

public class Service implements Service_Interface {
	static char exit = 'y';

	public void proceed(Scanner sc, Account A1) {
		do {
			System.out.println("1.Deposit  2.WithDrawl  3.CheckBalance");
			int choice = sc.nextInt();
			switch (choice) {
			case 1:
				Deposit(A1, sc);
				break;
			case 2:
				WithDrawl(A1, sc);
				break;
			case 3:
				CheckBalance(A1);
				break;
			default:
				try {
					throw new Custom_Exception("Enter Valid Choice:");
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
			}
			System.out.println("Do you Want to continue:'y' for continue or 'n' for exit ");
			try {
				exit = sc.next().toLowerCase().charAt(0);
			} catch (Exception e) {
				System.out.print("invalid input");
			}
		} while (exit != 'n');
	}

	public  void CheckBalance(Account a1) {
		System.out.println("Your Account Balance is" + a1.getBalance());
		if (a1.getBalance() < a1.getMinBal()) {
			System.out.println("Please Make sure to make your account Balance Greater than 500");
		}
	}

	public  void Deposit(Account a1, Scanner sc) {
		try {
			System.out.println("Enter the amount you have to Deposit:");
			int DepositAmnt = sc.nextInt();
			if (DepositAmnt <= 0) {
				throw new Custom_Exception("The Amount Value Should be Greater Than Zero");
			} else {
				int Balance = DepositAmnt + a1.getBalance();
				a1.setBalance(Balance);
				System.out.println("Amount Added sucessfully");
				System.out.println("Current Account Balance is:" + a1.getBalance());
				if (a1.getBalance() < a1.getMinBal()) {
					System.out.println("Please Make sure to make your account Balance Greater than 500");
				}
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public void WithDrawl(Account a1, Scanner sc) {
		try {
			System.out.println("Enter the amount You have to withdrawl:");
			int Amnt_Wd = sc.nextInt();
			if (Amnt_Wd < 0) {
				throw new Custom_Exception("The withdrawl amount cannot be less than Zero");
			} else {
				if (Amnt_Wd > a1.getBalance()) {
					throw new Custom_Exception("Low Balance Can't Withdrawl");
				} else if ((a1.getBalance() - Amnt_Wd) < a1.getMinBal()) {
					throw new Custom_Exception("You trying to withdrawl amount that going below MIN Balance");
				}
				int bal = a1.getBalance() - Amnt_Wd;
				a1.setBalance(bal);
				try {
					System.out.println("Withdrawing amount........");
					Thread.sleep(3000);
				}catch(Exception e) {
					System.err.println(e.getMessage());
				}
				System.out.println(Amnt_Wd + " WithDrawled Scuccessfully");
				System.out.println("Current Account Balance is:" + a1.getBalance());
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println("Current Account Balance is:" + a1.getBalance());
		}
	}
}
