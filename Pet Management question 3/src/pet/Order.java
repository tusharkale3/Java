package pet;

class Order {
	 private int orderId;
	 private int petId;
	 private int quantity;
	 private Status status;
	 public Order(int orderId, int petId, int quantity, Status status) {
	 this.orderId = orderId;
	 this.petId = petId;
	 this.quantity = quantity;
	 this.status = status;
	 }
	 public int getOrderId() {
	 return orderId;
	 }
	 public int getPetId() {
	 return petId;
	 }
	 public int getQuantity() {
	 return quantity;
	 }
	 public Status getStatus() {
	 return status;
	 }
	 public void setStatus(Status status) {
	 this.status = status;
	 }
	 @Override
	 public String toString() {
	 return "Order ID: " + orderId + ", Pet ID: " + petId + ", Quantity: " + quantity + ", Status: " + status;
	 }
	}