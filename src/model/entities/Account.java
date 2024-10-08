package model.entities;

import java.util.ArrayList;
import java.util.List;

import model.exception.DomainExecption;

public class Account {

		private Integer number;
		private String holder;
		private Double balance;
		private Double withdrawLimit;
		
		 List<Account> accounts = new ArrayList<>();
		
		public Account() {
		}

		public Account(Integer number, String holder, Double balance, Double withdrawLimit) {
			this.number = number;
			this.holder = holder;
			this.balance = balance;
			this.withdrawLimit = withdrawLimit;
		}

		public Integer getNumber() {
			return number;
		}

		public void setNumber(Integer number) {
			this.number = number;
		}

		public String getHolder() {
			return holder;
		}

		public void setHolder(String holder) {
			this.holder = holder;
		}
		
		
		
		public Double getBalance() {
			return balance;
		}

		public Double getWithdrawLimit() {
			return withdrawLimit;
		}

		public void setWithdrawLimit(Double withdrawLimit) {
			this.withdrawLimit = withdrawLimit;
		}

		public void deposit(double amount) {
			balance += amount;
		}
		
		public void withdraw(double amount) throws DomainExecption {
			
			if(balance<amount) {
				throw new DomainExecption("Not enough balance");
			}
			if(amount>withdrawLimit) {
				throw new DomainExecption("The amount execeeds withdraw Limit");
			}
			balance -= amount;
		}
		
		public void addAccount(Account account) {
			accounts.add(account);
		}
		
		public List<Account> getAccount() {
			return new ArrayList<>(accounts);
		}
		
		@Override
	    public String toString() {
	        return "Account" +
	                "Number Account=" + number +
	                ", Holder=" + holder + 
	                ", New balance=" + balance +
	                ", Withdraw Limit=" + withdrawLimit;
		}
		

}
