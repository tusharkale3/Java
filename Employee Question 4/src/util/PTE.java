package util;

import java.time.LocalDate;

public class PTE extends Employee {
	private double hourlyPayment;
	 public PTE(String name, LocalDate dateOfJoining, String phoneNumber, String aadhaarNumber, 
	double hourlyPayment) {
	 super(name, dateOfJoining, phoneNumber, aadhaarNumber);
	 this.hourlyPayment = hourlyPayment;
	 }
	 public double getHourlyPayment() {
	 return hourlyPayment;
	 }

}
