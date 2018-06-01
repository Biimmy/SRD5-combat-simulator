package entity;

public class Entity {

	protected String name;
	protected int[] location = new int[2];
	
	public String getName()
	{
		return this.name;
	}
	
	public int[] getLocation ()
	{
		return this.location;
	}
	
}
