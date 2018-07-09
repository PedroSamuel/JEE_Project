package managedBeans;

import model.Product;
import model.Shelf;

import java.util.Collection;


import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import control.ShelfControl;

@Named("shelfBean")
@RequestScoped
public class ShelfBean{
	

	
	
	private boolean editable;
	
	private Shelf shelf = new Shelf();
	private Product prodOnShelf;
	
	@Inject
	private ShelfControl control;
	


	public Shelf getShelf() {
		return shelf;
	}

	public void setShelf(Shelf shelf) {
		this.shelf = shelf;
	}


	public boolean isEditable() {
		return editable;
	}
	public void setEditable(boolean editable) {
		this.editable = editable;
	}
	
	public void createShelf() {
		this.control.createShelf(this.shelf);
		FacesContext context = FacesContext.getCurrentInstance();
		context.addMessage(null, new FacesMessage("Prateleira Criada"));	
	}
	
	public void editShelf() {
		this.control.editShelf(this.shelf);
		FacesContext context = FacesContext.getCurrentInstance();
		context.addMessage(null, new FacesMessage("Prateleira Editada"));	
	}
	

	public Collection<Shelf> getShelfDB() {
		return control.getshelfs();
	}
	
	public void deleteShelf() {
		this.control.deleteShelf(this.shelf);
		FacesContext context = FacesContext.getCurrentInstance();
		context.addMessage(null, new FacesMessage("Prateleira Eliminada"));
	}
	
	public void addProductToShelf(){
		this.shelf.setProductOnShelf(this.prodOnShelf);
		this.control.editShelf(this.shelf);
		FacesContext context = FacesContext.getCurrentInstance();
		context.addMessage(null, new FacesMessage("Produto Atribuido"));
	}
	

	public Product getProdOnShelf() {
		return prodOnShelf;
	}

	public void setProdOnShelf(Product prodOnShelf) {
		this.prodOnShelf = prodOnShelf;
	}
	/*
	public void removeProductFromShelf(){
		this.shelf.setProductOnShelf(null);
		this.control.editShelf(this.shelf);
		FacesContext context = FacesContext.getCurrentInstance();
		context.addMessage(null, new FacesMessage("Produto Retirado da Prateleira"));
	}
	*/

}

	

