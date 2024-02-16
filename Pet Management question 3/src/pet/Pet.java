package pet;

public class Pet {
	 private int petId;
	 private String name;
	 private Category category;
	 private double unitPrice;
	 private int stocks;
	 public Pet(int petId, String name, Category category, double unitPrice, int stocks) {
	 this.petId = petId;
	 this.name = name;
	 this.category = category;
	 this.unitPrice = unitPrice;
	 this.stocks = stocks;
	 }
	 public int getPetId() {
	 return petId;
	 }
	 public String getName() {
	 return name;
	 }
	 public Category getCategory() {
	 return category;
	 }
	 public double getUnitPrice() {
	 return unitPrice;
	 }
	 
	 public void setUnitPrice(double unitPrice) {
		this.unitPrice = unitPrice;
	}
	public int getStocks() {
	 return stocks;
	 }
	 public void setStocks(int stocks) {
	 this.stocks = stocks;
	 }
	 @Override
	 public String toString() {
	 return "Pet ID: " + petId + ", Name: " + name + ", Category: " + category + ", Price: " + unitPrice + 
	", Stocks: " + stocks;
	 }

}
