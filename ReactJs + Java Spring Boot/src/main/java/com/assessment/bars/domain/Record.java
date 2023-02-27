package com.accenture.bars.domain;

import java.time.LocalDate;

public class Record {
	
	private int billingCycle;
	private LocalDate startDate;
	private LocalDate endDate;
	private String accountName;
	private String firstName;
	private String lastName;
	private double amount;
	
	public Record() {
	}
	
	
	public Record(int billingCycle, LocalDate startDate, LocalDate enDate, 
			String accountName, String firstName, String lastName, Double amount) {
	}
	

	public int getBillingCycle() {
		return billingCycle;
	}

	public void setBillingCycle(int billingCycle) {
		this.billingCycle = billingCycle;
	}

	public LocalDate getStartDate() {
		return startDate;
	}

	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}

	public LocalDate getEndDate() {
		return endDate;
	}

	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}

	public String getAccountName() {
		return accountName;
	}

	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}
	
	
	
	

}
