
public class BankAccount {
	double balance;
	String name;
	
	BankAccount (double b, String n) {
		balance = b;
		name = n;
	}
	
	void deposit (double dep) {
		balance += dep;
	}
	
	void withdraw (double wd) {
		balance -= wd;
	}
	
	void printBalance () {
		System.out.println ("The " + name + " account balance is, $" + balance);
	}
}
