package application;

import java.util.Locale;
import java.util.Scanner;

import model.entities.Account;
import model.exception.DomainExecption;

public class Program {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner (System.in);
		
try {
		System.out.println("Enter account data:");
		
		System.out.print("Number:");
		int accountNumber = sc.nextInt();
		sc.nextLine();
		System.out.print("Holder:");
		String holder = sc.nextLine();
		System.out.print("Initial balance:");
		double balance = sc.nextDouble();
		System.out.print("Withdraw Limit:");
		double withdrawLimit = sc.nextDouble();
		
		Account account = new Account(accountNumber, holder, balance, withdrawLimit);
		
		account.addAccount(account);
		
		System.out.println("Enter amount for withdraw:");
		double withdraw = sc.nextDouble();
		
		account.withdraw(withdraw);
		
		for (Account a: account.getAccount()) {
			System.out.println("New balance:" + a.toString());
			
		}
	}
	catch(DomainExecption e){
			System.out.println("Error in resvation:" + e.getMessage());
	}
	catch(RuntimeException e) {
			System.out.println("Unexpected error");
	}

		sc.close();
	}

}
