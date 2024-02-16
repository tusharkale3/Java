package util;

import java.time.LocalDate;

class Employee {
 private static int empIdCounter = 1;
 private int empId;
 private String name;
 private LocalDate dateOfJoining;
 private String phoneNumber;
 private String aadhaarNumber;
 public Employee(String name, LocalDate dateOfJoining, String phoneNumber, String 
aadhaarNumber) {
 this.empId = empIdCounter++;
 this.name = name;
 this.dateOfJoining = dateOfJoining;
 this.phoneNumber = phoneNumber;
 this.aadhaarNumber = aadhaarNumber;
 }
 public int getEmpId() {
 return empId;
 }
 public String getName() {
 return name;
 }
 public LocalDate getDateOfJoining() {
 return dateOfJoining;
 }
 public String getPhoneNumber() {
 return phoneNumber;
 }
 public String getAadhaarNumber() {
 return aadhaarNumber;
 }
}

