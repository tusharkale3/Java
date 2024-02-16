package util;

import java.time.LocalDate;
import java.time.Period;
class ProductItem {
 private String itemCode;
 private String description;
 private double price;
 private LocalDate shipmentDate;
 private int availableStock;
 public ProductItem(String itemCode, String description, 
		 double price, LocalDate shipmentDate, int availableStock) {
 this.itemCode = itemCode;
 this.description = description;
 this.price = price;
 this.shipmentDate = shipmentDate;
 this.availableStock = availableStock;
 }
 public String getItemCode() {
 return itemCode;
 }
 public String getDescription() {
 return description;
 }
 public double getPrice() {
 return price;
 }
 public LocalDate getShipmentDate() {
 return shipmentDate;
 }
 public int getAvailableStock() {
 return availableStock;
 }
 public void updateStock(int quantity) {
 availableStock += quantity;
 }
 public boolean isShipmentDueInNextWeek() {
 LocalDate currentDate = LocalDate.now();
 Period period = Period.between(currentDate, shipmentDate);
 return period.getDays() <= 7;
 }
 @Override
 public String toString() {
 return "Item Code: " + itemCode + ", Description: " + description + ", Price:"
 		+ " " + price + ", Shipment Date: " + shipmentDate + ", Available Stock: " + availableStock;
 }
}