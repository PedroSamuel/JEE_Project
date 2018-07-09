package model;



public abstract class Entity{
	

	

	private long ID;
	
	public Entity() {
	}

	public long getID(){
		return this.ID;
	}
	
	public Long getLID(){
		return this.ID;
	}
	
	public void setID(long ID) {
		this.ID = ID;
	}
	
	public abstract void getDetails();
	
	 @Override
	    public int hashCode() {
	        return ((this.getLID()) != null) 
	            ? (getClass().getSimpleName().hashCode() + (getLID()).hashCode())
	            : super.hashCode();
	    }

	    @Override
	    public boolean equals(Object other) {
	        return (other != null && this.getLID() != null)
	            ? this.getLID().equals(((Entity) other).getLID())
	            : (other == this);
	    }
	
	
}
