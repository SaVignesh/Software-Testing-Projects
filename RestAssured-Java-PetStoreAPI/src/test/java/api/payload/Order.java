package api.payload;


import java.time.LocalDateTime;

public class Order {

	
	  
	int id;
	int petId;
	int quantity;
	String shipDate = LocalDateTime.now().toString();
	String status = "placed";
	boolean complete = true;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getPetId() {
		return petId;
	}
	public void setPetId(int petId) {
		this.petId = petId;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public String getShipDate() {
		return shipDate;
	}
	public void setShipDate(String shipDate) {
		this.shipDate = shipDate;
	}
	
	}
	

