package managedBeans;

import model.Product;

import java.util.Collection;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.event.RowEditEvent;

import control.ProductControl;

@Named("productBean")
@RequestScoped
public class ProductBean{
	

	
	
	private boolean editable;
	
	private Product product = new Product();
	
	@Inject
	private ProductControl control;
	


	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}


	public boolean isEditable() {
		return editable;
	}
	public void setEditable(boolean editable) {
		this.editable = editable;
	}
	
	public void createProduct() {
		this.control.createProduct(this.product);
		FacesContext context = FacesContext.getCurrentInstance();
		context.addMessage(null, new FacesMessage("Produto Criado"));	
	}
	
	public void editProduct() {
		this.control.editProduct(this.product);
		FacesContext context = FacesContext.getCurrentInstance();
		context.addMessage(null, new FacesMessage("Produto Editado"));	
	}
	

	public Collection<Product> getProductDB() {
		return control.getProducts();
	}
	
	public void deleteProduct() {
		this.control.deleteProduct(this.product);
		FacesContext context = FacesContext.getCurrentInstance();
		context.addMessage(null, new FacesMessage("Produto Eliminado"));	
	}
	
	public List<Integer> getValidIva() {
		return ProductControl.getValidiva();
	}
	
	
	   public void onRowEdit(RowEditEvent event) {
	        FacesMessage msg = new FacesMessage("Produto Editado");
	        FacesContext.getCurrentInstance().addMessage(null, msg);
	    }
	     
	    public void onRowCancel(RowEditEvent event) {
	        FacesMessage msg = new FacesMessage(("Edit Cancelled" + ((Product) event.getObject()).getID()));
	        FacesContext.getCurrentInstance().addMessage(null, msg);
	    }
	    
		public void needProduct(Product product) {
			this.product = product;
		}
}
	

