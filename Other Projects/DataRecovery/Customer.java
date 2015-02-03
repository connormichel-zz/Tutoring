package DataRecovery;

public class Customer {

	private int checking;
	private int savings;
	private int loan;
	private String name;

	public Customer(String name){
		this.name=name;
		checking = 0;
		savings = 0;
		loan = 0;
	}

	public void setChecking(int change){
		checking += change;
	}

	public void setSavings(int change){
		savings += change;
	}

	public void setLoan(int change){
		loan += change;
	}

	public String getName(){
		return name;
	}

	public boolean sameName(String other){
		if(name.equals(other)){
			return true;
		}
		return false;
	}

	public String toString(){
		return name + "\n\tChecking Balance: " + checking + "\n\tSavings Balance: " + savings + "\n\tLoan Balance: " + loan;
	}

}
