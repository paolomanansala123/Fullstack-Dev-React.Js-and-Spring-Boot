package com.accenture.bars.domain;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;

public class Request {
	
	private int billingCycle;
	private LocalDate startDate;
	private LocalDate endDate;
	
	public Request() {
	}

	public Request(int billingCycle, 
						LocalDate startDate, 
						LocalDate endDate) {
		super();
		this.billingCycle = billingCycle;
		this.startDate = startDate;
		this.endDate = endDate;
	}

	public Request(int billingCycle,
					   LocalDateTime startDate, 
					   LocalDateTime endDate) {
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

	@Override
	public int hashCode() {
		return Objects.hash(billingCycle, endDate, startDate);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		
		if (obj == null) {
			return false;
		}
		
		
		if (getClass() != obj.getClass()) {
			return false;	
		}
		
		Request other = (Request) obj;
		return billingCycle == 
				other.billingCycle 
				&& Objects.equals(endDate, other.endDate)
				&& Objects.equals(startDate, other.startDate);
	}



}
