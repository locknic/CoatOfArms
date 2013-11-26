package com.custardgames.coatofarms.shared.entitysystem;

public abstract class Component
{
	private String id;
	
	public Component()
	{
		
	}
	
	public Component(String id)
	{
		this.id = id;
	}
	
	public String getId()
	{
		return this.id;
	}
}
