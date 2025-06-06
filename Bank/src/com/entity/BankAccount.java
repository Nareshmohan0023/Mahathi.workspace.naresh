package com.entity;

import java.util.Random;

import com.customException.InsufficientFundsException;

public class BankAccount {
	private String accountHolder;
	private int accountNumber;
	private double balance;

	public BankAccount(String accountHolder, double balance) {
		Random random = new Random();
		this.accountHolder = accountHolder;
		this.accountNumber = 1000 + random.nextInt(9000);
		this.balance = balance;
	}

	public synchronized void withdraw(double amount) throws InsufficientFundsException {
        System.out.println("withdrawing " + amount + "...");
        System.out.println("Processing........");
        
        try {
            Thread.sleep(2000);
            if (amount > balance) {
                throw new InsufficientFundsException("Insufficient balance to withdrawl " + amount);
            }else {
            	balance -= amount;
                System.out.println("Withdrawal successful. Remaining balance: ₹" + balance);
            }
            
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }catch(InsufficientFundsException e) {
        	
        	System.err.println(e.getMessage());
          

        }
	}

	public double getBalance() {
		return balance;
	}
}
