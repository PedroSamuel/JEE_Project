package control;

import java.util.Collection;

import javax.enterprise.context.RequestScoped;

import model.Shelf;
import repositories.ProductRepository;
import repositories.ShelfRepository;

@RequestScoped
public class ShelfControl {
	private static ShelfRepository sdtb = ShelfRepository.getInstance();


	public void createShelf(Shelf shelf) {
		if (shelf.getProductOnShelf() == null) {
			shelf.setCapability(0);
		} else {
			shelf.getProductOnShelf().getOnShelfs().add(shelf);
			ProductRepository.getInstance().editEntity(shelf.getProductOnShelf());
		}
		sdtb.createEntity(shelf);
	}

	public Collection<Shelf> getshelfs() {
		return sdtb.getEntity();
		
	}

	public void deleteShelf(Shelf shelf) {
		if (shelf.getProductOnShelf() != null) {
			shelf.getProductOnShelf().getOnShelfs().remove(shelf);
			ProductRepository.getInstance().editEntity(shelf.getProductOnShelf());
		}
		sdtb.removeEntity(shelf);
		
	}

	public void editShelf(Shelf shelf) {
		Shelf OnDB = sdtb.getEntity(shelf.getID());
		if (!OnDB.getProductOnShelf().equals(shelf.getProductOnShelf())){
			if (OnDB.getProductOnShelf().getOnShelfs().contains(shelf)) {
			OnDB.getProductOnShelf().getOnShelfs().remove(shelf);
			}
		}
		if (shelf.getProductOnShelf() == null) {
			shelf.setCapability(0);
			if (sdtb.getEntity(shelf.getID()).getProductOnShelf().getOnShelfs().contains(shelf)) {
				sdtb.getEntity(shelf.getID()).getProductOnShelf().getOnShelfs().remove(shelf);
			}
		} else {

			if(!shelf.getProductOnShelf().getOnShelfs().contains(shelf)) {
		}		
				shelf.getProductOnShelf().getOnShelfs().add(shelf);
				ProductRepository.getInstance().editEntity(shelf.getProductOnShelf());
		}
		
		sdtb.editEntity(shelf);
		
	}

}
