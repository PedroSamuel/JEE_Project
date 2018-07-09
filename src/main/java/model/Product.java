package model;

import java.io.Serializable;
import java.util.ArrayList;


public class Product extends Entity implements Serializable{
/**
	 * 
	 */
	private static final long serialVersionUID = 3226371929427853898L;
//	public Product(String name, double rawPrice, double iva, double discount) {
//		this.name = name;
//		this.rawPrice = rawPrice;
//		this.iva = iva;
//		this.discount = discount;
//		this.setPvp();
//		
//	}
	
	

	private String name;
	private ArrayList<Shelf> onShelfs = new ArrayList<>(); 
	private int iva;
	private double rawPrice;
	private int discount;
	private double pvp;
	
	

	public String getName() {
		return name;
	}

	
	public void setName(String name) {
		this.name = name;
	}

	public ArrayList<Shelf> getOnShelfs() {
		return onShelfs;
	}

	public void setOnShelfs(ArrayList<Shelf> onShelfs) {
		this.onShelfs = onShelfs;
	}

	public int getIva() {
		return iva;
	}

	public void setIva(int iva) {
		this.iva = iva;
	}

	public double getRawPrice() {
		return rawPrice;
	}

	public void setRawPrice(double rawPrice) {
		this.rawPrice = rawPrice;
	}

	public int getDiscount() {
		return discount;
	}

	public void setDiscount(int discount) {
		this.discount = discount;
	}

	public double getPvp() {
		return pvp;
	}

	public void setPvp() {
		this.pvp = (this.rawPrice + (this.rawPrice* this.iva/100) - (this.rawPrice * (this.discount/100)));
	}


	@Override
	public void getDetails() {
		// TODO Auto-generated method stub
		
	}


	@Override
	public String toString() {
		return String.format("%d) %s, %s€", getID(), name, pvp);
				// String.format("%s[id=%d]", getClass().getSimpleName(), getID());
		 
	}
	
	




	//______________________Getters e Setters _________________________ //
	




//	@Override
//	public String toString() {
//		
//		return ("ID: " + getID() + ") Nome: " + getName() + ", price: " + pvp + "€, iva: " + (iva*100) + "% ");
//	}
//	
//	@Override
//	public void getDetails(){
//		System.out.println("ID do produto: " + getID());
//		System.out.println("Nome do produto: " + getName());
//		System.out.println("price: " + getprice() + "€");
//		System.out.println("IVA): " + (getIva()*100) + "%");
//		// if (this.onShelfs.size() > 0){
//		try{
//			System.out.print("Producto nas Prateleiras: {");
//			for (Shelf shelf: this.onShelfs){
//				System.out.print("[ID: " + shelf.getID() + ", quantidade: " + shelf.getCapability() + "], ");
//
//			}
//		System.out.println("}");
//		} catch (NullPointerException e){
//			System.out.println("Este produto ainda no existe em nenhuma prateleira. ");
//		}
//		//System.out.println("Desconto Aplicado :");
//	
//	}

	
		
		
		
}
