package Bank_Balance_Exception.Services;

import java.util.Scanner;

import Bank_Balance_Exception.Account;

public interface Service_Interface {
	
	void proceed(Scanner sc, Account A1);
	void CheckBalance(Account a1);
	void Deposit(Account a1, Scanner sc);
	void WithDrawl(Account a1, Scanner sc);
	
	

}
