package com.custardgames.coatofarms.shared.entitysystem;

public abstract class System
{
	private String id;
	
	public System()
	{
		
	}
	
	public System(String id)
	{
		this.id = id;
	}
	
	public String getId()
	{
		return this.id;
	}
	
	public void tick(long delta)
	{
		
	}
}
