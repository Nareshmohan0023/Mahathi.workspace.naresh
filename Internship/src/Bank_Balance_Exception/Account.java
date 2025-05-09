package Bank_Balance_Exception;

public class Account {
	private String Name;
	private final int AccountNum;
	private int Balance;
	private final int MinBal=500;
	private int SecretPin;
	
	public Account(String name,int accountNum,int secretPin) {
		super();
		this.AccountNum =accountNum ;
		this.Name = name;
		this.Balance = 0;
		this.SecretPin=secretPin;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public int getBalance() {
		return Balance;
	}

	public void setBalance(int balance) {
		Balance = balance;
	}

	public int getMinBal() {
		return MinBal;
	}
	
	public void SetSecretPin(int pin) {
		SecretPin = pin;
	}
	public int getSecretPin() {
		return SecretPin;
	}

	

	@Override
	public String toString() {
		return "Account [Name=" + Name + ", Balance=" + Balance + ", MinBal=" + MinBal + "]";
	}

	public int getAccountNum() {
		return AccountNum;
	}
	
	
	
	
	
	
	
	

}
