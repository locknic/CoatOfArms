package com.custardgames.coatofarms.shared.entitysystem;

import java.util.UUID;

public abstract class ComponentECS
{
	private String id;
	private String tag;
	
	public ComponentECS(String tag)
	{
		id = UUID.randomUUID().toString().replaceAll("-", "");
		this.tag = tag;
	}
	
	public String getId()
	{
		return this.id;
	}
	
	public String getTag()
	{
		return this.tag;
	}
}
