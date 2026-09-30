public class BankAccountTest{
public static void main(String args[]){
BankAccount account = new BankAccount(2456.93);
System.out.println("Before Transaction: ");
account.display();
System.out.println("After Transaction:");
account.diposit(780.32);
account.diposit(56.82);
account.withdraw(94.0654);
account.display();

}
}
class BankAccount{
	private double balance;
	
	public BankAccount(double balance){
		this.balance = balance;
	}
	public void diposit(double amount){
		this.balance += amount;
	}
	public void withdraw(double amount){
		this.balance -= amount;
	}
	
	public void display(){
		System.out.println("This is your Current Balance : "+balance);
	}
}