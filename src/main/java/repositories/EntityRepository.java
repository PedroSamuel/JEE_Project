package repositories;
import java.util.Collection;
import java.util.HashMap;
import java.util.Set;

import model.Entity;

 
public abstract class EntityRepository <T extends Entity> {	
	
	

	private HashMap<Long, T> repository = new HashMap<>(); //public ??
	private Long LargestID = (long) 0;
	
	public Set<Long> getIndexesSet() {
		Set<Long> indexSet = this.repository.keySet();
		return indexSet;
	}
	
	public Long getLargestID() {
		return LargestID;
	}
	
	private Long nextId(){
		return ++LargestID;
	
	}
	
	
	public Long createEntity(T ob){
		ob.setID(nextId());
		repository.put(ob.getID(),ob);
		return LargestID; 
	}
	
	public Collection<T> getEntity(){
		return repository.values();
	}
		
	public T getEntity(long ID) {
		T entity = repository.get(ID);
		return entity;
	}	
	
	public T getEntityPrint(Long ID) {
		T entity = repository.get(Long.valueOf(ID));
		System.out.println(entity);
		return entity;
	}	
	
	public T getEntity(Long ID) {
		T entity = repository.get(ID);
		return entity;
	}	
	

	
	
	public void editEntity(T entity) {
		repository.put(entity.getID(), entity);
	}
	
	public void removeEntity(long ID){
		repository.remove(Long.valueOf(ID));
	}
	
	public void removeEntity(Long ID){
		repository.remove(Long.valueOf(ID));
	}
	
	public void removeEntity(T entity){
		repository.remove(entity.getID());
	}
	

	@Override
	public String toString() {
		return "EntityRepository [repository= " + repository + ", LargestID=" + LargestID + "]";
	}
	
	public HashMap<Long, T> repository() {
		return repository;
	}
	
	
}
	

	

