package com.withdrawlsService;

import com.customException.InsufficientFundsException;
import com.entity.BankAccount;

public class WithdrawlThread extends Thread{
	
	private double ammount;
	private BankAccount acc;
	
	
	
	public WithdrawlThread(int ammount,BankAccount acc) throws InsufficientFundsException {
		super();
		this.ammount = ammount;
		this.acc=acc;
		
	}



	@Override
	public void run() {
		try {
			acc.withdraw(ammount);
		} catch (InsufficientFundsException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
