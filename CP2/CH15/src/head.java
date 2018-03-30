
public class head {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Circle cir1 = new Circle (35.5);
		System.out.println("Radius: " + cir1.radius + "\nDiameter: " + cir1.diameter() + "\n\n");
		
		
		
		BankAccount myAccount = new BankAccount (1000, "Sam Sanft");
		myAccount.printBalance();
		
		myAccount.deposit(505.22);
		myAccount.printBalance();
		
		myAccount.withdraw(100);
		myAccount.printBalance();
	}

}
