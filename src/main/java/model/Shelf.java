

package model;

import java.io.Serializable;


public class Shelf extends Entity implements Serializable{

	private static final long serialVersionUID = 3226371929427853898L;
	private int capability; //
	private Product productOnShelf;
	private double rentPrice;
	

	
	//______________________Getters e Setters _________________________ //
	
	public void setCapability(int capability) {
		this.capability = capability;
	}			
		
	public int getCapability() {
		return this.capability;
	}
	
	//
		
	public void setProductOnShelf(Product prod){
		this.productOnShelf = prod;
		//prod.setOnShelf(this);
	}
	
	public Product getProductOnShelf() {
		return this.productOnShelf;
	}
	
	//
		
	public void setRentPrice(double rentPrice) {
		this.rentPrice = rentPrice;
	}
	
	public double getRentPrice() {
		return rentPrice;
	}



	@Override
	public void getDetails() {
//		System.out.println("ID: " + getID());
//		System.out.println("Preço aluguer (diario); " + getRentPrice());
//		if (this.getProductOnShelf() != null){
//			System.out.println("Produto na prateleira: [" + getProductOnShelf() + "]");
//			System.out.println("Quantidade: " + getCapability());
//		} else {
//			System.out.println("Prateleira Vazia");
//		}
		
	}
	
	@Override
	public String toString() {
		return String.format("%d", getID());
				// String.format("%s[id=%d]", getClass().getSimpleName(), getID());
	}
		 
	
}

