package util;

import java.time.LocalDate;

public class FTE extends Employee{
	private double monthlySalary;
	 public FTE(String name, LocalDate dateOfJoining,
			 String phoneNumber, String aadhaarNumber, 
			 double monthlySalary) {
	 super(name, dateOfJoining, phoneNumber, aadhaarNumber);
	 this.monthlySalary = monthlySalary;
	 }
	 public double getMonthlySalary() {
	 return monthlySalary;
	 }
	}

